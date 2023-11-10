package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.menu.OrderMenu;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import static christmas.global.ErrorMessage.*;
import static christmas.global.InputMessage.*;

public class ChristmasInputView {

    public int getUserDateOfVisit() {
        System.out.println(ORDER_DATE_OF_VISIT.getMessage());

        while (true) {
            String expectedVisitDate = Console.readLine();

            try {
                return checkDateOfVisitValidation(expectedVisitDate);
            } catch (IllegalArgumentException e) {
                System.out.println(INVALID_DATE_OF_VISIT.getMessage());
            }

        }
    }

    private int checkDateOfVisitValidation(String expectedVisitDate) {
        String regex = "(?:[1-9]|1[0-9]|2[0-9]|3[01])";
        Pattern pattern = Pattern.compile(regex);

        if (pattern.matcher(expectedVisitDate).matches()) {
            return Integer.parseInt(expectedVisitDate);
        }

        throw new IllegalArgumentException();
    }

    public List<String> getUserOrderMenu() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");

        while (true) {

            try {
                String menuAndCount = Console.readLine();

                // [ERROR] 메뉴의 형식이 예시와 다른 경우
                List<String> menus = getMenus(menuAndCount);
                List<Integer> counts = getCounts(menuAndCount);

                // 1. 고객이 메뉴판에 없는 메뉴를 입력
                checkOrderMenuIsValid(menus);

                // 2. 메뉴의 개수는 1 이상
                checkOrderCountsIsValid(counts);

                // 4. 중복 메뉴를 입력한 경우
                checkDuplicateMenu(menus);
//                return Arrays.stream(menuAndCount.split(","))
//                        .toList();

            } catch (IllegalArgumentException e) {

            }
        }



    }

    private void checkDuplicateMenu(List<String> menus) {
        if (menus.size() != Set.of(menus).size()) {
            return;
        }

        throw new IllegalArgumentException();
    }

    private void checkOrderCountsIsValid(List<Integer> counts) {
        counts.forEach(this::checkCountValid);
    }

    private void checkCountValid(Integer count) {
        if (count > 0) {
            return;
        }

        throw new IllegalArgumentException();
    }

    private List<String> getMenus(String menuAndCount) {
        try {
            return Arrays.stream(menuAndCount.split(","))
                    .toList()
                    .stream()
                    .map(s -> s.split("-")[0])
                    .toList();
        } catch (RuntimeException e) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> getCounts(String menuAndCount) {
        try {
            return Arrays.stream(menuAndCount.split(","))
                    .toList()
                    .stream()
                    .map(s -> s.split("-")[1])
                    .map(Integer::parseInt)
                    .toList();
        } catch (RuntimeException e) {
            throw new IllegalArgumentException();
        }
    }

    private void checkOrderMenuIsValid(List<String> menus) {
        menus.forEach(OrderMenu::fromMenuName);
    }
}
