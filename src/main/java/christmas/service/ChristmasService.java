package christmas.service;

import christmas.domain.OrderSheet;
import christmas.domain.menu.GiveMenu;
import christmas.domain.menu.OrderMenu;
import christmas.domain.discount.ChristmasDiscountEvent;
import christmas.domain.discount.SpecialDiscountEvent;
import christmas.domain.discount.WeekdayDiscountEvent;
import christmas.domain.discount.WeekendDiscountEvent;
import christmas.repository.ChristmasDateOfVisitRepository;
import christmas.repository.ChristmasOrderMenuRepository;

import java.util.Map;
import java.util.Set;

public class ChristmasService {

    private final ChristmasDateOfVisitRepository repository = new ChristmasDateOfVisitRepository();
    private final ChristmasOrderMenuRepository christmasOrderMenuRepository = new ChristmasOrderMenuRepository();

    public void saveDateOfVisit(int dateOfVisit) {
        repository.saveDateOfVisit(dateOfVisit);
    }

//    public Integer calculateTotalAmount(Set<Map.Entry<String, Integer>> orderMenus) {
//        int totalAmount = 0;
//        for (Map.Entry<String, Integer> orderMenu : orderMenus) {
//            OrderMenu menu = OrderMenu.getOrderMenu(orderMenu.getKey());
//            totalAmount += (orderMenu.getValue() * menu.getMenuPrice());
//        }
//
//        return totalAmount;
//    }

    public Integer calculateTotalAmount() {
        OrderSheet findOrderSheet = christmasOrderMenuRepository.findOrderSheetById(0L);
        return findOrderSheet.calculateTotalPrice();
    }

//    public GiveMenu getGiveMenu(Integer amount) {
//        if (GiveMenu.CHAMPAGNE.isOver(amount)) {
//            return GiveMenu.CHAMPAGNE;
//        }
//
//        return GiveMenu.NOTING;
//    }

    public GiveMenu getGiveMenu(Integer price) {
        return GiveMenu.getGiveMenu(price);
    }

//    public int getChristmasDiscountAmount() {
//        int dateOfVisit = repository.findDateOfVisit();
//        return ChristmasDiscountEvent.discountAmount(dateOfVisit);
//    }

    public int getWeekdayDiscountAmount() {
        WeekdayDiscountEvent weekdayDiscountEvent = new WeekdayDiscountEvent();
        int dateOfVisit = repository.findDateOfVisit();
        int dessertCount = christmasOrderMenuRepository.findDessertCount();
        return weekdayDiscountEvent.discountAmount(dateOfVisit, dessertCount);
    }

    public int getWeekendDiscountAmount() {
        WeekendDiscountEvent weekendDiscountEvent = new WeekendDiscountEvent();
        int dateOfVisit = repository.findDateOfVisit();
        int mainCount = christmasOrderMenuRepository.findMainCount();
        return weekendDiscountEvent.discountAmount(dateOfVisit, mainCount);
    }

    public int getSpecialDiscountAmount() {
        SpecialDiscountEvent specialDiscountEvent = new SpecialDiscountEvent();
        int dateOfVisit = repository.findDateOfVisit();
        return specialDiscountEvent.discountAmount(dateOfVisit);
    }

    public OrderSheet findOrderSheet() {
        return christmasOrderMenuRepository.findOrderSheetById(0L);
    }
}
