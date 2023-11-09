package christmas.domain.discount;

import java.util.ArrayList;
import java.util.List;

public class SpecialDiscountEvent {

    List<Integer> days = List.of(3, 10, 17, 24, 25, 31);

    private static final int BASE_DISCOUNT_AMOUNT = 1000;

    public int discountAmount(int dateOfVisit) {
        if (days.contains(dateOfVisit)) {
            return BASE_DISCOUNT_AMOUNT;
        }

        return 0;
    }

}
