package christmas.domain.discount;

public class ChristmasDiscountEvent {

    private static final Integer BASE_DISCOUNT_AMOUNT = 1000;


    public static int discountAmount(int dateOfVisit) {
        return BASE_DISCOUNT_AMOUNT + ((dateOfVisit-1) * 100);
    }
}
