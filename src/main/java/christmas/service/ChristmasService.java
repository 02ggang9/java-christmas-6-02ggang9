package christmas.service;

import christmas.domain.OrderSheet;
import christmas.domain.menu.Event;
import christmas.repository.ChristmasOrderMenuRepository;


public class ChristmasService {

    private final ChristmasOrderMenuRepository christmasOrderMenuRepository = new ChristmasOrderMenuRepository();

    public Integer calculateTotalAmount() {
        OrderSheet findOrderSheet = christmasOrderMenuRepository.findOrderSheetById(0L);
        return findOrderSheet.calculateTotalPrice();
    }

    public Event getGiveMenu(Integer price) {
        return Event.getGiveMenu(price);
    }

    public OrderSheet findOrderSheet() {
        return christmasOrderMenuRepository.findOrderSheetById(0L);
    }
}
