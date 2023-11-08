package lotto.util.validator;

import lotto.util.exception.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BonusNumberValidatorTest {
    @DisplayName("보너스 번호 유효성 검사 - 정상 입력")
    @Test
    void validateBonusNumber_ValidInput() {
        BonusNumberValidator validator = new BonusNumberValidator();
        String inputBonusNumber = "15";
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        int bonusNumber = validator.validateBonusNumber(inputBonusNumber, winningNumbers);

        assertThat(bonusNumber).isEqualTo(15);
    }

    @DisplayName("보너스 번호 유효성 검사 - null 입력")
    @Test
    void validateBonusNumber_NullInput() {
        BonusNumberValidator validator = new BonusNumberValidator();
        String inputBonusNumber = null;
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> validator.validateBonusNumber(inputBonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.NULL_OR_EMPTY_BONUS_NUMBER.getMessage());
    }

    @DisplayName("보너스 번호 유효성 검사 - 빈 문자열 입력")
    @Test
    void validateBonusNumber_EmptyInput() {
        BonusNumberValidator validator = new BonusNumberValidator();
        String inputBonusNumber = "";
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> validator.validateBonusNumber(inputBonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.NULL_OR_EMPTY_BONUS_NUMBER.getMessage());
    }

    @DisplayName("보너스 번호 유효성 검사 - 숫자 형식이 아닌 입력")
    @Test
    void validateBonusNumber_InvalidType() {
        BonusNumberValidator validator = new BonusNumberValidator();
        String inputBonusNumber = "abc";
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> validator.validateBonusNumber(inputBonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.INVALID_BONUS_NUMBER_TYPE.getMessage());
    }

    @DisplayName("보너스 번호 유효성 검사 - 범위를 벗어난 숫자 입력")
    @Test
    void validateBonusNumber_OutOfRange() {
        BonusNumberValidator validator = new BonusNumberValidator();
        String inputBonusNumber = "50";
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> validator.validateBonusNumber(inputBonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.INVALID_BONUS_NUMBER_RANGE.getMessage());
    }

    @DisplayName("보너스 번호 유효성 검사 - 이미 당첨 번호에 있는 숫자 입력")
    @Test
    void validateBonusNumber_DuplicateNumber() {
        BonusNumberValidator validator = new BonusNumberValidator();
        String inputBonusNumber = "3";
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> validator.validateBonusNumber(inputBonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.DUPLICATE_BONUS_NUMBER.getMessage());
    }
}