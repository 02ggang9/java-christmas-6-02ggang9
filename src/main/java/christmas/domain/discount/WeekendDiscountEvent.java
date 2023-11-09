package christmas.domain.discount;

import java.util.List;

public class WeekendDiscountEvent {

    List<Integer> days = List.of(1, 2, 8, 9, 15, 16, 22, 23, 29, 30);

    private static final int BASE_DISCOUNT_AMOUNT = 2023;

    public int discountAmount(int dateOfVisit, int mainMenuCount) {
        if (days.contains(dateOfVisit)) {
            return BASE_DISCOUNT_AMOUNT * mainMenuCount;
        }

        return 0;
    }
}
