package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultCalculatorTest {
    private LottoResultCalculator lottoResultCalculator;

    @BeforeEach
    void setUp() {
        lottoResultCalculator = new LottoResultCalculator();
    }

    @Test
    @DisplayName("일치하는 번호가 하나도 없을 경우")
    void calculateResultWithNoMatchingNumbers() {
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)),
                new Lotto(Arrays.asList(13, 14, 15, 16, 17, 18))
        );
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(19, 20, 21, 22, 23, 24), 25);

        LottoResult lottoResult = lottoResultCalculator.calculateResult(lottos, winningNumbers);

        assertEquals(3, lottoResult.getCount(Rank.NONE));
        assertEquals(0, lottoResult.getCount(Rank.FIFTH));
        assertEquals(0, lottoResult.getCount(Rank.FOURTH));
        assertEquals(0, lottoResult.getCount(Rank.THIRD));
        assertEquals(0, lottoResult.getCount(Rank.SECOND));
        assertEquals(0, lottoResult.getCount(Rank.FIRST));
    }

    @Test
    @DisplayName("몇 개의 번호가 일치하는 경우")
    void calculateResultWithSomeMatchingNumbers() {
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)),
                new Lotto(Arrays.asList(13, 14, 15, 16, 17, 18)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 25, 30)),
                new Lotto(Arrays.asList(19, 20, 21, 22, 23, 24)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
        );
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 25, 26), 27);

        LottoResult lottoResult = lottoResultCalculator.calculateResult(lottos, winningNumbers);

        assertEquals(4, lottoResult.getCount(Rank.NONE));
        assertEquals(0, lottoResult.getCount(Rank.FIFTH));
        assertEquals(1, lottoResult.getCount(Rank.FOURTH));
        assertEquals(1, lottoResult.getCount(Rank.THIRD));
        assertEquals(0, lottoResult.getCount(Rank.SECOND));
        assertEquals(0, lottoResult.getCount(Rank.FIRST));
    }

    @Test
    @DisplayName("보너스 번호까지 일치하는 경우")
    void calculateResultWithBonusNumber() {
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)),
                new Lotto(Arrays.asList(13, 14, 15, 16, 17, 18)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 25, 26)),
                new Lotto(Arrays.asList(19, 20, 21, 22, 23, 24)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 25))
        );
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 26), 6);

        LottoResult lottoResult = lottoResultCalculator.calculateResult(lottos, winningNumbers);

        assertEquals(4, lottoResult.getCount(Rank.NONE));
        assertEquals(0, lottoResult.getCount(Rank.FIFTH));
        assertEquals(0, lottoResult.getCount(Rank.FOURTH));
        assertEquals(1, lottoResult.getCount(Rank.THIRD));
        assertEquals(1, lottoResult.getCount(Rank.SECOND));
        assertEquals(0, lottoResult.getCount(Rank.FIRST));
    }
}
