package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RankingTest {

    @DisplayName("일치 번호 개수, 보너스 번호 일치 여부에 따라 등수가 결정된다.")
    @ParameterizedTest
    @CsvSource({"3,false,FIFTH", "5,true,SECOND", "5,false,THIRD"})
    void creatRanking(int matchNumberCount, boolean hasBonusNumber, Ranking expectedRanking) {
        Ranking actualRanking = Ranking.of(matchNumberCount, hasBonusNumber);

        assertEquals(expectedRanking, actualRanking);
    }
}