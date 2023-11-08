package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import lotto.errors.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {

    BonusNumber bm = new BonusNumber();

    @ParameterizedTest
    @ValueSource(strings = {"k", "1.2"})
    @DisplayName("보너스 번호: 정수가 아닌 숫자가 들어올 때 예외처리")
    void test_setBonusNumber_1(String inputNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> bm.setBonusNumber(inputNumber))
                .withMessage(ErrorMessage.WRONG_NUMBER_FORMAT.getMessage());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("보너스 번호: Null 또는 Empty 값이 들어올 때 예외처리")
    void test_setBonusNumber_2(String inputNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> bm.setBonusNumber(inputNumber))
                .withMessage(ErrorMessage.WRONG_NUMBER_FORMAT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "46"})
    @DisplayName("보너스 번호: 1~45 범위를 벗어나는 숫자가 있을 때 예외처리")
    void test_setBonusNumber_3(String inputNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> bm.setBonusNumber(inputNumber))
                .withMessage(ErrorMessage.WRONG_NUMBER_RANGE.getMessage());
    }
}