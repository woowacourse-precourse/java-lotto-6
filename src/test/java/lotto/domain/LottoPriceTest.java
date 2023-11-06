package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        Assertions.assertThat(lottoPriceThird).isEqualTo(LottoPrice.THIRD);
        Assertions.assertThat(lottoPriceSecond).isEqualTo(LottoPrice.SECOND);

    }
}