package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankingTest {

    @DisplayName("랭킹이 3등인지 확인한다.")
    @Test
    void isThirdRank() {
        Assertions.assertTrue(Ranking.THIRD.isThirdRank(5));
        Assertions.assertAll(
                () -> Assertions.assertTrue(Ranking.THIRD.isThirdRank(5)),
                () -> Assertions.assertFalse(Ranking.THIRD.isThirdRank(4))
        );
    }
}
