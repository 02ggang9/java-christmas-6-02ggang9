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

    public Integer calculateTotalAmount() {
        OrderSheet findOrderSheet = christmasOrderMenuRepository.findOrderSheetById(0L);
        return findOrderSheet.calculateTotalPrice();
    }

    public GiveMenu getGiveMenu(Integer price) {
        return GiveMenu.getGiveMenu(price);
    }

    public OrderSheet findOrderSheet() {
        return christmasOrderMenuRepository.findOrderSheetById(0L);
    }
}
