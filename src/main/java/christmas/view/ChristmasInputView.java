package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.global.ErrorMessage;
import christmas.global.InputMessage;

import java.util.Arrays;
import java.util.List;
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

        String menuAndCount = Console.readLine();

        return Arrays.stream(menuAndCount.split(","))
                .toList();
    }
}
