package lotto.utils.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.utils.validator.WinningNumbersValidator;
import org.junit.jupiter.api.Test;

class WinningNumbersValidatorTest extends NsTest {

    @Test
    void 콤마_위치_테스트() {

        String testInput1 = ",1,2,3,4";
        String testInput2 = "1,2,3,4,";

        assertThatThrownBy(() -> WinningNumbersValidator.validate(testInput1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("콤마");

        assertThatThrownBy(() -> WinningNumbersValidator.validate(testInput2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("콤마");
    }

    @Test
    void 숫자_테스트() {

        String testInput1 = "1,2,a,4";


        assertThatThrownBy(() -> WinningNumbersValidator.validate(testInput1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자");
    }
}