package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import lotto.constants.ExceptionMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class LottoNumberValidatorTest {
    private static final List<Integer> LIST_WITH_CORRECT_NUMBERS = List.of(1, 2, 3, 4, 5, 6);
    private static final List<Integer> LIST_WITH_WRONG_RANGE_NUMBER = List.of(1, 2, 3, 4, 5, 88);
    private static final List<Integer> LIST_WITH_WRONG_SIZE = List.of(1, 2, 3, 4, 5);
    private static final List<Integer> LIST_WITH_DUPLICATE_NUMBER = List.of(1, 2, 3, 4, 5, 1);

    private static final String CORRECT_BONUS_NUMBER = "8";

    private static final String BONUS_NUMBER_WITH_BLANK = "";
    private static final String BONUS_NUMBER_WITH_NULL = null;
    private static final String BONUS_NUMBER_NOT_NUMBER = "a";
    private static final String BONUS_NUMBER_WITH_WRONG_RANGE = "48";
    private static final String BONUS_NUMBER_WITH_DUPLICATED_WITH_LOTTO = "1";

    @Test
    @DisplayName("로또가 올바르게 발행되는 경우")
    void validateLottoNumbers_withCorrectLottoNumbers() {
        assertDoesNotThrow(() ->
                LottoNumberValidator.validateLottoNumbers(LIST_WITH_CORRECT_NUMBERS)
        );
    }

    @Test
    @DisplayName("발행된 로또 번호가 1~45 사이의 숫자가 아닌 경우")
    void validateLottoNumbers_withWrongRangeNumber() {
        assertThatThrownBy(() -> LottoNumberValidator.validateLottoNumbers(LIST_WITH_WRONG_RANGE_NUMBER)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.LOTTO_NUMBER_RANGE_ERROR_MESSAGE.getErrorMessage());
    }

    @Test
    @DisplayName("로또 번호가 6개로 이루어지지 않은 경우")
    void validateLottoNumbers_withWrongSize() {
        assertThatThrownBy(() -> LottoNumberValidator.validateLottoNumbers(LIST_WITH_WRONG_SIZE)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.LOTTO_NUMBER_COUNT_ERROR_MESSAGE.getErrorMessage());
    }

    @Test
    @DisplayName("6개로 이루어진 숫자 중 중복된 번호가 있는 경우")
    void validateLottoNumbers_withDuplicatedNumber() {
        assertThatThrownBy(() -> LottoNumberValidator.validateLottoNumbers(LIST_WITH_DUPLICATE_NUMBER)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.LOTTO_NUMBER_DUPLICATION_ERROR_MESSAGE.getErrorMessage());
    }


    /// BONUS NUMBER
    @Test
    @DisplayName("올바른 보너스 번호를 입력받은 경우")
    void validateBonusNumber_withCorrectLottoNumbers() {
        assertDoesNotThrow(() ->
                LottoNumberValidator.validateBonusNumber(LIST_WITH_CORRECT_NUMBERS, CORRECT_BONUS_NUMBER)
        );
    }

    @Test
    @DisplayName("보너스 번호로 공백 값을 입력 받은 경우")
    void validateBonusNumber_WithBlankBonusNumber() {
        assertThatThrownBy(
                () -> LottoNumberValidator.validateBonusNumber(LIST_WITH_CORRECT_NUMBERS, BONUS_NUMBER_WITH_BLANK)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.LOTTO_NUMBER_TYPE_ERROR_MESSAGE.getErrorMessage());
    }

    @Test
    @DisplayName("보너스 번호로 null 값을 입력 받은 경우")
    void validateBonusNumber_WithNullBonusNumber() {
        assertThatThrownBy(
                () -> LottoNumberValidator.validateBonusNumber(LIST_WITH_CORRECT_NUMBERS, BONUS_NUMBER_WITH_NULL)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.LOTTO_NUMBER_TYPE_ERROR_MESSAGE.getErrorMessage());
    }

    @Test
    @DisplayName("보너스 번호로 숫자가 아닌 문자를 입력 받은 경우")
    void validateBonusNumber_WithNotNumber() {
        assertThatThrownBy(
                () -> LottoNumberValidator.validateBonusNumber(LIST_WITH_CORRECT_NUMBERS, BONUS_NUMBER_NOT_NUMBER)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.LOTTO_NUMBER_TYPE_ERROR_MESSAGE.getErrorMessage());
    }


    @Test
    @DisplayName("발행된 보너스 번호가 1~45 사이의 숫자가 아닌 경우")
    void validateBonusNumber_WithWrongRange() {
        assertThatThrownBy(
                () -> LottoNumberValidator.validateBonusNumber(LIST_WITH_CORRECT_NUMBERS, BONUS_NUMBER_WITH_WRONG_RANGE)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.LOTTO_NUMBER_RANGE_ERROR_MESSAGE.getErrorMessage());
    }

    @Test
    @DisplayName("로또의 6개로 이루어진 숫자 중 보너스 번호와 중복된 번호가 있는 경우")
    void validateBonusNumber_withDuplicatedNumber() {
        assertThatThrownBy(
                () -> LottoNumberValidator.validateBonusNumber(LIST_WITH_CORRECT_NUMBERS,
                        BONUS_NUMBER_WITH_DUPLICATED_WITH_LOTTO)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.LOTTO_NUMBER_DUPLICATION_ERROR_MESSAGE.getErrorMessage());
    }


}
