package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoStatisticsTest {
    private Lottos lottos;

    @BeforeEach
    public void setUp() {
        List<Lotto> lottoRepository = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12))
        );

        lottos = new Lottos(lottoRepository);
    }

    @DisplayName("로또 6개 맞췄는지 테스트")
    @Test
    void testSixNumbersMatch() {
        List<Integer> winningNumbersRepository = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningNumbers winningNumbersObj = new WinningNumbers(winningNumbersRepository, bonusNumber);

        LottoStatistics lottoStatistics = new LottoStatistics(lottos, winningNumbersObj);

        lottoStatistics.compareLottosWithWinningNumbers();

        assertEquals(1, lottoStatistics.getSixNumbersMatch());
        assertEquals(0, lottoStatistics.getFiveNumbersAndBonusNumberMatch());
        assertEquals(0, lottoStatistics.getFiveNumbersMatch());
        assertEquals(0, lottoStatistics.getFourNumbersMatch());
        assertEquals(0, lottoStatistics.getThreeNumbersMatch());
    }

    @DisplayName("로또 5개 + 보너스숫자 맞췄는지 테스트")
    @Test
    void testFiveNumbersAndBonusNumberMatch() {
        List<Integer> winningNumbersRepository = List.of(1, 2, 3, 4, 5, 7);
        int bonusNumber = 6;
        WinningNumbers winningNumbersObj = new WinningNumbers(winningNumbersRepository, bonusNumber);

        LottoStatistics lottoStatistics = new LottoStatistics(lottos, winningNumbersObj);

        lottoStatistics.compareLottosWithWinningNumbers();

        assertEquals(0, lottoStatistics.getSixNumbersMatch());
        assertEquals(1, lottoStatistics.getFiveNumbersAndBonusNumberMatch());
        assertEquals(0, lottoStatistics.getFiveNumbersMatch());
        assertEquals(0, lottoStatistics.getFourNumbersMatch());
        assertEquals(0, lottoStatistics.getThreeNumbersMatch());
    }

    @DisplayName("로또 5개 맞췄는지 테스트")
    @Test
    void testFiveNumbersMatch() {

        List<Integer> winningNumbersRepository = List.of(1, 2, 3, 4, 5, 8);
        int bonusNumber = 9;
        WinningNumbers winningNumbersObj = new WinningNumbers(winningNumbersRepository, bonusNumber);

        LottoStatistics lottoStatistics = new LottoStatistics(lottos, winningNumbersObj);

        lottoStatistics.compareLottosWithWinningNumbers();

        assertEquals(0, lottoStatistics.getSixNumbersMatch());
        assertEquals(0, lottoStatistics.getFiveNumbersAndBonusNumberMatch());
        assertEquals(1, lottoStatistics.getFiveNumbersMatch());
        assertEquals(0, lottoStatistics.getFourNumbersMatch());
        assertEquals(0, lottoStatistics.getThreeNumbersMatch());
    }

    @DisplayName("로또 4개 맞췄는지 테스트")
    @Test
    void testFourNumbersMatch() {

        List<Integer> winningNumbersRepository = List.of(1, 2, 3, 4, 7, 8);
        int bonusNumber = 9;
        WinningNumbers winningNumbersObj = new WinningNumbers(winningNumbersRepository, bonusNumber);

        LottoStatistics lottoStatistics = new LottoStatistics(lottos, winningNumbersObj);

        lottoStatistics.compareLottosWithWinningNumbers();

        assertEquals(0, lottoStatistics.getSixNumbersMatch());
        assertEquals(0, lottoStatistics.getFiveNumbersAndBonusNumberMatch());
        assertEquals(0, lottoStatistics.getFiveNumbersMatch());
        assertEquals(1, lottoStatistics.getFourNumbersMatch());
        assertEquals(0, lottoStatistics.getThreeNumbersMatch());
    }

    @DisplayName("로또 3개 맞췄는지 테스트")
    @Test
    void testThreeNumbersMatch() {

        List<Integer> winningNumbersRepository = List.of(1, 2, 3, 20, 21, 22);
        int bonusNumber = 10;
        WinningNumbers winningNumbersObj = new WinningNumbers(winningNumbersRepository, bonusNumber);

        LottoStatistics lottoStatistics = new LottoStatistics(lottos, winningNumbersObj);

        lottoStatistics.compareLottosWithWinningNumbers();

        assertEquals(0, lottoStatistics.getSixNumbersMatch());
        assertEquals(0, lottoStatistics.getFiveNumbersAndBonusNumberMatch());
        assertEquals(0, lottoStatistics.getFiveNumbersMatch());
        assertEquals(0, lottoStatistics.getFourNumbersMatch());
        assertEquals(1, lottoStatistics.getThreeNumbersMatch());
    }

    @DisplayName("로또 3개 2번 맞췄는지 테스트")
    @Test
    void testThreeNumbersMatchTwo() {

        List<Integer> winningNumbersRepository = List.of(1, 2, 3, 7, 8, 9);
        int bonusNumber = 10;
        WinningNumbers winningNumbersObj = new WinningNumbers(winningNumbersRepository, bonusNumber);

        LottoStatistics lottoStatistics = new LottoStatistics(lottos, winningNumbersObj);

        lottoStatistics.compareLottosWithWinningNumbers();

        assertEquals(0, lottoStatistics.getSixNumbersMatch());
        assertEquals(0, lottoStatistics.getFiveNumbersAndBonusNumberMatch());
        assertEquals(0, lottoStatistics.getFiveNumbersMatch());
        assertEquals(0, lottoStatistics.getFourNumbersMatch());
        assertEquals(2, lottoStatistics.getThreeNumbersMatch());
    }
}