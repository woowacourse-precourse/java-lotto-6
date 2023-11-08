package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import lotto.errors.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoManagerTest {

    LottoManager lm = LottoManager.getInstance();

    @ParameterizedTest
    @ValueSource(strings = {"k", "1.2"})
    @DisplayName("구입금액: 정수가 아닌 숫자가 들어올 때 예외처리")
    void test_setNumberOfLottos_1(String inputCost) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lm.setNumberOfLottos(inputCost))
                .withMessage(ErrorMessage.WRONG_NUMBER_FORMAT.getMessage());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("구입금액: Null 또는 Empty 값이 들어올 때 예외처리")
    void test_setNumberOfLottos_2(String inputCost) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lm.setNumberOfLottos(inputCost))
                .withMessage(ErrorMessage.WRONG_NUMBER_FORMAT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2001"})
    @DisplayName("구입금액: 1000의 배수가 아닌 숫자가 들어올 때 예외처리")
    void test_setNumberOfLottos_3(String inputCost) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lm.setNumberOfLottos(inputCost))
                .withMessage(ErrorMessage.WRONG_COST.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-5"})
    @DisplayName("구입금액: 숫자 0이 들어올 때 예외처리")
    void test_setNumberOfLottos_4(String inputCost) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lm.setNumberOfLottos(inputCost))
                .withMessage(ErrorMessage.NOT_SMALLER_THAN_ZERO.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000", "21000", "512000"})
    @DisplayName("구입금액: 적절한 값이 들어올 때 테스트 통과")
    void test_setNumberOfLottos_5(String inputCost) {
        assertThatCode(() -> lm.setNumberOfLottos(inputCost))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,k", "1.2,3", "1,2,3 4"})
    @DisplayName("당첨번호: ','로 분할한 값이 정수가 아닐 때 예외처리")
    void test_setLuckyNumbers_1(String inputNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lm.setLuckyNumbers(inputNumber))
                .withMessage(ErrorMessage.WRONG_NUMBER_FORMAT.getMessage());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("당첨번호: Null 또는 Empty 값이 들어올 때 예외처리")
    void test_setLuckyNumbers_2(String inputNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lm.setLuckyNumbers(inputNumber))
                .withMessage(ErrorMessage.WRONG_NUMBER_FORMAT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {",1,2"})
    @DisplayName("당첨번호: ','로 시작할 때 예외처리")
    void test_setLuckyNumbers_3(String inputNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lm.setLuckyNumbers(inputNumber))
                .withMessage(ErrorMessage.WRONG_NUMBER_FORMAT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"   1,2, 3 ,43, 44, 45   "})
    @DisplayName("당첨번호: 시작, 끝, 중간 공백 제거하고 적절한 값이 들어올 때 테스트 통과")
    void test_setLuckyNumbers_4(String inputNumber) {
        assertThatCode(() -> lm.setLuckyNumbers(inputNumber))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"k", "1.2"})
    @DisplayName("보너스 번호: 정수가 아닌 숫자가 들어올 때 예외처리")
    void test_setBonusNumber_1(String inputNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lm.setBonusNumber(inputNumber))
                .withMessage(ErrorMessage.WRONG_NUMBER_FORMAT.getMessage());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("보너스 번호: Null 또는 Empty 값이 들어올 때 예외처리")
    void test_setBonusNumber_2(String inputNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lm.setBonusNumber(inputNumber))
                .withMessage(ErrorMessage.WRONG_NUMBER_FORMAT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "46"})
    @DisplayName("보너스 번호: 1~45 범위를 벗어나는 숫자가 있을 때 예외처리")
    void test_setBonusNumber_3(String inputNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lm.setBonusNumber(inputNumber))
                .withMessage(ErrorMessage.WRONG_NUMBER_RANGE.getMessage());
    }
}