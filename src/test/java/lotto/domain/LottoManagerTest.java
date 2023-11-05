package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import lotto.errors.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoManagerTest {

    LottoManager lm = LottoManager.getInstance();

    @ParameterizedTest
    @ValueSource(strings = {"k", "1.2"})
    @DisplayName("정수가 아닌 숫자가 들어올 때 예외처리")
    void test_setNumberOfLottos_1(String inputCost) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lm.setNumberOfLottos(inputCost))
                .withMessage(ErrorMessage.WRONG_NUMBER_FORMAT.getMessage());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Null 또는 Empty 값이 들어올 때 예외처리")
    void test_setNumberOfLottos_2(String inputCost) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lm.setNumberOfLottos(inputCost))
                .withMessage(ErrorMessage.WRONG_NUMBER_FORMAT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2001"})
    @DisplayName("1000의 배수가 아닌 숫자가 들어올 때 예외처리")
    void test_setNumberOfLottos_3(String inputCost) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lm.setNumberOfLottos(inputCost))
                .withMessage(ErrorMessage.WRONG_COST.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-5"})
    @DisplayName("숫자 0이 들어올 때 예외처리")
    void test_setNumberOfLottos_4(String inputCost) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lm.setNumberOfLottos(inputCost))
                .withMessage(ErrorMessage.NOT_SMALLER_THAN_ZERO.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000", "21000", "512000"})
    @DisplayName("적절한 값이 들어올 때 테스트 통과")
    void test_setNumberOfLottos_5(String inputCost) {
        assertThatCode(() -> lm.setNumberOfLottos(inputCost))
                .doesNotThrowAnyException();
    }
}