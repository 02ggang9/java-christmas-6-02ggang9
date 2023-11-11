package christmas.domain;

import christmas.domain.menu.OrderMenu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class OrderSheet {

    private final Map<OrderMenu, Integer> orders = new HashMap<>();
    private final int dateOfVisit;

    public OrderSheet(List<String> menus, List<Integer> counts, int dateOfVisit) {
        this.dateOfVisit = dateOfVisit;
        IntStream.range(0, menus.size())
                .forEach(i -> orders.put(OrderMenu.fromMenuName(menus.get(i)), counts.get(i)));
    }

    public Integer calculateTotalPrice() {
        int totalPrice = 0;
        for (Map.Entry<OrderMenu, Integer> entry : orders.entrySet()) {
            totalPrice += entry.getKey().calculatePrice(entry.getValue());
        }

        return totalPrice;
//        orders.entrySet()
//                .forEach((key, value) -> key.getKey().calculatePrice(value));
    }

    public Map<OrderMenu, Integer> getOrders() {
        return orders;
    }

    public int getDateOfVisit() {
        return dateOfVisit;
    }
}
