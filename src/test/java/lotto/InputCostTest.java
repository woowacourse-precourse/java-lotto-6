package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.Application.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputCostTest {


    @DisplayName("로또를 사기위한 금액 입력 시, 문자열이 들어가있으면 예외가 발생한다.")
    @Test
    void validateInputCostIsNumException() {
        assertThatThrownBy(() -> validateInputCostIsNum("1000z"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또를 사기위한 금액 입력 시, 1000원 단위가 아닌 입력을 했을 시 예외가 발생한다.")
    @Test
    void validateInputCostByModException() {
        assertThatThrownBy(() -> validateInputCostByMod(10001))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또를 사기위한 금액 입력 시, 1000원 미만의 수 이거나, 음수일 경우 예외가 발생한다.")
    @Test
    void validateInputCostByLimitException() {
        assertThatThrownBy(() -> validateInputCostByLimit(-1000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또를 사기위해 음수가 아닌 1000원 이상인 수이고, 1000원 단위인 수를 입력했을 시 정상 작동하는 지 테스트")
    @Test
    void calculateLottoCountTest() {
        int expected_result = 12;
        int result = calculateLottoCount("12000");

        assertEquals(expected_result, result);
    }

}
