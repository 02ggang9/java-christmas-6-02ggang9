package christmas.domain.menu;

import java.util.Arrays;
import java.util.function.Function;

public enum Event {

    CHAMPAGNE("샴페인", 25_000L, (amount) -> amount > 120_000L),
    NOTING("없음", 0L, (amount) -> amount > 0L),
    ;

    private final String giveMenuName;
    private final Long discountPrice;
    private final Function<Integer, Boolean> function;

    Event(String giveMenuName, Long overPrice, Function<Integer, Boolean> function) {
        this.giveMenuName = giveMenuName;
        this.discountPrice = overPrice;
        this.function = function;
    }

    public String getGiveMenuName() {
        return giveMenuName;
    }

    public Long getDiscountPrice() {
        return discountPrice;
    }

    public Function<Integer, Boolean> getFunction() {
        return function;
    }

    public static Event getGiveMenu(Integer totalPrice) {
        return Arrays.stream(Event.values())
                .filter(event -> event.function.apply(totalPrice))
                .findFirst()
                .orElse(NOTING);
    }
}
