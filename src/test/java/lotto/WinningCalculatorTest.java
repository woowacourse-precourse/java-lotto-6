package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinningCalculatorTest {

    @Test
    void normal() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto lotto4 = new Lotto(List.of(1, 2, 3, 4, 5, 45));
        Lotto lotto5 = new Lotto(List.of(1, 2, 3, 4, 44, 45));
        Lotto lotto6 = new Lotto(List.of(1, 2, 3, 43, 44, 45));

        Lottos lottos = new Lottos(List.of(lotto, lotto2, lotto3, lotto4, lotto5, lotto6));

        WinningLottoWithBonus withBonus = new WinningLottoWithBonus(lotto, 7);

        WinningCalculator winningCalculator = new WinningCalculator(lottos, withBonus);

        assertEquals(winningCalculator.calculate().toString(),
                "{THREE=1, FOUR=1, FIVE=1, BONUS=1, SIX=1, NOPE=1}");

    }
}