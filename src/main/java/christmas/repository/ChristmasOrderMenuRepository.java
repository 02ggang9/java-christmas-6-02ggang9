package christmas.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChristmasOrderMenuRepository {

    private final Map<String, Integer> orderMenuDatabase = new HashMap<>();

    public void saveOrderMenus(List<String> orderMenus, List<String> orderMenusCounts) {

        for (int i = 0; i < orderMenus.size(); i++) {
            orderMenuDatabase.put(orderMenus.get(i), Integer.parseInt(orderMenusCounts.get(i)));
        }

    }
}
