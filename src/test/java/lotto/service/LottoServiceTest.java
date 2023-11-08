package lotto.service;

import lotto.domain.Lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.constant.NumericConstant.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {
    LottoService lottoService = new LottoService();
    @Test
    @DisplayName("구입되는 로또의 수량은 구매금액에서 로또가격을 나눈 값이어야 한다.")
    void buyLotto() {
        int money = 5000;

        List<Lotto> lottos = lottoService.buyLotto(5000);
        assertThat(lottos.size()).isEqualTo(money / LOTTO_PRICE);
    }


}