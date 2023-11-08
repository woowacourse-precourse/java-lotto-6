package lotto.domain;

import static lotto.domain.Rank.returnRank;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.Lotto;
import org.junit.jupiter.api.Test;

class RankTest {

  @Test
  void returnRankTest() {
    List<Integer> winNum = List.of(1, 2, 3, 4, 5, 6);
    Lotto oneCombination = new Lotto(List.of(3, 4, 5, 6, 7, 8));
    int bonusNum = 10;

    int expectedRank = 4;

    int actualRank = returnRank(winNum, oneCombination, bonusNum);

    assertEquals(expectedRank, actualRank);
  }
}