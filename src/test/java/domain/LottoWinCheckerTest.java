package domain;

import lotto.Lotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoWinCheckerTest {

    List<Integer> winningNumbers;
    List<Lotto> lottos;
    LottoWinChecker lottoWinChecker;

    @BeforeEach
    void setUp() {
        winningNumbers = List.of(1, 2, 3, 4, 5, 6, 7);

        List<Integer> firstPrizeNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> secondPrizeNumbers = List.of(1, 2, 3, 4, 5, 7);
        List<Integer> thirdPrizeNumbers = List.of(1, 2, 3, 4, 5, 8);
        List<Integer> fourthPrizeNumbers = List.of(1, 2, 3, 4, 8, 9);
        List<Integer> fifthPrizeNumbers = List.of(1, 2, 3, 8, 9, 10);
        List<Integer> noPrizeNumbers = List.of(8, 9, 10, 11, 12, 13);

        lottos = List.of(
                new Lotto(firstPrizeNumbers),
                new Lotto(secondPrizeNumbers),
                new Lotto(thirdPrizeNumbers),
                new Lotto(fourthPrizeNumbers),
                new Lotto(fifthPrizeNumbers),
                new Lotto(noPrizeNumbers)
        );
    }

    @Test
    void getCorrectNumbersCountTest() {
        List<Integer> actual = new ArrayList<>();
        for (int i = 0; i < lottos.size(); i++) {
            Lotto lotto = lottos.get(i);
            lottoWinChecker = new LottoWinChecker(lotto, winningNumbers);
            actual.add(lottoWinChecker.getCorrectNumbersCount());
        }

        List<Integer> expected = List.of(6, 5, 5, 4, 3, 0);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void bonusCheckerTest() {
        List<Boolean> actual = new ArrayList<>();
        for (int i = 0; i < lottos.size(); i++) {
            Lotto lotto = lottos.get(i);
            lottoWinChecker = new LottoWinChecker(lotto, winningNumbers);
            actual.add(lottoWinChecker.correctBonus);
        }

        List<Boolean> expected = List.of(false, true, false, false, false, false);

        Assertions.assertEquals(expected, actual);
    }
}