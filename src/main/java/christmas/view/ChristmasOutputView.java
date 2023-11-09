package christmas.view;

import java.util.Map;
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
}
