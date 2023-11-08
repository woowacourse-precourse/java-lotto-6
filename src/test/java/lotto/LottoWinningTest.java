package lotto;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoWinningTest {
    @DisplayName("로또가 당첨 기준에 따라 올바른 등수에 당첨되는지 확인한다.")
    @ParameterizedTest
    @MethodSource("provideLottoTickets")
    void testAssignedRank(Lotto ticket, LottoRank expected) {
        LottoWinning testLottoWinning = new LottoWinning(List.of(5, 10, 15, 20, 25, 30));
        testLottoWinning.setBonusNumber(35);
        LottoRank actual = testLottoWinning.assignRank(ticket);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> provideLottoTickets() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(5,10,15,43,44,45)), LottoRank.FIFTH_PLACE),
                Arguments.of(new Lotto(List.of(5,10,15,20,44,45)), LottoRank.FORTH_PLACE),
                Arguments.of(new Lotto(List.of(5,10,15,20,25,40)), LottoRank.THIRD_PLACE),
                Arguments.of(new Lotto(List.of(5,10,15,20,25,35)), LottoRank.SECOND_PLACE),
                Arguments.of(new Lotto(List.of(5,10,15,20,25,30)), LottoRank.FIRST_PLACE)
        );
    }
}
