package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.BitSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.constants.Prize;
import lotto.controller.LottoGameController;
import lotto.util.Parser;
import lotto.validator.impl.BonusNumberValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottosTest {

    @DisplayName("로또 당첨 상태에 따른 순위를 계산한다.")
    @Test
    void matchRankTest() {
        // given
        Lottos lottos = new Lottos(List.of(new Lotto("1,2,3,4,5,6")));

        int[] winningCount = {6, 5, 5, 4, 3, 2, 1};
        boolean[] isBonusNumber = {false, true, false, false, false, false, false};
        Prize[] expected = {Prize.FIRST, Prize.SECOND, Prize.THIRD, Prize.FOURTH, Prize.FIFTH,
            Prize.NONE, Prize.NONE};

        // when
        List<Prize> result = IntStream.of(1, 2, 3, 4, 5, 6, 7)
            .mapToObj(i -> lottos.matchRank(winningCount[i - 1], isBonusNumber[i - 1])).toList();

        // then
        assertThat(result).containsExactly(expected);

    }

    @DisplayName("로또 게임 결과를 생성한다. 5등을 3명으로 설정한다.")
    @Test
    void calculateGameResultTest() {
        // given
        Lottos lottos = new Lottos(
            List.of(
                new Lotto("1,2,3,4,5,6"), // 5등
                new Lotto("1,2,3,4,5,7"), // 5등
                new Lotto("1,2,3,4,8,9"), // 5등
                new Lotto("1,2,3,8,9,10"), // 5등
                new Lotto("1,2,8,9,10,11"), // 당첨 없음
                new Lotto("1,8,9,10,11,12") // 당첨 없음
            )
        );

        List<Integer> winningNumbers = List.of(1, 2, 3, 42, 43, 44);
        BitSet winningNumberBitSet = Parser.parseToBitSet(winningNumbers);

        // when
        lottos.calculateGameResult(winningNumberBitSet,
            new BonusNumber("45", new BonusNumberValidator()));

        // then
        assertThat(lottos.getPrizeCount(Prize.FIFTH)).isEqualTo(4);
    }

    @DisplayName("로또 게임 총 상금을 계산한다. 5등을 3명으로 설정한다.")
    @Test
    void getPrizeMoneyTest() {
        // given
        Lottos lottos = new Lottos(
            List.of(
                new Lotto("1,2,3,4,5,6"), // 5등
                new Lotto("1,2,3,4,5,7"), // 5등
                new Lotto("1,2,3,4,8,9"), // 5등
                new Lotto("1,2,3,8,9,10"), // 5등
                new Lotto("1,2,8,9,10,11"), // 당첨 없음
                new Lotto("1,8,9,10,11,12") // 당첨 없음
            )
        );

        List<Integer> winningNumbers = List.of(1, 2, 3, 42, 43, 44);
        BitSet winningNumberBitSet = Parser.parseToBitSet(winningNumbers);

        // when
        lottos.calculateGameResult(winningNumberBitSet,
            new BonusNumber("45", new BonusNumberValidator()));
        int result = lottos.getPrizeMoney();

        // then
        assertThat(result).isEqualTo(20000);
    }

    @DisplayName("로또 게임 수익률을 계산한다. 5등을 3명으로 설정한다.")
    @Test
    void getProfit() {
        // given
        Lottos lottos = new Lottos(
            List.of(
                new Lotto("1,2,3,4,5,6"), // 5등
                new Lotto("1,2,3,4,5,7"), // 5등
                new Lotto("1,2,3,4,8,9"), // 5등
                new Lotto("1,2,3,8,9,10"), // 5등
                new Lotto("1,2,8,9,10,11"), // 당첨 없음
                new Lotto("1,8,9,10,11,12") // 당첨 없음
            )
        );

        List<Integer> winningNumbers = List.of(1, 2, 3, 42, 43, 44);
        BitSet winningNumberBitSet = Parser.parseToBitSet(winningNumbers);

        // when
        lottos.calculateGameResult(winningNumberBitSet,
            new BonusNumber("45", new BonusNumberValidator()));
        double result = lottos.getProfit(8000);

        // then
        assertThat(result).isEqualTo(250);
    }
}