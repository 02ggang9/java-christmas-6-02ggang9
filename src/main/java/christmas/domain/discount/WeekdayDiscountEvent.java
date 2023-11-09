package christmas.domain.discount;

import java.util.ArrayList;

public class WeekdayDiscountEvent {

    private static final Integer BASE_DISCOUNT_AMOUNT = 2023;

    public int discountAmount(int dessertCount) {
        return BASE_DISCOUNT_AMOUNT * dessertCount;
    }


}
