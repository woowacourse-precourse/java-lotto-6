package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPriceTest {


    @Test
    @DisplayName("맞힌 횟수, 보너스 번호에 따른 당첨 내역 반환 - 성공")
    public void get_lotto_price_by_matches_number() {
        //given
        int matchesNumber = 5;
        boolean bonusNumberFalse = false;
        boolean bonusNumberTrue = true;

        //when
        LottoPrice lottoPriceThird = LottoPrice.getLottoPriceByMatchesNumber(matchesNumber, bonusNumberFalse);
        LottoPrice lottoPriceSecond = LottoPrice.getLottoPriceByMatchesNumber(matchesNumber, bonusNumberTrue);

        //then
        assertThat(lottoPriceThird).isEqualTo(LottoPrice.THIRD);
        assertThat(lottoPriceSecond).isEqualTo(LottoPrice.SECOND);

    }

    @Test
    @DisplayName("등수에 따른 당첨 내역 반환 - 성공")
    public void get_lotto_price_by_prize() {
        //given
        int prizeSecond = 2;
        int prizeFourth = 4;

        //when
        LottoPrice lottoPriceSecond = LottoPrice.getLottoPriceByPrize(prizeSecond);
        LottoPrice lottoPriceFourth = LottoPrice.getLottoPriceByPrize(prizeFourth);

        //then
        assertThat(lottoPriceSecond).isEqualTo(LottoPrice.SECOND);
        assertThat(lottoPriceFourth).isEqualTo(LottoPrice.FOURTH);

    }
}