package lotto.validator;

import static lotto.exception.ExceptionMessage.DUPLICATE_NUMBER;
import static lotto.exception.ExceptionMessage.EMPTY_VALUE;
import static lotto.exception.ExceptionMessage.INVALID_WINNING_NUMBER_FORMAT;
import static lotto.exception.ExceptionMessage.NOT_MULTIPLE_OF_THOUSAND;
import static lotto.exception.ExceptionMessage.NOT_NUMERIC_VALUE;
import static lotto.exception.ExceptionMessageBuilder.build;
import static lotto.util.MessageBuilder.buildInvalidLottoNumberRangeMessage;
import static lotto.util.MessageBuilder.buildInvalidWinningNumberMessage;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.config.GameConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {
    @DisplayName("빈 값이 들어올 경우 예외가 발생한다.")
    @Test
    void validateEmptyValue() {
        // given
        String value = "";

        // when & then
        assertThatThrownBy(() -> InputValidator.validateEmptyValue(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EMPTY_VALUE.getMessage());
    }

    @DisplayName("숫자가 아닌 값이 들어올 경우 예외가 발생한다.")
    @Test
    void validateNumericValue() {
        // given
        String value = "1a23b";

        // when & then
        assertThatThrownBy(() -> InputValidator.validateNumericValue(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_NUMERIC_VALUE.getMessage());
    }

    @DisplayName("당첨 번호 입력 형식이 올바르지 않을 경우 예외가 발생한다.")
    @Test
    void validateWinningNumberFormat() {
        // given
        String value = "1, 2,3, 5, 6, 7";

        // when & then
        assertThatThrownBy(() -> InputValidator.validateWinningNumberFormat(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_WINNING_NUMBER_FORMAT.getMessage());
    }

    @DisplayName("번호가 로또 번호 범위를 벗어날 경우 예외가 발생한다.")
    @Test
    void validateLottoNumberRange() {
        // given
        Integer value = GameConfig.END_INCLUSIVE + 1;

        // when & then
        assertThatThrownBy(() -> InputValidator.validateLottoNumberRange(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(build(buildInvalidLottoNumberRangeMessage()));
    }

    @DisplayName("구매 금액이 1,000단위가 아닐 경우 예외가 발생한다.")
    @Test
    void validateMultipleNumberOfThousand() {
        // given
        Integer value = 1_111;

        // when & then
        assertThatThrownBy(() -> InputValidator.validateMultipleNumberOfThousand(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_MULTIPLE_OF_THOUSAND.getMessage());
    }

    @DisplayName("중복된 숫자가 존재할 경우 예외가 발생한다.")
    @Test
    void validateDuplicateNumber() {
        // given
        List<Integer> numbers = List.of(1, 1, 2, 3, 4, 5);

        // when & then
        assertThatThrownBy(() -> InputValidator.validateDuplicateNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_NUMBER.getMessage());
    }

    @DisplayName("보너스 숫자가 이미 당첨 번호에 포함될 경우 예외가 발생한다.")
    @Test
    void validateBonusNumber() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 1;

        // when & then
        assertThatThrownBy(() -> InputValidator.validateBonusNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_NUMBER.getMessage());
    }

    @DisplayName("로또 번호 개수가 정확하지 않을 경우 예외가 발생한다.")
    @Test
    void validateLottoNumberCount() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5);

        // when & then
        assertThatThrownBy(() -> InputValidator.validateLottoNumberCount(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(build(buildInvalidWinningNumberMessage()));
    }
}
