package christmas.domain.menu;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class EventTest {

    @Test
    @DisplayName("성공적으로 이벤트 메뉴를 반환해야 한다.")
    void 성공적으로_이벤트_메뉴를_반환해야_한다() {
        Event findEventMenu = Event.getGiveMenu(130_000);

        assertThat(findEventMenu).isEqualTo(Event.CHAMPAGNE);
    }

}
