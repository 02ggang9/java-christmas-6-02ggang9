package christmas.view;

import christmas.domain.OrderSheet;
import christmas.domain.menu.GiveMenu;
import christmas.domain.menu.OrderMenu;
import christmas.global.OutputMessage;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.Set;

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
        System.out.println("<할인 전 총주문 금액>");

        System.out.println(formatter.format(amountBeforeDiscount) + "원");
    }

    public void printGiveMenu(GiveMenu giveMenu) {
        System.out.println();
        System.out.println("<증정 메뉴>");
        if (giveMenu == GiveMenu.NOTING) {
            System.out.println("없음");
            return;
        }

        System.out.println("샴페인 1개");
    }

    public void printBenefitDetails(int totalCount, int christmasDiscountAmount, int weekdayDiscountAmount, int weekendDiscountAmount, int specialDiscountAmount, int giveDiscountAmount) {
        DecimalFormat formatter = new DecimalFormat("###,###,###");

        System.out.println();
        System.out.println("<혜택 내역>");
        if (totalCount > 0 && totalCount < 10000) {
            System.out.println("없음");
            return;
        }

        if (christmasDiscountAmount != 0) {
            System.out.println("크리스마스 디데이 할인: -" + formatter.format(christmasDiscountAmount) + "원");
        }

        if (weekdayDiscountAmount != 0) {
            System.out.println("평일 할인: -" + formatter.format(christmasDiscountAmount) + "원");
        }

        if (weekendDiscountAmount != 0) {
            System.out.println("주말 할인: -" + formatter.format(christmasDiscountAmount) + "원");
        }

        if (specialDiscountAmount != 0) {
            System.out.println("특별 할인: -" + formatter.format(christmasDiscountAmount) + "원");
        }

        if (giveDiscountAmount != 0) {
            System.out.println("증정 이벤트: -" + formatter.format(christmasDiscountAmount) + "원");
        }

    }

    public void totalDiscountAmount(int totalDiscountAmount) {
        DecimalFormat formatter = new DecimalFormat("###,###,###");

        System.out.println();
        System.out.println("<총혜택 금액>");

        if (totalDiscountAmount == 0) {
            System.out.println("없음");
            return;
        }

        System.out.println("-" + formatter.format(totalDiscountAmount) + "원");
    }

    public void printAfterDiscountAmount(int afterDiscountAmount) {
        DecimalFormat formatter = new DecimalFormat("###,###,###");

        System.out.println();
        System.out.println("<할인 후 예상 결제 금액>");

        System.out.println(formatter.format(afterDiscountAmount) + "원");
    }

    public void printEventBadge(int totalDiscountAmount) {
        DecimalFormat formatter = new DecimalFormat("###,###,###");

        System.out.println();
        System.out.println("<12월 이벤트 배지>");

        if (totalDiscountAmount > 0 && totalDiscountAmount < 5000) {
            System.out.println("없음");
            return;
        }

        if (totalDiscountAmount >= 5000 && totalDiscountAmount < 10000) {
            System.out.println("별");
        }

        if (totalDiscountAmount >= 10000 && totalDiscountAmount < 20000) {
            System.out.println("트리");
        }

        if (totalDiscountAmount >= 20000) {
            System.out.println("산타");
        }


    }

    public void printOrderMenusAndCounts(OrderSheet orderSheet) {
        System.out.println();
        System.out.println(ORDER_MENU.getMessage());
        orderSheet.getOrders()
                .forEach((key, value) -> System.out.println(key.getMenuName() + " " + value + "개"));
    }
}
