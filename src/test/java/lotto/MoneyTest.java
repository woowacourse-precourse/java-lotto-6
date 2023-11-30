package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @DisplayName("숫자가 아닌 특수문자나 한글, 영어 입력 시 예외가 발생한다.")
    @Test
    void InputInvalidPrice() {
        assertSimpleTest(() -> {
            runException("1000j");
        });
    }

    private void runException(String string) { }

    @DisplayName("1000원 단위로 입력하지 않은 경우 예외가 발생한다.")
    @Test
    void createPricePerOnehundredWon() {
        assertThatThrownBy(() -> new Lotto(List.of(1500)))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("1000원 미만의 금액을 입력한 경우 예외가 발생한다.")
    @Test
    void createPriceOverOnehundredWon() {
        assertThatThrownBy(() -> new Lotto(List.of(500)))
                .isInstanceOf(IllegalArgumentException.class);
    }

}