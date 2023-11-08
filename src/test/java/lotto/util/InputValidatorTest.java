package lotto.util;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @DisplayName("구입 금액은 숫자가 아니면 에러가 발생한다.")
    @Test
    void validatePurchaseAmount_NOT_NUMBER() {
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount("a"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1,000원 보다 작으면 에러가 발생한다.")
    @Test
    void validatePurchaseAmount_LESS_THAN_THOUSAND() {
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount("500"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1,000원으로 나누어 떨어지지 않으면 에러가 발생한다.")
    @Test
    void validatePurchaseAmount_NOT_DIVISIBLE_BY_THOUSAND() {
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount("1500"))
            .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("당첨 번호는 숫자가 아니면 에러가 발생한다.")
    @Test
    void validateWinningNumbers_NOT_NUMBER() {
        assertThatThrownBy(() -> InputValidator.validateWinningNumbers("a,2,3,4,5,6"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 1 ~ 45의 범위를 벗어나면 에러가 발생한다.")
    @Test
    void validateWinningNumbers_OUT_OF_RANGE() {
        assertThatThrownBy(() -> InputValidator.validateWinningNumbers("100,2,3,4,5,6"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호는 6개가 아니면 에러가 발생한다. : 6개 미만인 경우")
    @Test
    void validateWinningNumbers_NOT_SIX_WINNING_NUMBERS_LESS_THAN_SIX() {
        assertThatThrownBy(() -> InputValidator.validateWinningNumbers("1,2,3,4,5"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호는 6개가 아니면 에러가 발생한다. : 6개 초과인 경우")
    @Test
    void validateWinningNumbers_NOT_SIX_WINNING_NUMBERS_MORE_THAN_SIX() {
        assertThatThrownBy(() -> InputValidator.validateWinningNumbers("1,2,3,4,5,6,7"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 수가 존재하면 에러가 발생한다.")
    @Test
    void validateWinningNumbers_DUPLICATE_WINNING_NUMBERS() {
        assertThatThrownBy(() -> InputValidator.validateWinningNumbers("1,2,3,4,5,5"))
            .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("보너스 번호는 숫자가 아니면 에러가 발생한다.")
    @Test
    void validateBonusNumber_NOT_NUMBER() {
        assertThatThrownBy(() -> InputValidator.validateBonusNumber(List.of(1, 2, 3, 4, 5, 6), "a"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1 ~ 45의 범위를 벗어나면 에러가 발생한다.")
    @Test
    void validateBonusNumber_OUT_OF_RANGE() {
        assertThatThrownBy(() -> InputValidator.validateBonusNumber(List.of(1, 2, 3, 4, 5, 6), "100"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 이미 당첨 번호에 존재하면 에러가 발생한다.")
    @Test
    void validateBonusNumber_ALREADY_USED_WINNING_NUMBER() {
        assertThatThrownBy(() -> InputValidator.validateBonusNumber(List.of(1, 2, 3, 4, 5, 6), "1"))
            .isInstanceOf(IllegalArgumentException.class);
    }

}