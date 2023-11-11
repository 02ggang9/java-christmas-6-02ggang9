package christmas.domain.discount;

import christmas.domain.OrderSheet;
import christmas.domain.detail.EventDetail;
import christmas.domain.discountpolicy.DiscountPolicy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Discount {
    protected List<DiscountPolicy> policies;

    public Discount(DiscountPolicy ... policies) {
        this.policies = Arrays.asList(policies);
    }

    public abstract void calculateDiscountAndSaveDetail(EventDetail eventDetail, OrderSheet orderSheet);
}
