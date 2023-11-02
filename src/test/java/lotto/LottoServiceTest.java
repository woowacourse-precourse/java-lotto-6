package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    LottoService lottoService = new LottoService();

    @Test
    @DisplayName("구입 금액이 숫자가 아닐 경우 예외가 발생한다.")
    void inputMoneyTypeExceptionTest() {
        String money = "100a";

        Assertions.assertThatThrownBy(
                        () -> lottoService.validateBuyMoney(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구입 금액이 음수일 경우 예외가 발생한다.")
    void inputMoneyNegativeExceptionTest() {
        String money = "-100";

        Assertions.assertThatThrownBy(
                        () -> lottoService.validateBuyMoney(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구입 금액이 1000원 단위가 아닐 경우 예외가 발생한다.")
    void inputMoneyUnitExceptionTest() {
        String money = "500";

        Assertions.assertThatThrownBy(
                        () -> lottoService.validateBuyMoney(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구입 금액이 0원일 경우 예외가 발생한다.")
    void inputMoneyRangeExceptionTest() {
        String money = "0";

        Assertions.assertThatThrownBy(
                        () -> lottoService.validateBuyMoney(money))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
