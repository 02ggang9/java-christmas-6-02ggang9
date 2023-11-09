package christmas.view;

import christmas.domain.GiveMenu;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class ChristmasOutputView {

    public void printEventInformation() {
        System.out.println("12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
    }

    public void printOrderMenuAndCounts(Set<Map.Entry<String, Integer>> orderMenus) {
        System.out.println();
        System.out.println("<주문 메뉴>");
        for (Map.Entry<String, Integer> orderMenu : orderMenus) {
            System.out.println(orderMenu.getKey() + " " + orderMenu.getValue());
        }
    }

    public void printTotalAmountBeforeDiscount(Integer amountBeforeDiscount) {
        DecimalFormat formatter = new DecimalFormat("###,###,###");

        System.out.println();
        System.out.println("<할인 전 총주문 금액>");

        System.out.println(formatter.format(amountBeforeDiscount) + "원");
    }

    public void printGiveMenu(Optional<GiveMenu> giveMenu) {
        System.out.println();
        if (giveMenu.isEmpty()) {
            System.out.println("없음");
        }

        System.out.println("샴페인 1개");
    }
}
