package christmas.controller;

import christmas.service.ChristmasService;
import christmas.view.ChristmasInputView;

public class ChristmasController {

    private final ChristmasInputView christmasInputView = new ChristmasInputView();
    private final ChristmasService christmasService = new ChristmasService();

    public void run() {
        int dateOfVisit = getDateOfVisit();
        saveDateOfVisit(dateOfVisit);
    }

    private void saveDateOfVisit(int dateOfVisit) {
        christmasService.saveDateOfVisit(dateOfVisit);
    }

    private int getDateOfVisit() {
        return christmasInputView.getUserDateOfVisit();
    }

}
