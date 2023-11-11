package christmas.domain.discount;

import christmas.domain.OrderSheet;
import christmas.domain.detail.EventDetail;
import christmas.domain.discountpolicy.DiscountPolicy;

public class ChristmasDiscountEvent extends Discount{

    private static final Integer BASE_DISCOUNT_AMOUNT = 1000;
    private static final String DISCOUNT_NAME = "크리스마스 디데이 할인: -";

    public int discountAmount(int dateOfVisit) {
        return BASE_DISCOUNT_AMOUNT + ((dateOfVisit-1) * 100);
    }

    public ChristmasDiscountEvent(DiscountPolicy... policies) {
        super(policies);
    }

    @Override
    public void calculateDiscountAndSaveDetail(EventDetail eventDetail, OrderSheet orderSheet) {
        for (DiscountPolicy policy : policies) {
            if (policy.isSatisfiedBy(orderSheet)) {
                eventDetail.saveEvent(DISCOUNT_NAME, discountPrice(orderSheet.getDateOfVisit()));
            }
        }
    }

    private int discountPrice(int dateOfVisit) {
        return BASE_DISCOUNT_AMOUNT + ((dateOfVisit-1) * 100);
    }
}
