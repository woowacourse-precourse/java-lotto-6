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

    @DisplayName("당첨 카운트를 조절한다.")
    @Test
    void increaseCount() {
        Ranking.THIRD.increaseCount();
        Assertions.assertEquals(1, Ranking.THIRD.getCount());

        Ranking.THIRD.decreaseCount();
        Assertions.assertEquals(0, Ranking.THIRD.getCount());
    }
}
