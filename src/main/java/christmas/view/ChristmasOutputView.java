package christmas.view;

import christmas.domain.OrderSheet;
import christmas.domain.badge.Badge;
import christmas.domain.detail.BenefitDetail;
import christmas.domain.menu.Event;

import java.text.DecimalFormat;
import java.util.Map;

import static christmas.global.OutputMessage.*;

public class ChristmasOutputView {

    public void printEventInformation() {
        System.out.println(EVENT_PREVIEW.getMessage());
    }

//    public void printOrderMenuAndCounts(Set<Map.Entry<String, Integer>> orderMenus) {
//        System.out.println();
//        System.out.println("<주문 메뉴>");
//        for (Map.Entry<String, Integer> orderMenu : orderMenus) {
//            System.out.println(orderMenu.getKey() + " " + orderMenu.getValue());
//        }
//    }

    public void printTotalAmountBeforeDiscount(Integer amountBeforeDiscount) {
        DecimalFormat formatter = new DecimalFormat("###,###,###");

        System.out.println();
        System.out.println(TOTAL_PRICE_BEFORE_DISCOUNT.getMessage());

        System.out.println(formatter.format(amountBeforeDiscount) + "원");
    }

    public void printGiveMenu(Event event) {
        System.out.println();
        System.out.println(GIVE_MENU.getMessage());

        if (event == Event.NOTING) {
            System.out.println(event.getGiveMenuName());
            return;
        }

        System.out.println(event.getGiveMenuName() + " 1개");
    }

//    public void printBenefitDetails(int totalCount, int christmasDiscountAmount, int weekdayDiscountAmount, int weekendDiscountAmount, int specialDiscountAmount, int giveDiscountAmount) {
//        DecimalFormat formatter = new DecimalFormat("###,###,###");
//
//        System.out.println();
//        System.out.println("<혜택 내역>");
//        if (totalCount > 0 && totalCount < 10000) {
//            System.out.println("없음");
//            return;
//        }
//
//        if (christmasDiscountAmount != 0) {
//            System.out.println("크리스마스 디데이 할인: -" + formatter.format(christmasDiscountAmount) + "원");
//        }
//
//        if (weekdayDiscountAmount != 0) {
//            System.out.println("평일 할인: -" + formatter.format(christmasDiscountAmount) + "원");
//        }
//
//        if (weekendDiscountAmount != 0) {
//            System.out.println("주말 할인: -" + formatter.format(christmasDiscountAmount) + "원");
//        }
//
//        if (specialDiscountAmount != 0) {
//            System.out.println("특별 할인: -" + formatter.format(christmasDiscountAmount) + "원");
//        }
//
//        if (giveDiscountAmount != 0) {
//            System.out.println("증정 이벤트: -" + formatter.format(christmasDiscountAmount) + "원");
//        }
//
//    }

    public void printBenefitDetails(BenefitDetail benefitDetail) {
        DecimalFormat formatter = new DecimalFormat("###,###,###");

        System.out.println();
        System.out.println(EVENT_DETAILS.getMessage());

        if (benefitDetail.getEvent() == Event.NOTING) {
            System.out.println(NOTING.getMessage());
            return;
        }

        benefitDetail.getDetails()
                .forEach((key, value) -> System.out.println(key + formatter.format(value) + "원"));

        System.out.println("증정 이벤트: -" + formatter.format(benefitDetail.getEvent().getDiscountPrice()) + "원");
    }


    public void totalDiscountAmount(int totalDiscountAmount) {
        DecimalFormat formatter = new DecimalFormat("###,###,###");

        System.out.println();
        System.out.println("<총혜택 금액>");

        if (totalDiscountAmount < 10_000) {
            System.out.println("없음");
            return;
        }

        System.out.println("-" + formatter.format(totalDiscountAmount) + "원");
    }

    public void printAfterDiscountAmount(BenefitDetail benefitDetail, int beforeDiscountPrice) {
        DecimalFormat formatter = new DecimalFormat("###,###,###");

        System.out.println();
        System.out.println("<할인 후 예상 결제 금액>");

        if (benefitDetail.getTotalBenefitPrice() < 10_000) {
            System.out.println(NOTING.getMessage());
            return;
        }

        System.out.println(formatter.format(beforeDiscountPrice - benefitDetail.getTotalBenefitPrice()) + "원");
    }

    public void printEventBadge(Badge badge) {
        System.out.println();
        System.out.println("<12월 이벤트 배지>");
        System.out.println(badge.getBadgeName());
    }

    public void printOrderMenusAndCounts(OrderSheet orderSheet) {
        System.out.println();
        System.out.println(ORDER_MENU.getMessage());
        orderSheet.getOrders()
                .forEach((key, value) -> System.out.println(key.getMenuName() + " " + value + "개"));
    }
}
