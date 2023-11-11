package christmas.controller;

import christmas.domain.OrderSheet;
import christmas.domain.menu.GiveMenu;
import christmas.repository.ChristmasOrderMenuRepository;
import christmas.service.ChristmasService;
import christmas.view.ChristmasInputView;
import christmas.view.ChristmasOutputView;

import java.util.*;

public class ChristmasController {

    private final ChristmasInputView christmasInputView = new ChristmasInputView();
    private final ChristmasOutputView christmasOutputView = new ChristmasOutputView();
    private final ChristmasService christmasService = new ChristmasService();
    private final ChristmasOrderMenuRepository christmasOrderMenuRepository = new ChristmasOrderMenuRepository();

    public void run() {
        // STEP1 : 예상 방문 날짜 입력받고 저장
        int dateOfVisit = getDateOfVisit();
        saveDateOfVisit(dateOfVisit);

        // STEP2 : 주문할 메뉴와 개수 입력 받고 저장
        getOrderMenusAndSave(dateOfVisit);

        // STEP3 : 이벤트 혜택 미리 보기 안내 메시지 출력
        printEventInformationMessage();

        // STEP4 : 사용자가 주문한 메뉴와 개수 출력
//        Set<Map.Entry<String, Integer>> orderMenus = getOrderMenus();
//        printOrderMenuAndCounts(orderMenus);
        printOrderMenusAndCounts(findOrderSheet());

        // STEP5 : 할인 전 총 주문 금액 출력
//        Integer amountBeforeDiscount = getAmountBeforeDiscount(orderMenus);
//        printTotalAmountBeforeDiscount(amountBeforeDiscount);
        Integer amountBeforeDiscount = getAmountBeforeDiscount();
        printTotalAmountBeforeDiscount(amountBeforeDiscount);

        // STEP6 : 증정 메뉴 출력
        GiveMenu giveMenu = getGiveMenu(amountBeforeDiscount);
        printGiveMenu(giveMenu);

        // STEP 7 : 혜택 내역 출력
        int christmasDiscountAmount = getChristmasDiscountAmount();
        int weekdayDiscountAmount = getWeekdayDiscountAmount();
        int weekendDiscountAmount = getWeekendDiscountAmount();
        int specialDiscountAmount = getSpecialDiscountAmount();
        int giveDiscountAmount = getGiveDiscountAmount(giveMenu);
        int totalDiscountAmount = christmasDiscountAmount + weekdayDiscountAmount + weekendDiscountAmount + specialDiscountAmount + giveDiscountAmount;

        printBenefitDetails(totalDiscountAmount, weekdayDiscountAmount, christmasDiscountAmount, weekendDiscountAmount, specialDiscountAmount, giveDiscountAmount);

        // STEP 8 : 총 혜택 금액 출력
        printTotalDiscountAmount(totalDiscountAmount);

        // STEP 9 : 할인 후 예상 결제 금액 출력
        printAfterDiscountAmount(10 - totalDiscountAmount);

        // STEP 10 : 이벤트 배지 출력
        printEventBadge(totalDiscountAmount);
    }

    private void printOrderMenusAndCounts(OrderSheet orderSheet) {
        christmasOutputView.printOrderMenusAndCounts(orderSheet);
    }

    private OrderSheet findOrderSheet() {
        return christmasService.findOrderSheet();
    }

    private void getOrderMenusAndSave(int dateOfVisit) {
        OrderSheet orderSheet = getOrderSheet(dateOfVisit);
        saveOrderMenu(orderSheet);
    }

    private void getDateOfVisitAndSave() {
        int dateOfVisit = getDateOfVisit();
        saveDateOfVisit(dateOfVisit);
    }

    private void printEventBadge(int totalDiscountAmount) {
        christmasOutputView.printEventBadge(totalDiscountAmount);
    }

    private void printAfterDiscountAmount(int afterDiscountAmount) {
        christmasOutputView.printAfterDiscountAmount(afterDiscountAmount);
    }

    private void printTotalDiscountAmount(int totalDiscountAmount) {
        christmasOutputView.totalDiscountAmount(totalDiscountAmount);
    }

    private void printBenefitDetails(int totalCount, int weekdayDiscountAmount, int christmasDiscountAmount, int weekendDiscountAmount, int specialDiscountAmount, int giveDiscountAmount) {
        christmasOutputView.printBenefitDetails(totalCount, christmasDiscountAmount, weekdayDiscountAmount, weekendDiscountAmount, specialDiscountAmount, giveDiscountAmount);
    }

    private int getGiveDiscountAmount(GiveMenu giveMenu) {
        if (giveMenu == GiveMenu.CHAMPAGNE) {
            return 25000;
        }

        return 0;
    }

    private int getSpecialDiscountAmount() {
        return christmasService.getSpecialDiscountAmount();
    }

    private int getWeekendDiscountAmount() {
        return christmasService.getWeekendDiscountAmount();
    }

    private int getWeekdayDiscountAmount() {
        return christmasService.getWeekdayDiscountAmount();
    }

    private int getChristmasDiscountAmount() {
        return christmasService.getChristmasDiscountAmount();
    }

    private GiveMenu getGiveMenu(Integer amountBeforeDiscount) {
        return christmasService.getGiveMenu(amountBeforeDiscount);
    }

    private void printGiveMenu(GiveMenu giveMenu) {
        christmasOutputView.printGiveMenu(giveMenu);
    }

    private void printTotalAmountBeforeDiscount(Integer amountBeforeDiscount) {
        christmasOutputView.printTotalAmountBeforeDiscount(amountBeforeDiscount);
    }

//    private Integer getAmountBeforeDiscount(Set<Map.Entry<String, Integer>> orderMenus) {
//        return christmasService.calculateTotalAmount(orderMenus);
//    }

    private Integer getAmountBeforeDiscount() {
        return christmasService.calculateTotalAmount();
    }


//    private void printOrderMenuAndCounts(Set<Map.Entry<String, Integer>> orderMenus) {
//        christmasOutputView.printOrderMenuAndCounts(orderMenus);
//    }



    private Set<Map.Entry<String, Integer>> getOrderMenus() {
        return christmasOrderMenuRepository.findAllMenusAndCounts();
    }

    private void printEventInformationMessage() {
        christmasOutputView.printEventInformation();
    }

    private void saveOrderMenu(OrderSheet orderSheet) {
        christmasOrderMenuRepository.saveOrderSheet(orderSheet);
//        christmasOrderMenuRepository.saveOrderMenus(orderMenus, orderMenusCounts);
    }

    private OrderSheet getOrderSheet(int dateOfVisit) {
        return christmasInputView.getUserOrderMenu(dateOfVisit);
    }

    private void saveDateOfVisit(int dateOfVisit) {
        christmasService.saveDateOfVisit(dateOfVisit);
    }

    private int getDateOfVisit() {
        return christmasInputView.getUserDateOfVisit();
    }

}
