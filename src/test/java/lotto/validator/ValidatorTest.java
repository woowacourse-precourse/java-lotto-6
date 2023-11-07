package lotto.validator;

import static lotto.message.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    @DisplayName("구매 금액 범위에 포함된 경우")
    void validateMoneyLimitSuccess() {
        Long target = 13000L;
        assertDoesNotThrow(() -> Validator.validateMoneyLimit(target));
    }

    @Test
    @DisplayName("구매 금액 범위에 포함되지 않은 경우 - 0일 때")
    void validateMoneyOutOfLimitZero() {
        Long target = 0L;
        assertThatThrownBy(() -> Validator.validateMoneyLimit(target))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MONEY_LIMIT_EXCEEDED_EXCEPTION);
    }

    @Test
    @DisplayName("구매 금액 범위에 포함되지 않은 경우 - 음수일 때")
    void validateMoneyOutOfLimitNegative() {
        Long target = -10000L;
        assertThatThrownBy(() -> Validator.validateMoneyLimit(target))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MONEY_LIMIT_EXCEEDED_EXCEPTION);
    }

    @Test
    @DisplayName("구매 금액 범위에 포함되지 않은 경우 - 양수일 때")
    void validateMoneyOutOfLimitPositive() {
        Long target = 100000000000L;
        assertThatThrownBy(() -> Validator.validateMoneyLimit(target))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MONEY_LIMIT_EXCEEDED_EXCEPTION);
    }

    @Test
    @DisplayName("구입 금액이 1000의 배수인 경우")
    void validateMoneyModNoneZeroSuccess() {
        Long target = 100000L;
        assertDoesNotThrow(() -> Validator.validateMoneyModNoneZero(target));
    }

    @Test
    @DisplayName("구입 금액이 1000의 배수가 아닌 경우")
    void validateMoneyModNoneZeroFail() {
        Long target = 100010L;
        assertThatThrownBy(() -> Validator.validateMoneyModNoneZero(target))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MONEY_MOD_NONE_ZERO_EXCEPTION);
    }

    @Test
    @DisplayName("번호 개수가 6개인 경우")
    void validateNumberCountSuccess() {
        List<Integer> target = List.of(1, 2, 3, 4, 5, 6);
        assertDoesNotThrow(() -> Validator.validateNumberCount(target));
    }

    @Test
    @DisplayName("번호 개수가 6개 미만인 경우")
    void validateNumberCountLessFail() {
        List<Integer> target = List.of(1, 2, 3);
        assertThatThrownBy(() -> Validator.validateNumberCount(target))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBER_COUNT_EXCEPTION);
    }

    @Test
    @DisplayName("번호 개수가 6개 이상인 경우")
    void validateNumberCountMoreFail() {
        List<Integer> target = List.of(1, 2, 3, 4, 5, 6, 7);
        assertThatThrownBy(() -> Validator.validateNumberCount(target))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBER_COUNT_EXCEPTION);
    }

    @Test
    @DisplayName("번호 리스트의 요소가 1이상 45이하의 숫자인 경우")
    void validateNumberRangeSuccess() {
        List<Integer> target = List.of(1, 2, 3, 4, 5, 6);
        assertDoesNotThrow(() -> Validator.validateNumberRange(target));
    }

    @Test
    @DisplayName("번호 리스트의 요소가 1이상 45이하의 숫자가 아닌 경우")
    void validateNumberRangeFail() {
        List<Integer> target = List.of(1, 2, 3, 4, 5, 46);
        assertThatThrownBy(() -> Validator.validateNumberRange(target))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBER_RANGE_EXCEPTION);
    }

    @Test
    @DisplayName("번호가 1이상 45이하의 숫자인 경우")
    void validateNumberRangeSingleSuccess() {
        Integer target = 32;
        assertDoesNotThrow(() -> Validator.validateNumberRange(target));
    }

    @Test
    @DisplayName("번호가 1이상 45이하의 숫자가 아닌 경우 - 1보다 작을 때")
    void validateNumberRangeSingleLessFail() {
        Integer target = 0;
        assertThatThrownBy(() -> Validator.validateNumberRange(target))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBER_RANGE_EXCEPTION);
    }

    @Test
    @DisplayName("번호가 1이상 45이하의 숫자가 아닌 경우 - 45보다 클 때")
    void validateNumberRangeSingleMoreFail() {
        Integer target = 46;
        assertThatThrownBy(() -> Validator.validateNumberRange(target))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBER_RANGE_EXCEPTION);
    }

    @Test
    @DisplayName("번호 리스트에 중복된 숫자가 없는 경우")
    void validateDuplicateNumberSuccess() {
        List<Integer> target = List.of(1, 2, 3, 4, 5, 6);
        assertDoesNotThrow(() -> Validator.validateDuplicateNumber(target));
    }

    @Test
    @DisplayName("번호 리스트에 중복된 숫자가 있는 경우")
    void validateDuplicateNumberFail() {
        List<Integer> target = List.of(11, 21, 31, 41, 11, 16);
        assertThatThrownBy(() -> Validator.validateDuplicateNumber(target))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_NUMBER_EXCEPTION);
    }

    @Test
    @DisplayName("당첨 번호와 보너스 번호에 중복된 숫자가 없는 경우")
    void validateDuplicateNumberSingleSuccess() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);

        assertDoesNotThrow(() -> Validator.validateDuplicateNumber(winningNumbers, bonusNumber));
    }

    @Test
    @DisplayName("당첨 번호와 보너스 번호에 중복된 숫자가 있는 경우")
    void validateDuplicateNumberSingleFail() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(6);

        assertThatThrownBy(() -> Validator.validateDuplicateNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_NUMBER_EXCEPTION);
    }
}