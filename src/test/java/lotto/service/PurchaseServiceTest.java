package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.LottoReceipt;
import lotto.service.generator.RandomLottoGenerator;
import lotto.service.generator.RandomNumbersGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseServiceTest {

    PurchaseService purchaseService = new PurchaseService(
            new RandomLottoGenerator(new RandomNumbersGenerator()));

    @Test
    @DisplayName("올바른 액수가 아닐 경우 예외가 발생한다.")
    public void illegalAmountMoney() {
        // when, then
        Assertions.assertThatThrownBy(() -> purchaseService.purchaseLotto(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 한 장이 정확하게 발급된다.")
    public void purchaseLotto() {
        // given
        int money = 1_000;

        // when
        LottoReceipt lottoReceipt = purchaseService.purchaseLotto(money);

        // then
        assertThat(lottoReceipt.getLotteryCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 여러 장이 정확하게 발급된다.")
    public void purchaseMultipleLotto() {
        // given
        int money = 5_000;

        // when
        LottoReceipt lottoReceipt = purchaseService.purchaseLotto(money);

        // then
        assertThat(lottoReceipt.getLotteryCount()).isEqualTo(5);
    }
}
