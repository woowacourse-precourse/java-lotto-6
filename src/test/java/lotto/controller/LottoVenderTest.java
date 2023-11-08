package lotto.controller;

import lotto.controller.LottoVender;
import lotto.domain.Lotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoVenderTest {

    @DisplayName("지불한 금액 만큼 로또 발행수 카운트")
    @Test
    void pay_price_for_lotto() {
        LottoVender lv = new LottoVender();
        lv.payPrice(15000);
        Assertions.assertTrue(lv.getLottoCount()==15);
    }

    @DisplayName("로또 발행")
    @Test
    void get_lotto() {
        LottoVender lv = new LottoVender();
        List<Lotto> lottoticekts = lv.getLotto(1);

        for(Lotto lotto:lottoticekts){
            assertThat(lotto.getNumbers().size()).isEqualTo(6);
        }
    }

    @DisplayName("당첨 금액 계산")
    @Test
    void get_total_profit() {
        LottoVender lv = new LottoVender();
        List<Integer> result = List.of(1,0,0,0,0);
        assertThat(lv.getTotalProfit(result)).isEqualTo(5000);
    }
}