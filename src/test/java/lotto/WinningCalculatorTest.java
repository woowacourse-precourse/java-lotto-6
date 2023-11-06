package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.WinningCalculator;
import lotto.model.WinningLottoWithBonus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WinningCalculatorTest {

    private Lotto lotto;
    private Lotto lotto2;
    private Lotto lotto3;
    private Lotto lotto4;
    private Lotto lotto5;
    private Lotto lotto6;
    private Lottos lottos;

    @BeforeEach
    void before() {
        lotto = new Lotto(List.of(3, 4, 5, 6, 1, 2));
        lotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        lotto4 = new Lotto(List.of(1, 2, 3, 4, 5, 45));
        lotto5 = new Lotto(List.of(1, 2, 3, 4, 44, 45));
        lotto6 = new Lotto(List.of(1, 2, 3, 43, 44, 45));

        lottos = new Lottos(List.of(lotto, lotto2, lotto3, lotto4, lotto5, lotto6));
    }

    @Test
    void normal() {

        WinningLottoWithBonus withBonus = new WinningLottoWithBonus(lotto, 7);

        WinningCalculator winningCalculator = new WinningCalculator(lottos, withBonus);

        assertEquals(winningCalculator.getResult().toString(),
                "{THREE=1, FOUR=1, FIVE=1, BONUS=1, SIX=1, NOPE=1}");

        System.out.println(winningCalculator.getProfitRate());

    }

    @Test
    void profitRate() {
        WinningLottoWithBonus withBonus = new WinningLottoWithBonus(lotto, 7);

        WinningCalculator winningCalculator = new WinningCalculator(lottos, withBonus);

        winningCalculator.getResult();

        assertEquals(winningCalculator.getProfitRate(), (double) 33859250.0);
    }
}