package lotto.controller;

import static lotto.controller.DataController.calcGainPercentage;
import static lotto.controller.DataController.calcTotalPrizeAmount;
import static lotto.controller.DataController.convertElementStringToInteger;
import static lotto.controller.DataController.getWinningCountsByRank;
import static lotto.model.Rank.FIFTH;
import static lotto.model.Rank.FIRST;
import static lotto.model.Rank.FOURTH;
import static lotto.model.Rank.SECOND;
import static lotto.model.Rank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.model.Lotto;
import lotto.model.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class DataControllerTest {
    @DisplayName("string을 Integer List로 잘 변환하는지 확인")
    @ParameterizedTest
    @MethodSource("provideStringAndIntegerList")
    void test_convertElementStringToInteger(String input, List<Integer> expect) {
        List<Integer> result = convertElementStringToInteger(input);
        assertThat(result).isEqualTo(expect);
    }

    private static Stream<Arguments> provideStringAndIntegerList() {
        return Stream.of(
                Arguments.of("1,2,3,4,5,6", Arrays.asList(1, 2, 3, 4, 5, 6)),
                Arguments.of("21,45,3,25,31,6", Arrays.asList(21, 45, 3, 25, 31, 6))
        );
    }

    @DisplayName("각 랭크별로 몇장있는지 잘 변환하는지 확인")
    @ParameterizedTest
    @MethodSource({"provideGetWinningCountsByRankNeed_1", "provideGetWinningCountsByRankNeed_2",
            "provideGetWinningCountsByRankNeed_3"})
    void test_getWinningCountsByRank(
            List<Lotto> lottoTickets, Lotto firstPrizeLotto, int bonusNumber, Map<Rank, Long> expect) {
        Map<Rank, Long> result = getWinningCountsByRank(lottoTickets, firstPrizeLotto, bonusNumber);
        assertThat(result).isEqualTo(expect);

    }

    private static Stream<Arguments> provideGetWinningCountsByRankNeed_1() {
        List<Lotto> lottoTickets = new ArrayList<>();
        lottoTickets.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoTickets.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
        lottoTickets.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)));
        int bonusNumber = 7;
        Lotto firstPrizeLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Map<Rank, Long> expect = new HashMap<>();
        expect.put(FIRST, 1L);
        expect.put(SECOND, 1L);
        expect.put(THIRD, 1L);
        expect.put(FOURTH, 0L);
        expect.put(FIFTH, 0L);
        return Stream.of(
                Arguments.of(lottoTickets, firstPrizeLotto, bonusNumber, expect)
        );
    }

    private static Stream<Arguments> provideGetWinningCountsByRankNeed_2() {
        List<Lotto> lottoTickets = new ArrayList<>();
        lottoTickets.add(new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9)));
        lottoTickets.add(new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10)));
        int bonusNumber = 7;
        Lotto firstPrizeLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Map<Rank, Long> expect = new HashMap<>();
        expect.put(FIRST, 0L);
        expect.put(SECOND, 0L);
        expect.put(THIRD, 0L);
        expect.put(FOURTH, 1L);
        expect.put(FIFTH, 1L);
        return Stream.of(
                Arguments.of(lottoTickets, firstPrizeLotto, bonusNumber, expect)
        );
    }

    private static Stream<Arguments> provideGetWinningCountsByRankNeed_3() {
        List<Lotto> lottoTickets = new ArrayList<>();
        lottoTickets.add(new Lotto(Arrays.asList(1, 2, 11, 8, 9, 10)));
        lottoTickets.add(new Lotto(Arrays.asList(1, 12, 11, 8, 9, 10)));
        lottoTickets.add(new Lotto(Arrays.asList(13, 12, 11, 8, 9, 10)));
        int bonusNumber = 7;
        Lotto firstPrizeLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Map<Rank, Long> expect = new HashMap<>();
        expect.put(FIRST, 0L);
        expect.put(SECOND, 0L);
        expect.put(THIRD, 0L);
        expect.put(FOURTH, 0L);
        expect.put(FIFTH, 0L);
        return Stream.of(
                Arguments.of(lottoTickets, firstPrizeLotto, bonusNumber, expect)
        );
    }

    @DisplayName("상금 잘 더하는지 확인")
    @ParameterizedTest
    @MethodSource("provideCalcTotalPrizeAmount")
    void test_calcTotalPrizeAmount(Map<Rank, Long> winningCountByRank, long expect) {
        long result = calcTotalPrizeAmount(winningCountByRank);
        assertThat(result).isEqualTo(expect);
    }

    private static Stream<Arguments> provideCalcTotalPrizeAmount() {
        Map<Rank, Long> winningCountByRank = new HashMap<>();
        winningCountByRank.put(FIRST, 1L);
        winningCountByRank.put(SECOND, 1L);
        winningCountByRank.put(THIRD, 1L);
        winningCountByRank.put(FOURTH, 1L);
        winningCountByRank.put(FIFTH, 1L);
        long expect = FIRST.getPrizeMoney() + SECOND.getPrizeMoney() + THIRD.getPrizeMoney()
                + FOURTH.getPrizeMoney() + FIFTH.getPrizeMoney();
        return Stream.of(
                Arguments.of(winningCountByRank, expect)
        );
    }

    @DisplayName("수익률 잘 계산하는지 확인")
    @Test
    void test_calcGainPercentage() {
        double expect = 3871065.4;
        double result = calcGainPercentage(2012954000, 52000);
        assertThat(result).isEqualTo(expect);

    }
}
