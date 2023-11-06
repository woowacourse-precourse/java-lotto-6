package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import lotto.constants.ErrorMessages;
import lotto.constants.GameInfo;
import lotto.controller.LottoGameController;
import lotto.validator.impl.BonusNumberValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    private LottoGameController lottoGameController;
    private BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();

    @DisplayName("보너스 번호가 범위를 넘어서면 예외가 발생한다.")
    @Test
    void createBonusNumberOverRange() {
        assertThatThrownBy(
            () -> new BonusNumber(String.valueOf(GameInfo.LOTTO_MAX_NUMBER.getNumber() + 1),
                bonusNumberValidator))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageMatching(ErrorMessages.INPUT_BONUS_NUMBER_RANGE.getMessage());
    }

    @DisplayName("보너스 번호가 범위보다 작으면 예외가 발생한다.")
    @Test
    void createBonusNumberUnderRange() {
        assertThatThrownBy(
            () -> new BonusNumber(String.valueOf(GameInfo.LOTTO_MIN_NUMBER.getNumber() - 1),
                bonusNumberValidator))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageMatching(ErrorMessages.INPUT_BONUS_NUMBER_RANGE.getMessage());
    }

    @DisplayName("보너스 번호가 숫자가 아니면 예외가 발생한다.")
    @Test
    void createBonusNumberNotNumber() {
        assertThatThrownBy(
            () -> new BonusNumber("a", bonusNumberValidator))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageMatching(ErrorMessages.INPUT_BONUS_NUMBER_NUMERIC.getMessage());
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void createBonusNumberDuplicated() {
        // given
        lottoGameController = new LottoGameController();

        //when
        lottoGameController.initWinningNumbers("1,2,3,4,5,6");
        BonusNumber bonusNumber = new BonusNumber("1", bonusNumberValidator);

        // then
        assertThatThrownBy(() -> bonusNumber.validateDuplicatedWithWinning(lottoGameController.getWinningNumbersBitSet()))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageMatching(ErrorMessages.INPUT_BONUS_NUMBER_DUPLICATE.getMessage());
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되지 않으면 예외가 발생하지 않는다.")
    @Test
    void createBonusNumberNotDuplicated() {
        // given
        lottoGameController = new LottoGameController();

        //when
        lottoGameController.initWinningNumbers("1,2,3,4,5,6");
        BonusNumber bonusNumber = new BonusNumber("7", bonusNumberValidator);

        // then
        assertDoesNotThrow(() -> bonusNumber.validateDuplicatedWithWinning(lottoGameController.getWinningNumbersBitSet()));
    }
}