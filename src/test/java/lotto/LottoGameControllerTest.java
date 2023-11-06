package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameControllerTest {

    @DisplayName("로또 구매 금액이 조건에 맞지 않으면 true를 반환한다.")
    @Test
    void isInvalidTest() {
        boolean exceptionOccured = LottoGameController.isInvalidUserInput("1234");
        assertThat(exceptionOccured).isTrue();
    }

}