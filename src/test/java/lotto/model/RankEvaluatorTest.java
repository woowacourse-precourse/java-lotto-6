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
        List<Integer> lottoNumbers = Arrays.asList(1, 3, 29, 41, 5, 17);
        Iterator<Integer> lottoIterator = lottoNumbers.iterator();
        WinningRank rank = rankEvaluator.getRank(lottoIterator);
        Assertions.assertThat(rank).isEqualTo(WinningRank.OUT_OF_RANK);

        lottoNumbers = Arrays.asList(1, 3, 10, 5, 6, 18);
        lottoIterator = lottoNumbers.iterator();
        rank = rankEvaluator.getRank(lottoIterator);
        Assertions.assertThat(rank).isNotEqualTo(WinningRank.OUT_OF_RANK);
    }

    @Test
    void testGetRankFifth() {
        List<Integer> lottoNumbers = Arrays.asList(1, 3, 10, 31, 29, 44);
        Iterator<Integer> lottoIterator = lottoNumbers.iterator();
        WinningRank rank = rankEvaluator.getRank(lottoIterator);
        Assertions.assertThat(rank).isEqualTo(WinningRank.FIFTH);
    }

    @Test
    void testGetRankFourth() {
        List<Integer> lottoNumbers = Arrays.asList(1, 3, 10, 29, 31, 44);
        Iterator<Integer> lottoIterator = lottoNumbers.iterator();
        WinningRank rank = rankEvaluator.getRank(lottoIterator);
        Assertions.assertThat(rank).isEqualTo(WinningRank.FOURTH);
    }

    @Test
    void testGetRankThird() {
        List<Integer> lottoNumbers = Arrays.asList(1, 3, 10, 29, 31, 6);
        Iterator<Integer> lottoIterator = lottoNumbers.iterator();
        WinningRank rank = rankEvaluator.getRank(lottoIterator);
        Assertions.assertThat(rank).isEqualTo(WinningRank.THIRD);
    }

    @Test
    void testGetRankSecond() {
        // 4 is the bonus number
        List<Integer> lottoNumbers = Arrays.asList(1, 3, 10, 29, 4, 6);
        Iterator<Integer> lottoIterator = lottoNumbers.iterator();
        WinningRank rank = rankEvaluator.getRank(lottoIterator);
        Assertions.assertThat(rank).isEqualTo(WinningRank.SECOND);

        lottoNumbers = Arrays.asList(1, 3, 10, 29, 7, 6);
        lottoIterator = lottoNumbers.iterator();
        rank = rankEvaluator.getRank(lottoIterator);
        Assertions.assertThat(rank).isNotEqualTo(WinningRank.SECOND);
    }

    @Test
    void testGetRankFirst() {
        List<Integer> lottoNumbers = Arrays.asList(1, 3, 10, 29, 18, 6);
        Iterator<Integer> lottoIterator = lottoNumbers.iterator();
        WinningRank rank = rankEvaluator.getRank(lottoIterator);
        Assertions.assertThat(rank).isEqualTo(WinningRank.FIRST);
    }
}