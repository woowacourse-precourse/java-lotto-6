package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PrizeTest {

    @ParameterizedTest
    @CsvSource(value = {"10, true", "20, false", "1, false"})
    void 매칭되는_타입이_없으면_NONE_기본값_생성(int numOfMatches, boolean bonusMatched) {
        assertThat(Prize.valueOf(numOfMatches, bonusMatched))
                .isEqualTo(Prize.NONE);
    }

    @Test
    void 여러_조건_매칭될_경우_제일_상금이_높은_값으로_생성() {
        int numOfMatches = Prize.THIRD.getNumberOfMatches();
        boolean bonusMatched = Prize.SECOND.isBonusIncluded();

        assertThat(Prize.valueOf(numOfMatches, bonusMatched))
                .isEqualTo(Prize.SECOND);
    }

    @Test
    void 보너스_번호_매칭_여부에_관계없이_같은_값_생성() {
        int numOfMatches = Prize.FOURTH.getNumberOfMatches();
        boolean bonusMatched = Prize.FOURTH.isBonusIncluded();

        assertThat(Prize.valueOf(numOfMatches, bonusMatched))
                .isEqualTo(Prize.valueOf(numOfMatches, !bonusMatched));
    }

    @Test
    void 보너스_번호_매칭_여부에_따라_다른_반환값_생성() {
        int numOfMatches = 5;
        boolean bonusMatched = true;

        Prize secondExpected = Prize.valueOf(numOfMatches, bonusMatched);
        Prize thirdExpected = Prize.valueOf(numOfMatches, !bonusMatched);

        assertThat(secondExpected).isEqualTo(Prize.SECOND);
        assertThat(thirdExpected).isEqualTo(Prize.THIRD);
    }

}