package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningNumberTest {

    static Stream<Arguments> rankingTestParameters() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), Ranking.FIRST),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)), Ranking.SECOND),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 10)), Ranking.THIRD),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 10, 11)), Ranking.FOURTH),
                Arguments.of(new Lotto(List.of(1, 2, 3, 11, 12, 13)), Ranking.FIFTH),
                Arguments.of(new Lotto(List.of(1, 2, 10, 11, 12, 13)), Ranking.NONE)
        );
    }

    @Test
    void 당첨번호를_입력하기_전에_보너스_번호를_입력하면_오류_발생() {
        //given
        WinningNumber winningNumber = new WinningNumber();
        int bonusNumber = 10;

        //when & then
        assertThrows(IllegalStateException.class, () -> winningNumber.setBonusNumber(bonusNumber));
    }

    @Test
    void 당첨번호와_중복된_보너스_번호일_경우_오류_발생() {
        //given
        WinningNumber winningNumber = new WinningNumber();
        winningNumber.setWinningNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        int bonusNumber = 5;

        //when & then
        assertThrows(IllegalArgumentException.class, () -> winningNumber.setBonusNumber(bonusNumber));
    }

    @ParameterizedTest
    @MethodSource("rankingTestParameters")
    void 당첨번호와_비교해서_랭킹_반환(Lotto lotto, Ranking expected) {
        //given
        WinningNumber winningNumber = new WinningNumber();
        winningNumber.setWinningNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        winningNumber.setBonusNumber(7);

        //when
        Ranking ranking = winningNumber.getRankings(lotto);

        //then
        assertEquals(expected, ranking);
    }
}
