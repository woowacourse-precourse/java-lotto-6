package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoWinningTest {

    @ParameterizedTest
    @CsvSource(value = {
            "6,false,FIRST",
            "5,true,SECOND",
            "5,false,THIRD",
            "4,false,FOURTH",
            "3,false,FIFTH",
            "2,false,LOSE",
            "1,false,LOSE"
    })
    void 번호_일치_개수와_보너스_번호_일치_여부로_당첨여부를_알_수_있다(
            int matchCount,
            boolean isBonusMated,
            LottoWinning lottoWinning
    ) {
        assertThat(LottoWinning.findByMatchOf(matchCount, isBonusMated))
                .isEqualTo(lottoWinning);
    }
}