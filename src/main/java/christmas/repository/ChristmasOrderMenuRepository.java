package christmas.repository;

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
}
