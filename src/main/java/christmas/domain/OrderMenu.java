package christmas.domain;

import java.util.function.Function;

public enum OrderMenu {

    // 애피타이저
    MUSHROOM_SOUP("양송이수프", "에피타이저", 6_000L, (menuType) -> menuType.equals("에피타이저")),
    TAPAS("타파스", "에피타이저", 5_500L, (menuType) -> menuType.equals("에피타이저")),
    CAESAR_SALAD("시저샐러드", "에피타이저", 8_000L, (menuType) -> menuType.equals("에피타이저")),

    // 메인
    TBONE_STEAK("티본스테이크", "메인", 55_000L, (menuType) -> menuType.equals("메인")),
    BARBECUE_RIBS("바비큐립", "메인", 54_000L, (menuType) -> menuType.equals("메인")),
    SEAFOOD_PASTA("해산물파스타", "메인", 35_000L, (menuType) -> menuType.equals("메인")),
    CHRISTMAS_PASTA("크리스마스파스타", "메인", 25_000L, (menuType) -> menuType.equals("메인")),

    // 디저트
    CHOCOLATE_CAKE("초코케이크", "디저트", 15_000L, (menuType) -> menuType.equals("디저트")),
    ICE_CREAM("아이스크림", "디저트", 5_000L, (menuType) -> menuType.equals("디저트")),

    // 음료
    ZERO_COKE("제로콜라", "음료", 3_000L, (menuType) -> menuType.equals("음료")),
    RED_WINE("레드와인", "음료", 60_000L, (menuType) -> menuType.equals("음료")),
    CHAMPAGNE("샴페인", "음료", 25_000L, (menuType) -> menuType.equals("음료")),
    ;

    private final String MenuName;
    private final String MenuType;
    private final Long MenuPrice;
    private final Function<String, Boolean> function;

    OrderMenu(String menuName, String menuType, Long menuPrice, Function<String, Boolean> function) {
        MenuName = menuName;
        MenuType = menuType;
        MenuPrice = menuPrice;
        this.function = function;
    }

    public String getMenuName() {
        return MenuName;
    }

    public String getMenuType() {
        return MenuType;
    }

    public Long getMenuPrice() {
        return MenuPrice;
    }

    public Function<String, Boolean> getFunction() {
        return function;
    }
}
