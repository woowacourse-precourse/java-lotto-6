package lotto;

import lotto.controller.GameController;
import lotto.controller.LottoIssueController;
import lotto.controller.WinningNumberController;
import lotto.domain.*;
import lotto.domain.constants.ExceptionMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자는 로또 구입 금액을 입력할 수 있다.")
    @Test
    void createMoneyByInput() {
        assertThat(new Money("3000")).isNotNull();
    }

    @DisplayName("로또 구입 금액을 입력할 때 숫자가 아닌 값이 포함되어 있으면 예외가 발생한다.")
    @Test
    void createMoneyByNonNumericalValue() {
        assertThatThrownBy(() -> new Money("AAA"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NOT_NUMBER.getMessage());
    }

    @DisplayName("로또 구입 금액을 입력할 때 1,000원 단위가 아니면 예외가 발생한다.")
    @Test
    void createMoneyByNon1000Units() {
        assertThatThrownBy(() -> new Money("30"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INPUT_MONEY_NOT_PRICE_UNIT.getMessage());
    }

    @DisplayName("당첨 번호를 입력할 때 숫자가 아닌 값이 포함되어 있으면 예외가 발생한다.")
    @Test
    void setWinningNumbersByNonNumericalValue() {
        WinningNumbers winningNumbers = new WinningNumbers();
        String playerInput = "A,2,3,4,5,6";
        WinningNumberController winningNumberController = new WinningNumberController();

        assertThatThrownBy(() -> winningNumberController.setInputToWinningNumbers(winningNumbers, playerInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NOT_NUMBER.getMessage());
    }

    @DisplayName("당첨 번호가 1 ~ 45의 범위를 벗어날 경우 예외가 발생한다.")
    @Test
    void setWinningNumbersByOutOfRangeNumber() {
        WinningNumbers winningNumbers = new WinningNumbers();
        String playerInput = "100,2,3,4,5,6";
        WinningNumberController winningNumberController = new WinningNumberController();

        assertThatThrownBy(() -> winningNumberController.setInputToWinningNumbers(winningNumbers, playerInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NUMBER_OUT_OF_RANGE.getMessage());
    }

    @DisplayName("당첨 번호의 개수가 6개가 아니면 예외가 발생한다.")
    @Test
    void setWinningNumbersByOverSize() {
        WinningNumbers winningNumbers = new WinningNumbers();
        String playerInput = "1,2,3,4,5,6,7";
        WinningNumberController winningNumberController = new WinningNumberController();

        assertThatThrownBy(() -> winningNumberController.setInputToWinningNumbers(winningNumbers, playerInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.WINNING_NUMBERS_COUNT_OUT_OF_RANGE.getMessage());
    }

    @DisplayName("당첨 번호에 중복된 값이 있으면 예외가 발생한다.")
    @Test
    void setWinningNumbersByDuplicateNumber() {
        WinningNumbers winningNumbers = new WinningNumbers();
        String playerInput = "1,2,3,3,5,6";
        WinningNumberController winningNumberController = new WinningNumberController();

        assertThatThrownBy(() -> winningNumberController.setInputToWinningNumbers(winningNumbers, playerInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.WINNING_NUMBERS_DUPLICATION.getMessage());
    }

    @DisplayName("보너스 번호를 입력할 때 숫자가 아닌 값이 포함되어 있으면 예외가 발생한다.")
    @Test
    void setBonusNumberByNonNumericalValue() {
        WinningNumbers winningNumbers = new WinningNumbers();
        BonusNumber bonusNumber = new BonusNumber();
        String playerInput = "A";
        WinningNumberController winningNumberController = new WinningNumberController();

        assertThatThrownBy(() -> winningNumberController.setInputToBonusNumber(winningNumbers, bonusNumber, playerInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NOT_NUMBER.getMessage());
    }

    @DisplayName("보너스 번호가 1 ~ 45의 범위를 벗어날 경우 예외가 발생한다.")
    @Test
    void setBonusNumberByOutOfRangeNumber() {
        WinningNumbers winningNumbers = new WinningNumbers();
        BonusNumber bonusNumber = new BonusNumber();
        String playerInput = "100";
        WinningNumberController winningNumberController = new WinningNumberController();

        assertThatThrownBy(() -> winningNumberController.setInputToBonusNumber(winningNumbers, bonusNumber, playerInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NUMBER_OUT_OF_RANGE.getMessage());
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복될 경우 예외가 발생한다.")
    @Test
    void setBonusNumberByDuplicateNumber() {
        WinningNumbers winningNumbers = new WinningNumbers();
        winningNumbers.setWinningNumbers(List.of(1, 2, 3, 4, 5, 6));

        BonusNumber bonusNumber = new BonusNumber();
        String playerInput = "1";
        WinningNumberController winningNumberController = new WinningNumberController();

        assertThatThrownBy(() -> winningNumberController.setInputToBonusNumber(winningNumbers, bonusNumber, playerInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.BONUS_NUMBER_DUPLICATION_WITH_WINNING_NUMBERS.getMessage());
    }

}