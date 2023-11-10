package christmas.domain.menu;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public enum GiveMenu {

    CHAMPAGNE("샴페인", 120_000L, (amount) -> amount > 120_000L),
    NOTING("없음", 0L, (amount) -> amount > 0L),
    ;

    private final String giveMenuName;
    private final Long overPrice;
    private final Function<Integer, Boolean> function;

    GiveMenu(String giveMenuName, Long overPrice, Function<Integer, Boolean> function) {
        this.giveMenuName = giveMenuName;
        this.overPrice = overPrice;
        this.function = function;
    }

    public String getGiveMenuName() {
        return giveMenuName;
    }

    public Long getOverPrice() {
        return overPrice;
    }

    public Function<Integer, Boolean> getFunction() {
        return function;
    }

//    public boolean isOver(Integer amount) {
//        return function.apply(amount);
//    }

    public static GiveMenu getGiveMenu(Integer totalPrice) {
        return Arrays.stream(GiveMenu.values())
                .filter(giveMenu -> giveMenu.function.apply(totalPrice))
                .findFirst()
                .orElse(NOTING);
    }

//    public boolean isOverGiveMenuPrice(GiveMenu giveMenu) {
//        return GiveMenu.CHAMPAGNE.getOverPrice() >
//    }
}
