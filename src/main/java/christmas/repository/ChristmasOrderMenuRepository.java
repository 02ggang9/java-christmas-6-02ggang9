package christmas.repository;

import christmas.domain.OrderMenu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ChristmasOrderMenuRepository {

    private final Map<String, Integer> orderMenuDatabase = new HashMap<>();

    public void saveOrderMenus(List<String> orderMenus, List<String> orderMenusCounts) {

        for (int i = 0; i < orderMenus.size(); i++) {
            orderMenuDatabase.put(orderMenus.get(i), Integer.parseInt(orderMenusCounts.get(i)));
        }

    }

    public Set<Map.Entry<String, Integer>> findAllMenusAndCounts() {
        return orderMenuDatabase.entrySet();
    }

    public int findDessertCount() {
        Set<Map.Entry<String, Integer>> entries = orderMenuDatabase.entrySet();
        int result = 0;
        for (Map.Entry<String, Integer> entry : entries) {
            String key = entry.getKey();
            if (key.matches("티본스테이크|바비큐립|해산물파스타|크리스마스파스타")) {
                result += entry.getValue();
            }
        }
        return result;
    }
}
