package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RankingLottoTest {
    @ParameterizedTest
    @CsvSource({"5,true,SECOND","5,false,THIRD"})
    @DisplayName("getPrize 메소드 작동")
    public void enumTest(int matchLottoNumber, boolean containBonusNumber, RankingLotto rankValue){
        RankingLotto rankingLotto = RankingLotto.getPrize(matchLottoNumber, containBonusNumber);
        assertThat(rankingLotto).isEqualTo(rankValue);
    }

    @ParameterizedTest
    @CsvSource({"6,2_000_000_000,FIRST","5,30_000_000,SECOND"})
    @DisplayName("enum일 때, 값 반환이 잘 되는지")
    public void enumSourceTest(int matchNum, int money, RankingLotto rankingLotto){
        int matchLottoNum = rankingLotto.getMatchLottoNumber();
        int prizeMoney = rankingLotto.getPrizeMoney();
        assertThat(matchLottoNum).isEqualTo(matchNum);
        assertThat(prizeMoney).isEqualTo(money);
    }
}