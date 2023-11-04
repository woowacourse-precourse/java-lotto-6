package lotto.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoControllerTest {

    @Test
    @DisplayName("로또 금액은 숫자만 입력 가능")
    public void LottoPurchasePriceTest1() {
        LottoController lottoController = new LottoController();

        Assertions.assertThatThrownBy(() -> lottoController.buyLotteries("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 금액은 숫자만 입력 가능합니다.");
    }

    @Test
    @DisplayName("로또는 1000원 단위로만 구입 가능합니다.")
    public void LottoPurchasePriceTest2() {
        LottoController lottoController = new LottoController();

        Assertions.assertThatThrownBy(() -> lottoController.buyLotteries("2100"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또는 1000원 단위로만 구매할 수 있습니다.");
    }
}