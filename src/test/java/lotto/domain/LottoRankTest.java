package lotto.domain;

import lotto.domain.lotto.enums.LottoRank;
import lotto.domain.result.MatchResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRankTest {
    @Test
    @DisplayName("주어진 MatchResult 를 통해 , LottoRank 를 결정 한다.")
    void DetermineRankByMatchResult() {
        var matchResult = new MatchResult(4, false);
        var lottoRank = LottoRank.determineRankByMatchResult(matchResult);
        Assertions.assertEquals(lottoRank.getClass(), LottoRank.class);
    }

    @Test
    @DisplayName("전부 일치 시 , 1등 ( FIRST ) 이 나온다.")
    void DetermineFirstRankWithAllMatch() {
        var matchResult = new MatchResult(6, false);
        var lottoRank = LottoRank.determineRankByMatchResult(matchResult);
        Assertions.assertEquals(lottoRank, LottoRank.FIRST);
    }

    @Test
    @DisplayName("하나 불일치 , 보너스 번호 일치시 2등 ( SECOND ) 가 나온다.")
    void DetermineSecondRankWithOneMismatchAndBonusMatch() {
        var matchResult = new MatchResult(5, true);
        var lottoRank = LottoRank.determineRankByMatchResult(matchResult);
        Assertions.assertEquals(lottoRank, LottoRank.SECOND);
    }

    @Test
    @DisplayName("하나 불일치 , 보너스 번호 불일치 시 3등 ( THIRD ) 가 나온다.")
    void DetermineThirdRankWithOneMismatchAndBonusMismatch() {
        var matchResult = new MatchResult(5, false);
        var lottoRank = LottoRank.determineRankByMatchResult(matchResult);
        Assertions.assertEquals(lottoRank, LottoRank.THIRD);
    }

    @Test
    @DisplayName("두개 불일치 , 보너스 번호 일치 시 3등 ( THIRD ) 가 나온다.")
    void DetermineThirdRankWithTwoMismatchAndBonusMatch() {
        var matchResult = new MatchResult(5, false);
        var lottoRank = LottoRank.determineRankByMatchResult(matchResult);
        Assertions.assertEquals(lottoRank, LottoRank.THIRD);
    }

    @Test
    @DisplayName("두개 불일치 시 4등 ( FOURTH ) 가 나온다.")
    void DetermineFourthRankWithTwoMismatch() {
        var matchResult = new MatchResult(4, false);
        var lottoRank = LottoRank.determineRankByMatchResult(matchResult);
        Assertions.assertEquals(lottoRank, LottoRank.FOURTH);
    }

    @Test
    @DisplayName("세개 불일치 , 보너스 번호 일치 시 4등 ( FOURTH ) 가 나온다.")
    void DetermineFourthRankWithThreeMismatchAndBonusMatch() {
        var matchResult = new MatchResult(3, true);
        var lottoRank = LottoRank.determineRankByMatchResult(matchResult);
        Assertions.assertEquals(lottoRank, LottoRank.FOURTH);
    }

    @Test
    @DisplayName("세개 불일치 시 5등 ( FIFTH ) 가 나온다.")
    void DetermineFifthRankWithThreeMismatch() {
        var matchResult = new MatchResult(3, false);
        var lottoRank = LottoRank.determineRankByMatchResult(matchResult);
        Assertions.assertEquals(lottoRank, LottoRank.FIFTH);
    }

    @Test
    @DisplayName("네개 불일치 , 보너스 번호 일치 시 5등 ( FIFTH ) 가 나온다.")
    void DetermineFifthRankWithFourMismatchAndBonusMatch() {
        var matchResult = new MatchResult(2, true);
        var lottoRank = LottoRank.determineRankByMatchResult(matchResult);
        Assertions.assertEquals(lottoRank, LottoRank.FIFTH);
    }

    @Test
    @DisplayName("그 이외에는 등수가 없다. ( NONE )")
    void DetermineNoneRankWithOther() {
        var matchResult = new MatchResult(1, false);
        var lottoRank = LottoRank.determineRankByMatchResult(matchResult);
        Assertions.assertEquals(lottoRank, LottoRank.NONE);
    }
}

