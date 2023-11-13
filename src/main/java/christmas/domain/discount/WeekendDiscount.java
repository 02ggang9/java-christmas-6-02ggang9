package christmas.domain.discount;

import christmas.domain.OrderSheet;
import christmas.domain.detail.BenefitDetail;
import christmas.domain.discountpolicy.DiscountPolicy;
import christmas.domain.menu.MenuType;

import java.util.Map;

public class WeekendDiscount extends Discount {

    private static final String DISCOUNT_NAME = "주말 할인: -";
    private static final int BASE_DISCOUNT_AMOUNT = 2023;

    public WeekendDiscount(DiscountPolicy... policies) {
        super(policies);
    }

    @Override
    protected void calculateAndSave(BenefitDetail benefitDetail, OrderSheet orderSheet) {
        benefitDetail.saveEvent(DISCOUNT_NAME, discountPrice(orderSheet));
    }

    private int discountPrice(OrderSheet orderSheet) {
        return BASE_DISCOUNT_AMOUNT * orderSheet.getOrders()
                .entrySet()
                .stream()
                .filter(o -> o.getKey().getMenuType() == MenuType.MAIN)
                .mapToInt(Map.Entry::getValue)
                .sum();
    }
}
