package lotto;


import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoWinningTest {
    @DisplayName("당첨 순위 별 숫자가 잘 세어지는지 확인한다.")
    @ParameterizedTest
    @MethodSource("provideLottoTickets")
    void testAssignedRanksCount(List<Lotto> tickets, List<Integer> expected) {
        LottoWinning testLottoWinning = new LottoWinning(List.of(5, 10, 15, 20, 25, 30));
        testLottoWinning.setBonusNumber(35);
        Map<LottoRank, Integer> winningCounts= testLottoWinning.assignRanks(tickets);
        assertEquals(expected.get(0), winningCounts.get(LottoRank.FIRST_PLACE));
        assertEquals(expected.get(1), winningCounts.get(LottoRank.SECOND_PLACE));
        assertEquals(expected.get(2), winningCounts.get(LottoRank.THIRD_PLACE));
        assertEquals(expected.get(3), winningCounts.get(LottoRank.FOURTH_PLACE));
        assertEquals(expected.get(4), winningCounts.get(LottoRank.FIFTH_PLACE));
    }

    static Stream<Arguments> provideLottoTickets() {
        List<Lotto> tickets = List.of(
                new Lotto(List.of(5,10,15,42,44,45)),
                new Lotto(List.of(5,10,15,43,44,45)),
                new Lotto(List.of(5,10,15,20,44,45)),
                new Lotto(List.of(5,10,15,20,43,45)),
                new Lotto(List.of(5,10,15,20,42,45)),
                new Lotto(List.of(5,10,15,20,25,40)),
                new Lotto(List.of(5,10,15,20,25,41)),
                new Lotto(List.of(5,10,15,20,25,35)),
                new Lotto(List.of(5,10,15,20,25,30))
        );
        // firstCount = 1; secondCount = 1; thirdCount = 2; fourthCount = 3; fifthCount = 2;
        return Stream.of(
                Arguments.of(tickets, List.of(1,1,2,3,2))
        );
    }

    @DisplayName("로또가 당첨 기준에 따라 올바른 등수에 당첨되는지 확인한다.")
    @ParameterizedTest
    @MethodSource("provideLottoTicket")
    void testAssignedRank(Lotto ticket, LottoRank expected) {
        LottoWinning testLottoWinning = new LottoWinning(List.of(5, 10, 15, 20, 25, 30));
        testLottoWinning.setBonusNumber(35);
        LottoRank actual = testLottoWinning.assignRank(ticket);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> provideLottoTicket() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(5,10,15,43,44,45)), LottoRank.FIFTH_PLACE),
                Arguments.of(new Lotto(List.of(5,10,15,20,44,45)), LottoRank.FOURTH_PLACE),
                Arguments.of(new Lotto(List.of(5,10,15,20,25,40)), LottoRank.THIRD_PLACE),
                Arguments.of(new Lotto(List.of(5,10,15,20,25,35)), LottoRank.SECOND_PLACE),
                Arguments.of(new Lotto(List.of(5,10,15,20,25,30)), LottoRank.FIRST_PLACE)
        );
    }

    @DisplayName("잘못된 로또 당첨 기준에 대해 예외 처리한다.")
    @ParameterizedTest
    @MethodSource("provideInvalidLottoWinningParams")
    void checkExceptionOnWrongInput(List<Integer> winningNumbers, Integer bonusNumber) {
        assertThatThrownBy(() -> {
            new LottoWinning(winningNumbers).setBonusNumber(bonusNumber);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }


    static Stream<Arguments> provideInvalidLottoWinningParams() {
        return Stream.of(
                Arguments.of(List.of(1,2,3,4,5,6,7), 7),
                Arguments.of(List.of(1,2,3,4,5,55), 7),
                Arguments.of(List.of(1,2,3,4,5,5), 7),
                Arguments.of(List.of(1,2,3,4,5,6), 55),
                Arguments.of(List.of(1,2,3,4,5,6), 6),
                Arguments.of(List.of(1,2,3,4,5,6,7), 0)
        );
    }

}
