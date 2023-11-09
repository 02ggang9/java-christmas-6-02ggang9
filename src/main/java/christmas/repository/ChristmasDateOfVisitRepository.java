package christmas.repository;

import java.util.HashMap;
import java.util.Map;

public class ChristmasDateOfVisitRepository {

    private Long userId;
    private final Map<Long, Integer> dateOfVisitDatabase = new HashMap<>();

    public ChristmasDateOfVisitRepository() {
        this.userId = 0L;
    }

    public void saveDateOfVisit(int dateOfVisit) {
        dateOfVisitDatabase.put(userId, dateOfVisit);
        userId++;
    }

    public int findDateOfVisit() {
        return dateOfVisitDatabase.get(0L);
    }
}
