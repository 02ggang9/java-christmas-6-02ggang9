package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ChristmasInputViewTest {

    @ParameterizedTest
    @DisplayName("예약 날짜 입력 테스트")
    @ValueSource(ints = {1,2,3,4,5,6,7,31})
    void 예약_날짜_입력_테스트(int dateOfVisit) {
        MockedStatic<Console> consoleMockedStatic = mockStatic(Console.class);
        when(Console.readLine()).thenReturn(String.valueOf(dateOfVisit));

        ChristmasInputView christmasInputView = new ChristmasInputView();
        assertThatCode(christmasInputView::getUserDateOfVisit).doesNotThrowAnyException();

        consoleMockedStatic.close();
    }

}
