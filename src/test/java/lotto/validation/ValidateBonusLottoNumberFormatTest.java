package lotto.validation;

import lotto.exception.InvalidDuplicatedNumberException;
import lotto.exception.InvalidLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValidateBonusLottoNumberFormatTest {

    @DisplayName("입력 받은 보너스 당첨 번호가 로또번호 형식이 아니면 예외를 발생시킨다.")
    @Test
    void inputBonusWinningNumberByInvalidLottoNumberFormat() {
        String firstInputBonusWinningNumber = "보너스";
        String secondInputBonusWinningNumber = "보너스";
        String[] existingWinningNumbers = {"1", "2", "3", "4", "5", "6"};

        assertThatThrownBy(() -> ValidateBonusLottoNumberFormat.validate(firstInputBonusWinningNumber, existingWinningNumbers))
                .isInstanceOf(InvalidLottoNumberException.class);

        assertThatThrownBy(() -> ValidateBonusLottoNumberFormat.validate(secondInputBonusWinningNumber, existingWinningNumbers))
                .isInstanceOf(InvalidLottoNumberException.class);
    }

    @DisplayName("입력 받은 보너스 당첨 번호가 기존 당첨 번호와 중복되면 예외를 발생시킨다.")
    @Test
    void inputBonusWinningNumberByInvalidDuplicatedWinningNumber() {
        String inputBonusWinningNumber = "1";
        String[] existingWinningNumbers = {"1", "2", "3", "4", "5", "6"};

        assertThatThrownBy(() -> ValidateBonusLottoNumberFormat.validate(inputBonusWinningNumber, existingWinningNumbers))
                .isInstanceOf(InvalidDuplicatedNumberException.class);
    }
}