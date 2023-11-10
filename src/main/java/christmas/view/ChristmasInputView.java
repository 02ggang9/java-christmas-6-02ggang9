package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.global.InputMessage;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static christmas.global.InputMessage.*;

public class ChristmasInputView {

    public int getUserDateOfVisit() {
        System.out.println(ORDER_DATE_OF_VISIT.getMessage());

        // TODO : 예외처리
        // 숫자인지만 확인
        while (true) {
            String expectedVisitDate = Console.readLine();

            try {
                checkDateOfVisitValidation(expectedVisitDate);
                return Integer.parseInt(expectedVisitDate);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            }

        }
    }

    private String checkDateOfVisitValidation(String expectedVisitDate) {
        String regex = "(?:[1-9]|1[0-9]|2[0-9]|3[01])";
        Pattern pattern = Pattern.compile(regex);

        if (pattern.matcher(expectedVisitDate).matches()) {
            return expectedVisitDate;
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
