package christmas.domain.menu;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;

import static christmas.domain.menu.MenuType.*;

public enum OrderMenu {

    MUSHROOM_SOUP("양송이수프", APPETIZER, 6_000L, (menuType) -> menuType.equals("에피타이저")),
    TAPAS("타파스", APPETIZER, 5_500L, (menuType) -> menuType.equals("에피타이저")),
    CAESAR_SALAD("시저샐러드", APPETIZER, 8_000L, (menuType) -> menuType.equals("에피타이저")),

    TBONE_STEAK("티본스테이크", MAIN, 55_000L, (menuType) -> menuType.equals("메인")),
    BARBECUE_RIBS("바비큐립", MAIN, 54_000L, (menuType) -> menuType.equals("메인")),
    SEAFOOD_PASTA("해산물파스타", MAIN, 35_000L, (menuType) -> menuType.equals("메인")),
    CHRISTMAS_PASTA("크리스마스파스타", MAIN, 25_000L, (menuType) -> menuType.equals("메인")),

    CHOCOLATE_CAKE("초코케이크", DESSERT, 15_000L, (menuType) -> menuType.equals("디저트")),
    ICE_CREAM("아이스크림", DESSERT, 5_000L, (menuType) -> menuType.equals("디저트")),

    ZERO_COKE("제로콜라", DRINK, 3_000L, (menuType) -> menuType.equals("음료")),
    RED_WINE("레드와인", DRINK, 60_000L, (menuType) -> menuType.equals("음료")),
    CHAMPAGNE("샴페인", DRINK, 25_000L, (menuType) -> menuType.equals("음료")),
    ;

    private final String MenuName;
    private final MenuType MenuType;
    private final Long MenuPrice;
    private final Function<String, Boolean> function;

    OrderMenu(String menuName, MenuType menuType, Long menuPrice, Function<String, Boolean> function) {
        MenuName = menuName;
        MenuType = menuType;
        MenuPrice = menuPrice;
        this.function = function;
    }

    public String getMenuName() {
        return MenuName;
    }

    public MenuType getMenuType() {
        return MenuType;
    }

    public Long getMenuPrice() {
        return MenuPrice;
    }

    public Function<String, Boolean> getFunction() {
        return function;
    }

    public static OrderMenu getOrderMenu(String orderName) {
        return Arrays.stream(OrderMenu.values())
                .filter(orderMenu -> orderMenu.getMenuName().equals(orderName))
                .findFirst()
                .orElse(null);
    }

    public static OrderMenu fromMenuName(String menuName) {
        return Arrays.stream(OrderMenu.values())
                .filter(orderMenu -> orderMenu.getMenuName().equals(menuName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }
}
