package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PrizeTest {

    @Test
    void 매칭되는_타입이_없으면_NONE_기본값_생성() {
        int numOfMatches = 10;
        boolean bonusNumberIncluded = true;

        Assertions.assertThat(Prize.valueOf(numOfMatches, bonusNumberIncluded))
                .isEqualTo(Prize.NONE);
    }

    @Test
    void 여러_조건_매칭될_경우_제일_상금이_높은_값으로_생성() {
        int numOfMatches = Prize.THIRD.getNumberOfMatches();
        boolean bonusNumberIncluded = Prize.SECOND.isBonusIncluded();

        Assertions.assertThat(Prize.valueOf(numOfMatches, bonusNumberIncluded))
                .isEqualTo(Prize.SECOND);
    }

    @Test
    void 보너스_번호_매칭_여부에_관계없이_같은_값_생성() {
        int numOfMatches = Prize.FOURTH.getNumberOfMatches();
        boolean bonusNumberIncluded = Prize.FOURTH.isBonusIncluded();

        Assertions.assertThat(Prize.valueOf(numOfMatches, bonusNumberIncluded))
                .isEqualTo(Prize.valueOf(numOfMatches, !bonusNumberIncluded));
    }

}