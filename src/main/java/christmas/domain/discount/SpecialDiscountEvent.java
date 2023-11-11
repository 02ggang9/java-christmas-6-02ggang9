package christmas.domain.discount;

import christmas.domain.OrderSheet;
import christmas.domain.detail.EventDetail;
import christmas.domain.discountpolicy.DiscountPolicy;

import java.util.ArrayList;
import java.util.List;

public class SpecialDiscountEvent extends Discount {

    private static final String DISCOUNT_NAME = "특별 할인: -";
    private static final int BASE_DISCOUNT_AMOUNT = 1000;

    public SpecialDiscountEvent(DiscountPolicy... policies) {
        super(policies);
    }

    @Override
    public void calculateDiscountAndSaveDetail(EventDetail eventDetail, OrderSheet orderSheet) {
        for (DiscountPolicy policy : policies) {
            if (policy.isSatisfiedBy(orderSheet)) {
                eventDetail.saveEvent(DISCOUNT_NAME, discountPrice(orderSheet));
            }
        }
    }

    private int discountPrice(OrderSheet orderSheet) {
        return BASE_DISCOUNT_AMOUNT;
    }
}
