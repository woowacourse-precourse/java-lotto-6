package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.InputView;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest {

    @DisplayName("구입 금액이 숫자가 아닌 경우")
    @Test
    void inputMoneyByNotNumber() {
        assertThatThrownBy(() -> InputView.inputMoney("1000k"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 단위로 나누어 떨이지지 않는 경우")
    @Test
    void createMoneyByNotUnit() {
        assertThatThrownBy(() -> new User(1001))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 음수인 경우")
    @Test
    void createMoneyByNegativeNumber() {
        assertThatThrownBy(() -> new User(-1000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력 시 숫자가 아닌 경우")
    @Test
    void createWinningNumberByNotNumber() {
        assertThatThrownBy(() -> InputView.inputWinningNumbers("1,2,3,4,j,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력 시 올바르지 않은 숫자를 넣은 경우 ")
    @Test
    void createWinningNumberByNotLottoNumber() {
        assertThatThrownBy(() -> InputView.inputWinningNumbers("0,12,1,2,3,4"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("당첨 번호 입력 시 올바르지 않은 숫자를 넣지 않은 경우 ")
    @Test
    void createWinningNumberByNotLottoNumber2() {
        assertThatThrownBy(() -> InputView.inputWinningNumbers("46,45,1,2,3,4"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력 시 공백이 포함된 경우")
    @Test
    void createWinningNumberByBlank() {
        assertThatThrownBy(() -> InputView.inputWinningNumbers("1,2,3,4,,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 일벽 시 숫자가 아닌 경우")
    @Test
    void createBonusNumberByNotNumber() {
        assertThatThrownBy(() -> InputView.inputBonus("10k"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력 시 올바르지 않은 숫자를 넣은 경우")
    @Test
    void createBonusNumberByNotRangeNumber() {
        assertThatThrownBy(() -> InputView.inputBonus("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력 시 올바르지 않은 숫자를 넣은 경우")
    @Test
    void createBonusNumberByNotRangeNumber2() {
        assertThatThrownBy(() -> InputView.inputBonus("46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
