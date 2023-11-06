package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static lotto.domain.LottoPrice.*;
import static org.assertj.core.api.Assertions.*;

class LottoResultTest {


    @Test
    @DisplayName("당첨 결과에 당첨 내역 넣기 - 성공")
    public void lotto_result_add_price_success() {
        //given
        LottoResult lottoResult = new LottoResult();
        List<LottoPrice> lottoPrices = Arrays.asList(FIFTH, FIRST, FOURTH);

        //when
        for (LottoPrice lottoPrice : lottoPrices) {
            lottoResult.addPrice(lottoPrice);
        }

        //then
        IntStream.range(0, 3).forEach(i -> assertThat(lottoResult.getLottoPrices().get(i)).isEqualTo(lottoPrices.get(i)));
    }


    @Test
    @DisplayName("당첨 결과에서 총 당첨 금액 출력 - 성공")
    public void get_price_money_success() {
        //given
        LottoResult lottoResult = new LottoResult();
        List<LottoPrice> lottoPrices = Arrays.asList(FIFTH, FIRST, FOURTH);

        //when
        for (LottoPrice lottoPrice : lottoPrices) {
            lottoResult.addPrice(lottoPrice);
        }
        int resultMoney = FIFTH.getPriceMoney() + FIRST.getPriceMoney() + FOURTH.getPriceMoney();

        //then
        assertThat(lottoResult.getPriceMoney()).isEqualTo(resultMoney);
    }
}