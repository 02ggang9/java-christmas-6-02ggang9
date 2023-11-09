package christmas.controller;

import christmas.view.ChristmasInputView;

public class ChristmasController {

    private final ChristmasInputView christmasInputView = new ChristmasInputView();

    public void run() {
        int dateOfVisit = getDateOfVisit();

    }

    private int getDateOfVisit() {
        return christmasInputView.getUserDateOfVisit();
    }

}
