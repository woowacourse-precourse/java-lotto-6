package lotto.controller;

import lotto.controller.result.Rank;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.controller.result.winningController.checkIfSecondOrThird;
import static lotto.controller.result.winningController.findRank;


public class winningControllerTest {

    @DisplayName("로또 등수 찾기")
    @Test
    void findRankTest() {
        Lotto lotto1 = new Lotto(List.of(1,2,3,4,5,6));
        BonusNumber bonus1 = new BonusNumber(1);
        int resultCount1 = 6;

        Lotto lotto2 = new Lotto(List.of(1,2,3,4,5,6));
        BonusNumber bonus2 = new BonusNumber(1);
        int resultCount2 = 5;

        Lotto lotto3 = new Lotto(List.of(1,2,3,4,5,6));
        BonusNumber bonus3 = new BonusNumber(7);
        int resultCount3 = 5;

        Lotto lotto4 = new Lotto(List.of(1,2,3,4,5,6));
        BonusNumber bonus4 = new BonusNumber(1);
        int resultCount4 = 4;

        Lotto lotto5 = new Lotto(List.of(1,2,3,4,5,6));
        BonusNumber bonus5 = new BonusNumber(1);
        int resultCount5 = 3;

        Assertions.assertThat(findRank(resultCount1, lotto1, bonus1)).isEqualTo(Rank.FIRST);
        Assertions.assertThat(findRank(resultCount2, lotto2, bonus2)).isEqualTo(Rank.SECOND);
        Assertions.assertThat(findRank(resultCount3, lotto3, bonus3)).isEqualTo(Rank.THIRD);
        Assertions.assertThat(findRank(resultCount4, lotto4, bonus4)).isEqualTo(Rank.FOURTH);
        Assertions.assertThat(findRank(resultCount5, lotto5, bonus5)).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("이등하고 삼등 찾기")
    @Test
    void checkIfSecondOrThirdTest() {
        Lotto lotto1 = new Lotto(List.of(1,2,3,4,5,6));
        int bonus1 = 1;

        Lotto lotto2 = new Lotto(List.of(1,2,3,4,5,6));
        int bonus2 = 7;

        Assertions.assertThat(checkIfSecondOrThird(lotto1, bonus1)).isEqualTo(Rank.SECOND);
        Assertions.assertThat(checkIfSecondOrThird(lotto2, bonus2)).isEqualTo(Rank.THIRD);

    }
}
