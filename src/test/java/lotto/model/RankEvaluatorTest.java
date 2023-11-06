package lotto.model;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import lotto.controller.handler.BonusNumberHandler;
import lotto.controller.handler.WinningNumberHandler;
import lotto.utils.WinningRank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RankEvaluatorTest {

    private RankEvaluator rankEvaluator;

    @BeforeEach
    void setUp() {
        String inputWinningNumbers = "1,3,10,29,18,6";
        WinningNumberHandler winningNumberHandler = new WinningNumberHandler(inputWinningNumbers);
        winningNumberHandler.handle();
        Map<Integer, Integer> sequencedNumbers = winningNumberHandler.getHandledResult();

        BonusNumberHandler bonusNumberHandler = new BonusNumberHandler("4");
        bonusNumberHandler.handle();
        int bonusNumber = bonusNumberHandler.getHandledResult();
        WinningNumbers winningNumbers = new WinningNumbers(sequencedNumbers, bonusNumber);

        rankEvaluator = new RankEvaluator(winningNumbers);
    }

    @Test
    void testGetRankOutOfRank() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 9, 41, 5, 17);
        Iterator<Integer> lottoIterator = lottoNumbers.iterator();
        WinningRank rank = rankEvaluator.getRank(lottoIterator);
        Assertions.assertThat(rank).isEqualTo(WinningRank.OUT_OF_RANK);

        lottoNumbers = Arrays.asList(1, 2, 10, 3, 6, 18);
        lottoIterator = lottoNumbers.iterator();
        rank = rankEvaluator.getRank(lottoIterator);
        Assertions.assertThat(rank).isNotEqualTo(WinningRank.OUT_OF_RANK);
    }

    @Test
    void testGetRankFifth() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 40, 50, 60);
        Iterator<Integer> lottoIterator = lottoNumbers.iterator();
        WinningRank rank = rankEvaluator.getRank(lottoIterator);
        Assertions.assertThat(rank).isEqualTo(WinningRank.FIFTH);
    }

    @Test
    void testGetRankFourth() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 50, 60);
        Iterator<Integer> lottoIterator = lottoNumbers.iterator();
        WinningRank rank = rankEvaluator.getRank(lottoIterator);
        Assertions.assertThat(rank).isEqualTo(WinningRank.FOURTH);
    }

    @Test
    void testGetRankThird() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 50, 4);
        Iterator<Integer> lottoIterator = lottoNumbers.iterator();
        WinningRank rank = rankEvaluator.getRank(lottoIterator);
        Assertions.assertThat(rank).isEqualTo(WinningRank.THIRD);
    }

    @Test
    void testGetRankSecond() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 4);
        Iterator<Integer> lottoIterator = lottoNumbers.iterator();
        WinningRank rank = rankEvaluator.getRank(lottoIterator);
        Assertions.assertThat(rank).isEqualTo(WinningRank.SECOND);
    }

    @Test
    void testGetRankFirst() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Iterator<Integer> lottoIterator = lottoNumbers.iterator();
        WinningRank rank = rankEvaluator.getRank(lottoIterator);
        Assertions.assertThat(rank).isEqualTo(WinningRank.FIRST);
    }
}