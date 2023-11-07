package lotto.unitTest.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoBucket;
import lotto.model.LottoCreator;
import lotto.model.RankingManager;
import lotto.rule.LottoWinningRule;
import lotto.rule.UserRule;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;

class RankingManagerTest {
    private static MockedStatic<LottoCreator> lottoCreator;

    @BeforeAll
    public static void setLottoCreator() {
        lottoCreator = mockStatic(LottoCreator.class);
    }

    @AfterAll
    public static void closeLottoCreator() {
        lottoCreator.close();
    }

    private static RankingManager createLottoRanking(LottoBucket lottoBucket, Lotto winningLotto) {
        return new RankingManager(lottoBucket, winningLotto, 1);
    }

    @Test
    void 당첨된_로또가_없으면_당첨_내역의_당첨_개수_총합은_0이다() {
        Lotto publishedLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        when(LottoCreator.createRandomLotto()).thenReturn(publishedLotto);
        RankingManager rankingManager = createLottoRanking(new LottoBucket(1),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)));

        assertThat(rankingManager.getWinningDetails().values().stream().mapToInt(Integer::intValue).sum())
                .isEqualTo(0);
    }

    @Test
    void 당첨된_로또가_1개면_당첨_개수가_1_증가한다() {
        Lotto publishedLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        when(LottoCreator.createRandomLotto()).thenReturn(publishedLotto);
        RankingManager rankingManager = createLottoRanking(new LottoBucket(1),
                new Lotto(Arrays.asList(2, 3, 4, 5, 6, 12)));

        assertThat(rankingManager.getWinningDetails().values().stream().mapToInt(Integer::intValue).sum())
                .isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "RANK_ONE:1,2,3,4,5,6:7",
            "RANK_TWO:1,2,3,4,5,7:6",
            "RANK_THREE:1,2,3,4,5,7:8",
            "RANK_FOUR:1,2,3,4,7,8:9",
            "RANK_FIVE:1,2,3,7,8,9:10",
    }, delimiter = ':')
    void 당첨된_로또가_있으면_해당_등수의_당첨_개수가_1씩_증가한다(LottoWinningRule rank, String inputWinningNumbers, int bonusNumber) {
        Lotto publishedLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        when(LottoCreator.createRandomLotto()).thenReturn(publishedLotto);
        List<Integer> numbers = Arrays.stream(inputWinningNumbers.split(UserRule.WINING_NUMBERS_SEPARATOR.getValue()))
                .map(Integer::parseInt)
                .toList();
        RankingManager rankingManager = new RankingManager(new LottoBucket(1), new Lotto(numbers), bonusNumber);

        assertThat(rankingManager.getWinningDetails().get(rank)).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "7,8,9,10,11,12:1:0.0",
            "1,2,3,4,5,6:7:200000000.0",
            "1,2,3,4,5,7:6:3000000.0"
    }, delimiter = ':')
    void 당첨로또의_수익률을_계산한다(String inputWinningNumbers, int bonusNumber, String earningsRate) {
        Lotto publishedLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        when(LottoCreator.createRandomLotto()).thenReturn(publishedLotto);
        List<Integer> numbers = Arrays.stream(inputWinningNumbers.split(UserRule.WINING_NUMBERS_SEPARATOR.getValue()))
                .map(Integer::parseInt)
                .toList();
        RankingManager rankingManager = new RankingManager(new LottoBucket(1), new Lotto(numbers), bonusNumber);

        assertThat(rankingManager.calculateEarningsRate()).isEqualTo(earningsRate);
    }
}