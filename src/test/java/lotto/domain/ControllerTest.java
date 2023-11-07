package lotto.domain;

import lotto.constants.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ControllerTest {

    @DisplayName("숫자 오름차순 정렬")
    @Test
    void sortNumbers() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(99);
        numbers.add(1);
        numbers.add(13);
        numbers.add(76);
        numbers.add(43);
        numbers.add(4);
        Controller.sortNumbers(numbers);

        Assertions.assertThat(numbers).isEqualTo(List.of(1, 4, 13, 43, 76, 99));
    }

    @DisplayName("당첨번호목록에서 로또번호 일치하는 숫자 세기")
    @Test
    void countMatchingNumberBetween() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Integer lotteryNumber = 4;

        Integer matchingNumber = Controller.countMatchingNumberBetween(winningNumbers, lotteryNumber);
        Assertions.assertThat(matchingNumber).isEqualTo(1);
    }

    @DisplayName("로또 발행 순서대로 당첨 등수 가기입(2,3등 보너스 번호 미반영)")
    @Test
    void fillRanks() {
        List<Rank> ranks = new ArrayList<>();
        List<Integer> matchingCounts = List.of(3, 4, 3, 5, 6, 1);
        Controller.fillRanks(ranks, matchingCounts);

        Assertions.assertThat(ranks).isEqualTo(List.of(
                Rank.FIFTH,
                Rank.FOURTH,
                Rank.FIFTH,
                Rank.THIRD,
                Rank.FIRST,
                Rank.FAIL));
    }

    @DisplayName("보너스 번호 일치 여부 확인")
    @Test
    void bonusNumberFlag() {
        List<Integer> LotteryNumbers = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 3;
        boolean bonusFlag = Controller.bonusNumberFlag(LotteryNumbers, bonusNumber);

        Assertions.assertThat(bonusFlag).isTrue();
    }

    @Test
    void changeRankByBonusNumber() {
        boolean bonusFlag = true;
        List<Rank> ranks = new ArrayList<>();
        ranks.add(Rank.FIFTH);
        ranks.add(Rank.THIRD);
        ranks.add(Rank.FOURTH);
        ranks.add(Rank.FIFTH);
        ranks.add(Rank.FAIL);
        ranks.add(Rank.FAIL);

        int index = 1;

        Controller.changeRankByBonusNumber(ranks, bonusFlag, index);

        Assertions.assertThat(ranks).isEqualTo(List.of(
                Rank.FIFTH, Rank.SECOND, Rank.FOURTH, Rank.FIFTH, Rank.FAIL, Rank.FAIL
        ));
    }
}