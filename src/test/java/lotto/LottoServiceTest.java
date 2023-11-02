package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    LottoService lottoService = new LottoService();

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
}
