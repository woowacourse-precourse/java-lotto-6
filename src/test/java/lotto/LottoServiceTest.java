package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    LottoService lottoService = new LottoService();

    @DisplayName("구입 금액을 1000원으로 나누어 로또를 발행한다.")
    @Test
    void inputMoneyCalculateLottoTicket() {
        String money = "8000";
        int lottoTicket = lottoService.calculateLottoTicket(money);

        Assertions.assertThat(lottoTicket).isEqualTo(8);
    }

    @DisplayName("구입 금액이 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void inputMoneyTypeExceptionTest() {
        String money = "100a";

        Assertions.assertThatThrownBy(
                        () -> lottoService.validateBuyMoney(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 음수일 경우 예외가 발생한다.")
    @Test
    void inputMoneyNegativeExceptionTest() {
        String money = "-100";

        Assertions.assertThatThrownBy(
                        () -> lottoService.validateBuyMoney(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000원 단위가 아닐 경우 예외가 발생한다.")
    @Test
    void inputMoneyUnitExceptionTest() {
        String money = "500";

        Assertions.assertThatThrownBy(
                        () -> lottoService.validateBuyMoney(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 0원일 경우 예외가 발생한다.")
    @Test
    void inputMoneyRangeExceptionTest() {
        String money = "0";

        Assertions.assertThatThrownBy(
                        () -> lottoService.validateBuyMoney(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액에 공백이 포함된 경우 예외가 발생한다.")
    @Test
    void inputMoneyBlankExceptionTest() {
        String money = "80 00";

        Assertions.assertThatThrownBy(
                        () -> lottoService.validateBuyMoney(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 1 ~ 45 범위의 숫자가 아닐경우 예외가 발생한다.")
    @Test
    void inputWinningNumberRangeExceptionTest() {
        String winningNumber = "46";

        Assertions.assertThatThrownBy(
                        () -> lottoService.validateWinningNumber(winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
