package christmas.domain.menu;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static christmas.domain.menu.OrderMenu.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderMenuTest {

    @Test
    @DisplayName("금액 계산을 성공해야 한다.")
    void 금액_계산을_성공해야_한다() {
        OrderMenu caesarSalad = CAESAR_SALAD;
        final int orderMenuCount = 2;

        assertThat(caesarSalad.calculatePrice(orderMenuCount)).isEqualTo(caesarSalad.getMenuPrice() * orderMenuCount);
    }

}
