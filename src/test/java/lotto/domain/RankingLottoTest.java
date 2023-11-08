package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RankingLottoTest {
    @ParameterizedTest
    @CsvSource({"5,true,SECOND","5,false,THIRD"})
    public void enumTest(int matchLottoNumber, boolean containBonusNumber, RankingLotto rankValue){
        RankingLotto rankingLotto = RankingLotto.getPrize(matchLottoNumber, containBonusNumber);
        assertThat(rankingLotto).isEqualTo(rankValue);
    }

    @ParameterizedTest
    @CsvSource({"6,2_000_000_000,FIRST","5,30_000_000,SECOND"})
    public void enumSourceTest(int matchNum, int money, RankingLotto rankingLotto){
        int matchLottoNum = rankingLotto.getMatchLottoNumber();
        int prizeMoney = rankingLotto.getPrizeMoney();
        assertThat(matchLottoNum).isEqualTo(matchNum);
        assertThat(prizeMoney).isEqualTo(money);
    }
}