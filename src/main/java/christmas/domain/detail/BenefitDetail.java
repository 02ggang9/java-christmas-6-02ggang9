package christmas.domain.detail;

import christmas.domain.OrderSheet;
import christmas.domain.discount.*;
import christmas.domain.discountpolicy.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BenefitDetail {

    private static final List<Discount> events = List.of(
            new ChristmasDiscountEvent(new ChristmasDiscountPolicy()),
            new GiveMenuDiscountEvent(new GiveMenuDiscountPolicy()),
            new SpecialDiscountEvent(new SpecialDiscountPolicy()),
            new WeekdayDiscountEvent(new WeekdayDiscountPolicy()),
            new WeekendDiscountEvent(new WeekendDiscountPolicy())
    );

    private final Map<String, Integer> details = new HashMap<>();

    public BenefitDetail() {
    }

    public void saveEventDetails(OrderSheet orderSheet) {
        for (Discount event : events) {
            event.calculateDiscountAndSaveDetail(this, orderSheet);
        }
    }

    public void saveEvent(String eventName, int discountPrice) {
        details.put(eventName, discountPrice);
    }

    public Map<String, Integer> getDetails() {
        return details;
    }

    public int getTotalDiscountPrice() {
        return details.values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
