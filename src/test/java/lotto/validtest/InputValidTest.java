package lotto.validtest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.util.IllegalArgumentMessage;
import lotto.util.InputDataException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("입력값 검증")
public class InputValidTest {
    @ParameterizedTest
    @CsvSource({"a", "x0", "123a"})
    void 가격_검증_숫자_외_입력(String inputSample) {
        assertThatThrownBy(() -> InputDataException.validatePaymentInput(inputSample))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(IllegalArgumentMessage.ERROR_PAYMENT_INPUT);
    }

    @Test
    void 당첨번호_검증_구분자_에러() {
        assertThatThrownBy(() -> InputDataException.validateWinningLottoNumbersInput("a b c d e f g"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(IllegalArgumentMessage.ERROR_SPLIT_IDENTIFICATION);
        assertThatThrownBy(() -> InputDataException.validateWinningLottoNumbersInput("a.b.c.d.e.f"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(IllegalArgumentMessage.ERROR_SPLIT_IDENTIFICATION);
    }

    @Test
    void 당첨번호_검증_범위_외_입력() {
        assertThatThrownBy(() -> InputDataException.validateWinningLottoNumbersInput("a,b,c,d,e,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(IllegalArgumentMessage.ERROR_PICK_COUNT);
        assertThatThrownBy(() -> InputDataException.validateWinningLottoNumbersInput("a,b,c,d,e,f,g"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(IllegalArgumentMessage.ERROR_PICK_COUNT);
    }

    @Test
    void 당첨번호_검증_숫자_외_입력() {
        assertThatThrownBy(() -> InputDataException.validateWinningLottoNumbersInput("a,b,c,d,e,f"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(IllegalArgumentMessage.ERROR_ONLY_NUMBERS);
        assertThatThrownBy(() -> InputDataException.validateWinningLottoNumbersInput("1,2,3,4,5,f"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(IllegalArgumentMessage.ERROR_ONLY_NUMBERS);
    }

    @ParameterizedTest
    @CsvSource({"a", "x0", "123a"})
    void 보너스_번호_검증_숫자_외_입력(String inputSample) {
        assertThatThrownBy(() -> InputDataException.validateBonusNumberInput(inputSample))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(IllegalArgumentMessage.ERROR_ONLY_NUMBERS);
    }
}
