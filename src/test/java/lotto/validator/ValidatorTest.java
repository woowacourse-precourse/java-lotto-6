package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {
    private static String ERROR_MESSAGE = "[ERROR]";
    private static String INPUT_CONTAINS_STRING = " 숫자가 아닌 값이 포함되어 있습니다.";
    private static String INPUT_OVER_MINIMUM = " 로또는 최소 1,000원 부터 구매 가능합니다.";
    private static String INPUT_NOT_MEET_UNIT = " 1,000원 단위로 입력해주세요.";
    private static String DUPLICATE_NUMBERS = "중복된 로또 번호가 존재합니다.";
    private static String CHECK_NUMBERS_COUNT = "로또 번호의 개수는 6개여야 합니다.";
    private static String NUMBERS_IN_RANGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    @DisplayName("Lotto 로 생성되는 숫자들은 6개가 아니면 예외가 발생한다.")
    @Test
    void validateLottoNumbersByLottoNumbersCount() {
        assertThatThrownBy(() -> Validator.validateLottoNumbers(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + CHECK_NUMBERS_COUNT);
    }

    @DisplayName("Lotto 로 생성되는 숫자들은 중복되면 예외가 발생한다.")
    @Test
    void validateLottoNumbersByDuplicatedNumbers() {
        assertThatThrownBy(() -> Validator.validateLottoNumbers(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + DUPLICATE_NUMBERS);
    }

    @DisplayName("Lotto 로 생성되는 숫자들은 1부터 45사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void validateLottoNumbersByNumberInRange() {
        assertThatThrownBy(() -> Validator.validateLottoNumbers(List.of(1, 2, 3, 4, 46, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + NUMBERS_IN_RANGE);
    }

    @DisplayName("보너스 번호로 입력되는 숫자가 숫자형이 아닌 문자가 포함되어 있으면 예외가 발생한다.")
    @Test
    void validateBonusNumbersByIsNumber() {
        assertThatThrownBy(() -> Validator
                .validateBonusNumbers(List.of(1, 2, 3, 4, 5, 6), "j"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + INPUT_CONTAINS_STRING);
    }

    @DisplayName("보너스 번호로 입력되는 숫자가 1부터 45이내의 숫자이지 않으면 예외가 발생한다..")
    @Test
    void validateBonusNumbersByNumberInRange() {
        assertThatThrownBy(() -> Validator
                .validateBonusNumbers(List.of(1, 2, 3, 4, 5, 6), "50"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + NUMBERS_IN_RANGE);
    }

    @DisplayName("보너스 번호로 입력되는 숫자가 당첨 번호와 중복되면 예외가 발생한다..")
    @Test
    void validateBonusNumbersByDuplicated() {
        assertThatThrownBy(() -> Validator
                .validateBonusNumbers(List.of(1, 2, 3, 4, 5, 7), "7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + DUPLICATE_NUMBERS);
    }

    @DisplayName("구매 금액으로 입력되는 값에 숫자가 아닌 값이 포함되어 있으면 예외가 발생한다..")
    @Test
    void validateStringConainsString() {
        assertThatThrownBy(() -> Validator
                .validateString("1000j"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + INPUT_CONTAINS_STRING);
    }

    @DisplayName("구매 금액으로 입력되는 값에 숫자가 아닌 값이 포함되어 있지 않다.")
    @Test
    void validateString() {
        assertThatCode(() -> Validator.validateString("1000")).doesNotThrowAnyException();
    }

    @DisplayName("구매 금액이 최소 금액인 1000원 미만이면 예외가 발생한다.")
    @Test
    void validateStringByMinimumPrice() {
        assertThatThrownBy(() -> Validator.validateString("999"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + INPUT_OVER_MINIMUM);
    }

    @DisplayName("구매 금액이 1000원 단위로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void validateStringByMeetUnit() {
        assertThatThrownBy(() -> Validator.validateString("1111"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + INPUT_NOT_MEET_UNIT);
    }
}