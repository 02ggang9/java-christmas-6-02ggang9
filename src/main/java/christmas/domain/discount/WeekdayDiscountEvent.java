package christmas.domain.discount;

import java.util.ArrayList;
import java.util.List;

public class WeekdayDiscountEvent {

    List<Integer> days = List.of(3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 17, 18, 19, 20, 21, 24, 25, 26, 27, 28, 31);

    private static final Integer BASE_DISCOUNT_AMOUNT = 2023;

    public int discountAmount(int dateOfVisit, int dessertCount) {
        if (days.contains(dateOfVisit)) {
            return BASE_DISCOUNT_AMOUNT * dessertCount;
        }

        return 0;
    }


}
