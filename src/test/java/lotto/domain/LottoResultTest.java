package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static lotto.domain.LottoPrize.*;
import static org.assertj.core.api.Assertions.*;

class LottoResultTest {


    @Test
    @DisplayName("당첨 결과에 당첨 내역 넣기 - 성공")
    public void lotto_result_add_prize_success() {
        //given
        LottoResult lottoResult = new LottoResult();
        List<LottoPrize> lottoPrizes = Arrays.asList(FIFTH, FIRST, FOURTH);

        //when
        for (LottoPrize lottoPrize : lottoPrizes) {
            lottoResult.addPrize(lottoPrize);
        }

        //then
        IntStream.range(0, 3).forEach(i -> assertThat(lottoResult.getLottoPrizes().get(i)).isEqualTo(lottoPrizes.get(i)));
    }


    @Test
    @DisplayName("당첨 결과에서 총 당첨 금액 출력 - 성공")
    public void get_prize_money_success() {
        //given
        LottoResult lottoResult = new LottoResult();
        List<LottoPrize> lottoPrizes = Arrays.asList(FIFTH, FIRST, FOURTH);

        //when
        for (LottoPrize lottoPrize : lottoPrizes) {
            lottoResult.addPrize(lottoPrize);
        }
        int resultMoney = FIFTH.getPrizeMoney() + FIRST.getPrizeMoney() + FOURTH.getPrizeMoney();

        //then
        assertThat(lottoResult.getPrizeMoney()).isEqualTo(resultMoney);
    }
}