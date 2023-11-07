package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoBuyServiceTest {

    @DisplayName("구입가격에 따른 로또 수량 확인")
    @Test
    void getLottoAmount() {
        LottoBuyService lottoBuyService = new LottoBuyService();
        int price = 10000;
        int lottoAmount = lottoBuyService.getLottoAmount(price);
        assertThat(lottoAmount).isEqualTo(10);
    }

    @Test
    void exchangeLotto() {
        LottoBuyService lottoBuyService = new LottoBuyService();
        int lottoAmount = 10;
        List<Lotto> lottos = lottoBuyService.exchangeLotto(lottoAmount);
        for (Lotto lotto : lottos) {
            assertThat(lotto).isInstanceOf(Lotto.class);
        }
    }
}