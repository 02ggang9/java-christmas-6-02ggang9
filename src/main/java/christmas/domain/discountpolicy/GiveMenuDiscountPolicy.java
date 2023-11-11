package christmas.domain.discountpolicy;

import christmas.domain.OrderSheet;

public class GiveMenuDiscountPolicy implements DiscountPolicy {
    @Override
    public boolean isSatisfiedBy(OrderSheet orderSheet) {
        return orderSheet.calculateTotalPrice() >= 25000;
    }
}
