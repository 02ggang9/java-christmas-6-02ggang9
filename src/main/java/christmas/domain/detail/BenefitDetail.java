package christmas.domain.detail;

import christmas.domain.OrderSheet;
import christmas.domain.discount.*;
import christmas.domain.discountpolicy.*;
import christmas.domain.event.GiveMenuDiscountEvent;
import christmas.domain.menu.Event;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BenefitDetail {

    private static final List<Discount> discounts = List.of(
            new ChristmasDiscount(new ChristmasDiscountPolicy()),
            new GiveMenuDiscountEvent(new GiveMenuDiscountPolicy()),
            new SpecialDiscount(new SpecialDiscountPolicy()),
            new WeekdayDiscount(new WeekdayDiscountPolicy()),
            new WeekendDiscount(new WeekendDiscountPolicy())
    );

    private final Map<String, Integer> details = new HashMap<>();
    private final Event event = Event.NOTING;

    public BenefitDetail() {
    }

    public void saveEventDetails(OrderSheet orderSheet) {
        for (Discount event : discounts) {
            event.calculateDiscountAndSaveDetail(this, orderSheet);
        }
    }

    public void saveEvent(String eventName, int discountPrice) {
        details.put(eventName, discountPrice);
    }

    public Map<String, Integer> getDetails() {
        return details;
    }

    public Event getEvent() {
        return event;
    }

    public int getTotalDiscountPrice() {
        return details.values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
