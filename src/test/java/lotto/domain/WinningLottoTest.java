package lotto.domain;

import lotto.constant.LottoRanking;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WinningLottoTest {
    private static WinningLotto winningLotto;

    @BeforeAll
    static void setUp() {
        winningLotto = new WinningLotto(Lotto.create("1,2,3,4,5,6"), BonusNumber.create("7"));
    }

    @Test
    void checkLottoRanking_로또_객체를_인수로_받음() {
        Lotto input = Lotto.create("1,2,3,4,5,6");

        assertEquals(LottoRanking.FIRST, winningLotto.checkLottoRanking(input));
    }

    @Test
    void CheckLottoRanking_로또_객체_리스트를_인수로_받음() {
        List<Lotto> input = new ArrayList<>();
        input.add(Lotto.create("1,2,3,4,5,6"));
        input.add(Lotto.create("1,2,3,4,5,7"));
        input.add(Lotto.create("1,2,3,10,11,12"));

        List<LottoRanking> result = winningLotto.checkLottoRanking(input);

        assertEquals(LottoRanking.FIRST, result.get(0));
        assertEquals(LottoRanking.SECOND, result.get(1));
        assertEquals(LottoRanking.FIFTH, result.get(2));
    }

    @Test
    void calculateTotalPrize() {
        List<LottoRanking> input = new ArrayList<>();
        input.add(LottoRanking.THIRD);
        input.add(LottoRanking.FIFTH);

        int result = WinningLotto.calculateTotalPrize(input);

        assertEquals(1505000, result);
    }
}