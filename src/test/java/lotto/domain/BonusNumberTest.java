package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.BitSet;
import lotto.constants.ErrorMessages;
import lotto.constants.GameInfo;
import lotto.controller.LottoGameController;
import lotto.util.Parser;
import lotto.validator.impl.BonusNumberValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BonusNumberTest {

    @DisplayName("보너스 번호가 범위를 넘어서면 예외가 발생한다.")
    @Test
    void createBonusNumberOverRange() {
        // given
        BonusNumberValidator bonusNumberValidator = Mockito.mock(BonusNumberValidator.class);
        String overRangeNumber = String.valueOf(GameInfo.LOTTO_MAX_NUMBER.getNumber() + 1);

        // when
        Mockito.doThrow(
                new IllegalArgumentException(ErrorMessages.INPUT_BONUS_NUMBER_RANGE.getMessage()))
            .when(bonusNumberValidator).validate(overRangeNumber);

        // then
        assertThatThrownBy(
            () -> new BonusNumber(overRangeNumber, bonusNumberValidator))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageMatching(ErrorMessages.INPUT_BONUS_NUMBER_RANGE.getMessage());
    }

    @DisplayName("보너스 번호가 범위보다 작으면 예외가 발생한다.")
    @Test
    void createBonusNumberUnderRange() {
        // given
        BonusNumberValidator bonusNumberValidator = Mockito.mock(BonusNumberValidator.class);
        String underRangeNumber = String.valueOf(GameInfo.LOTTO_MIN_NUMBER.getNumber() - 1);

        // when
        Mockito.doThrow(
                new IllegalArgumentException(ErrorMessages.INPUT_BONUS_NUMBER_RANGE.getMessage()))
            .when(bonusNumberValidator).validate(underRangeNumber);

        // then
        assertThatThrownBy(
            () -> new BonusNumber(underRangeNumber, bonusNumberValidator))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageMatching(ErrorMessages.INPUT_BONUS_NUMBER_RANGE.getMessage());
    }

    @DisplayName("보너스 번호가 숫자가 아니면 예외가 발생한다.")
    @Test
    void createBonusNumberNotNumber() {
        // given
        String notNumber = "a";
        BonusNumberValidator bonusNumberValidator = Mockito.mock(BonusNumberValidator.class);

        // when
        Mockito.doThrow(
                new IllegalArgumentException(ErrorMessages.INPUT_BONUS_NUMBER_NUMERIC.getMessage()))
            .when(bonusNumberValidator).validate(notNumber);

        // then
        assertThatThrownBy(
            () -> new BonusNumber(notNumber, bonusNumberValidator))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageMatching(ErrorMessages.INPUT_BONUS_NUMBER_NUMERIC.getMessage());
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void createBonusNumberDuplicated() {
        // given
        BonusNumberValidator bonusNumberValidator = Mockito.mock(BonusNumberValidator.class);
        BonusNumber bonusNumber = Mockito.mock(BonusNumber.class);

        String winningNumbers = "1,2,3,4,5,6";
        String duplicatedNumber = "1";
        BitSet winningNumbersBitSet = Parser.parseToBitSet(Parser.parseToIntegerList(winningNumbers));

        //when
        Mockito.doNothing().when(bonusNumberValidator).validate(duplicatedNumber);
        Mockito.when(bonusNumber.getBonusNumber()).thenReturn(Parser.parseToInt(duplicatedNumber));
        Mockito.doThrow(
                new IllegalArgumentException(ErrorMessages.INPUT_BONUS_NUMBER_DUPLICATE.getMessage()))
            .when(bonusNumber).validateDuplicatedWithWinning(winningNumbersBitSet);

        // then
        assertDoesNotThrow(() -> bonusNumberValidator.validate(duplicatedNumber));
        assertThatThrownBy(() -> bonusNumber.validateDuplicatedWithWinning(
            winningNumbersBitSet))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageMatching(ErrorMessages.INPUT_BONUS_NUMBER_DUPLICATE.getMessage());
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되지 않으면 예외가 발생하지 않는다.")
    @Test
    void createBonusNumberNotDuplicated() {
        // given
        BonusNumberValidator bonusNumberValidator = Mockito.mock(BonusNumberValidator.class);
        BonusNumber bonusNumber = Mockito.mock(BonusNumber.class);

        String winningNumbers = "1,2,3,4,5,6";
        String notDuplicatedNumber = "7";
        BitSet winningNumbersBitSet = Parser.parseToBitSet(Parser.parseToIntegerList(winningNumbers));

        //when
        Mockito.when(bonusNumber.getBonusNumber()).thenReturn(Parser.parseToInt(notDuplicatedNumber));

        // then
        assertDoesNotThrow(() -> bonusNumber.validateDuplicatedWithWinning(winningNumbersBitSet));
    }
}