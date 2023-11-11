package christmas.domain.detail;

import christmas.domain.OrderSheet;
import christmas.domain.discount.ChristmasDiscountEvent;
import christmas.domain.discount.Discount;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EventDetail {

    private static final List<Discount> events = List.of(
            new ChristmasDiscountEvent()
    );
    private final Map<String, Integer> details;

    public EventDetail(Map<String, Integer> details) {
        this.details = details;
    }

    public void saveEventDetails(OrderSheet orderSheet) {
        for (Discount event : events) {
            event.calculateDiscountAndSaveDetail(this, orderSheet);
        }
    }

    public void saveEvent(String eventName, int discountPrice) {

    }
}
