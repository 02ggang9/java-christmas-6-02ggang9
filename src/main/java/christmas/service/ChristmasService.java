package christmas.service;

import christmas.domain.GiveMenu;
import christmas.domain.OrderMenu;
import christmas.domain.discount.ChristmasDiscountEvent;
import christmas.repository.ChristmasDateOfVisitRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class ChristmasService {

    private final ChristmasDateOfVisitRepository repository = new ChristmasDateOfVisitRepository();

    public void saveDateOfVisit(int dateOfVisit) {
        repository.saveDateOfVisit(dateOfVisit);
    }

    public Integer calculateTotalAmount(Set<Map.Entry<String, Integer>> orderMenus) {
        int totalAmount = 0;
        for (Map.Entry<String, Integer> orderMenu : orderMenus) {
            OrderMenu menu = OrderMenu.getOrderMenu(orderMenu.getKey());
            totalAmount += (orderMenu.getValue() * menu.getMenuPrice());
        }

        return totalAmount;
    }

    public GiveMenu getGiveMenu(Integer amount) {
        if (GiveMenu.CHAMPAGNE.isOver(amount)) {
            return GiveMenu.CHAMPAGNE;
        }

        return GiveMenu.NOTING;
    }

    public int getChristmasDiscountAmount() {
        int dateOfVisit = repository.findDateOfVisit();
        return ChristmasDiscountEvent.discountAmount(dateOfVisit);
    }
}
