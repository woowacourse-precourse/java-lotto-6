package lottovender;

import lotto.controller.LottoVender;
import lotto.domain.Lotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
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
        //비교 대상 로또
        List<Integer> testNumbers = new ArrayList<>();
        testNumbers.add(3);
        testNumbers.add(5);
        testNumbers.add(14);
        testNumbers.add(17);
        testNumbers.add(22);
        testNumbers.add(41);
        Lotto testLotto = new Lotto(testNumbers);

        LottoVender lv = new LottoVender();
        List<Lotto> lottoticekts = lv.getLotto(1);

        for(Lotto lotto:lottoticekts){
            assertThat(lotto).isEqualTo(testLotto);
        }
    }
}