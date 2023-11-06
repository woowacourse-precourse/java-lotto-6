package lotto.model;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
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
        String inputWinningNumbers = "1,2,3,4,5,6";
        WinningNumberHandler winningNumberHandler = new WinningNumberHandler(inputWinningNumbers);
        winningNumberHandler.handle();

        BonusNumberHandler bonusNumberHandler = new BonusNumberHandler("7");
        bonusNumberHandler.handle();
        int bonusNumber = bonusNumberHandler.getHandledResult();
        PrizeNumbers prizeNumbers = new PrizeNumbers(winningNumberHandler.getHandledResult(), bonusNumber);

        rankEvaluator = new RankEvaluator(prizeNumbers);
    }

    @Test
    void testGetRankOutOfRank() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 10, 11, 12, 13);
        Iterator<Integer> lottoIterator = lottoNumbers.iterator();
        WinningRank rank = rankEvaluator.getRank(lottoIterator);
        Assertions.assertThat(rank).isEqualTo(WinningRank.OUT_OF_RANK);
    }

    @Test
    void testGetRankFifth() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 11, 12, 13);
        Iterator<Integer> lottoIterator = lottoNumbers.iterator();
        WinningRank rank = rankEvaluator.getRank(lottoIterator);
        Assertions.assertThat(rank).isEqualTo(WinningRank.FIFTH);
    }

    @Test
    void testGetRankFourth() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 12, 13);
        Iterator<Integer> lottoIterator = lottoNumbers.iterator();
        WinningRank rank = rankEvaluator.getRank(lottoIterator);
        Assertions.assertThat(rank).isEqualTo(WinningRank.FOURTH);
    }

    @Test
    void testGetRankThird() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 13);
        Iterator<Integer> lottoIterator = lottoNumbers.iterator();
        WinningRank rank = rankEvaluator.getRank(lottoIterator);
        Assertions.assertThat(rank).isEqualTo(WinningRank.THIRD);
    }

    @Test
    void testGetRankSecond() {
        // 4 is the bonus number
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 7);
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