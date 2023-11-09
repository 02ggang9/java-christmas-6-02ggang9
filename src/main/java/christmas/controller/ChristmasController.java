package christmas.controller;

import christmas.service.ChristmasService;
import christmas.view.ChristmasInputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChristmasController {

    private final ChristmasInputView christmasInputView = new ChristmasInputView();
    private final ChristmasService christmasService = new ChristmasService();

    public void run() {
        // STEP1 : 예상 방문 날짜 입력받고 저장
        int dateOfVisit = getDateOfVisit();
        saveDateOfVisit(dateOfVisit);

        // STEP2 : 주문할 메뉴와 개수 입력 받고 저장
        List<String> orderMenuAndCount = getOrderMenuAndCount();
        saveOrderMenu(orderMenuAndCount);
        saveOrderMenuCount(orderMenuAndCount);
    }

    private void saveOrderMenuCount(List<String> orderMenuAndCount) {

    }

    private List<String> saveOrderMenu(List<String> orderMenuAndCount) {
        List<String> strings = new ArrayList<>();
        for (String s : orderMenuAndCount) {
            String[] split = s.split("-");
            strings.add(split[0]);
        }

        return strings;
    }

    private List<String> getOrderMenuAndCount() {
        return christmasInputView.getUserOrderMenu();
    }

    private void saveDateOfVisit(int dateOfVisit) {
        christmasService.saveDateOfVisit(dateOfVisit);
    }

    private int getDateOfVisit() {
        return christmasInputView.getUserDateOfVisit();
    }

}
