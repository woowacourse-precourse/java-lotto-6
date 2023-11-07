package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPrizeTest {


    @Test
    @DisplayName("맞힌 횟수, 보너스 번호에 따른 당첨 내역 반환 - 성공")
    public void get_lotto_prize_by_matches_number() {
        //given
        int matchesNumber = 5;
        boolean bonusNumberFalse = false;
        boolean bonusNumberTrue = true;

        //when
        LottoPrize lottoPrizeThird = LottoPrize.getLottoPrizeByMatchesNumber(matchesNumber, bonusNumberFalse);
        LottoPrize lottoPrizeSecond = LottoPrize.getLottoPrizeByMatchesNumber(matchesNumber, bonusNumberTrue);

        //then
        assertThat(lottoPrizeThird).isEqualTo(LottoPrize.THIRD);
        assertThat(lottoPrizeSecond).isEqualTo(LottoPrize.SECOND);

    }

    @Test
    @DisplayName("등수에 따른 당첨 내역 반환 - 성공")
    public void get_lotto_prize_by_prize() {
        //given
        int prizeSecond = 2;
        int prizeFourth = 4;

        //when
        LottoPrize lottoPrizeSecond = LottoPrize.getLottoPrizeByPrize(prizeSecond);
        LottoPrize lottoPrizeFourth = LottoPrize.getLottoPrizeByPrize(prizeFourth);

        //then
        assertThat(lottoPrizeSecond).isEqualTo(LottoPrize.SECOND);
        assertThat(lottoPrizeFourth).isEqualTo(LottoPrize.FOURTH);

    }
}