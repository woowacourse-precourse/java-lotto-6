package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {
    @DisplayName("로또 구매 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void inputLottoPurchaseAmountByType() {
        assertThatThrownBy(() -> new Player().setPurchaseAmount("one"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매 금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void inputLottoPurchaseAmountByDivided() {
        assertThatThrownBy(() -> new Player().setPurchaseAmount("100"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 번호의 개수가 6개가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
    void inputLottoWinningNumbersBySize(String input) {
        assertThatThrownBy(() -> new Player().setWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 번호가 1~45 사이의 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0,1,2,3,4,5", "41,42,43,44,45,46"})
    void inputLottoWinningNumbersByValue(String input) {
        assertThatThrownBy(() -> new Player().setWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void inputLottoWinningNumbersByValue() {
        assertThatThrownBy(() -> new Player().setWinningNumbers("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 보너스 번호가 1~45 사이의 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"0", "46"})
    void inputLottoBonusNumberByValue(String input) {
        assertThatThrownBy(() -> new Player().setBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 보너스 번호가 로또 당첨 번호에 포함되면 예외가 발생한다.")
    @Test
    void inputLottoBonusNumberByDuplicatedWithLottoWinningNumbers() {
        Player player = new Player();
        player.setWinningNumbers("1,2,3,4,5,6");

        assertThatThrownBy(() -> player.setBonusNumber("1"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}