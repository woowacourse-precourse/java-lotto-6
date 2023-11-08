package lotto.model.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RankTableTest {

    @Test
    void filterBonusNumber() {
        List<Integer> matchCount = List.of(0, 1, 2, 3, 4, 5, 5, 6);
        Lotto lotto0 = new Lotto(List.of(1, 2, 3, 4, 5, 6)); // 0
        Lotto lotto1 = new Lotto(List.of(2, 3, 4, 5, 6, 7)); // 1
        Lotto lotto2 = new Lotto(List.of(3, 4, 5, 6, 7, 8)); // 2
        Lotto lotto3 = new Lotto(List.of(4, 5, 6, 7, 8, 9)); // 3
        Lotto lotto4 = new Lotto(List.of(5, 6, 7, 8, 9, 10)); // 4
        Lotto lotto5 = new Lotto(List.of(6, 7, 8, 9, 10, 11)); // 5
        Lotto lottoBonus = new Lotto(List.of(7, 8, 9, 10, 11, 45)); // 6
        Lotto lotto6 = new Lotto(List.of(8, 9, 10, 11, 12, 13)); // 7
        List<Lotto> lottos = List.of(lotto0, lotto1, lotto2, lotto3, lotto4, lotto5, lottoBonus, lotto6);

        List<RankTable> rankTables = RankTable.filterBonusNumber(lottos, 45, matchCount);
        Assertions.assertThat(rankTables).contains(
                RankTable.THREE,
                RankTable.FOUR,
                RankTable.FIVE,
                RankTable.BONUS,
                RankTable.SIX);
    }
}