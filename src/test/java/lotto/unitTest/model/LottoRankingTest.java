package lotto.unitTest.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.common.config.LottoWinningRule;
import lotto.common.config.UserRule;
import lotto.model.Lotto;
import lotto.model.LottoBucket;
import lotto.model.LottoCreator;
import lotto.model.LottoRanking;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;

class LottoRankingTest {
    private static MockedStatic<LottoCreator> lottoCreator;

    @BeforeAll
    public static void setLottoCreator() {
        lottoCreator = mockStatic(LottoCreator.class);
    }

    @AfterAll
    public static void closeLottoCreator() {
        lottoCreator.close();
    }

    private static LottoRanking createLottoRanking(LottoBucket lottoBucket, Lotto winningLotto) {
        return new LottoRanking(lottoBucket, winningLotto, 1);
    }

    @Test
    void 당첨된_로또가_없으면_당첨_내역의_당첨_개수_총합은_0이다() {
        //given
        Lotto publishedLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        when(LottoCreator.createRandomLotto()).thenReturn(publishedLotto);
        LottoRanking lottoRanking = createLottoRanking(new LottoBucket(1),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)));

        //when
        Map<LottoWinningRule, Integer> winningDetails = lottoRanking.getWinningDetails();

        //then
        assertThat(winningDetails.values().stream().mapToInt(Integer::intValue).sum()).isEqualTo(0);
    }

    @Test
    void 당첨된_로또가_1개면_당첨_개수가_1_증가한다() {
        //given
        Lotto publishedLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        when(LottoCreator.createRandomLotto()).thenReturn(publishedLotto);
        LottoRanking lottoRanking = createLottoRanking(new LottoBucket(1),
                new Lotto(Arrays.asList(2, 3, 4, 5, 6, 12)));

        //when
        Map<LottoWinningRule, Integer> winningDetails = lottoRanking.getWinningDetails();

        //then
        assertThat(winningDetails.values().stream().mapToInt(Integer::intValue).sum()).isEqualTo(1);
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
        //given
        Lotto publishedLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        when(LottoCreator.createRandomLotto()).thenReturn(publishedLotto);
        List<Integer> numbers = Arrays.stream(inputWinningNumbers.split(UserRule.WINING_NUMBERS_SEPARATOR.getValue()))
                .map(Integer::parseInt)
                .toList();
        LottoRanking lottoRanking = new LottoRanking(new LottoBucket(1), new Lotto(numbers), bonusNumber);

        //when
        Map<LottoWinningRule, Integer> winningDetails = lottoRanking.getWinningDetails();

        //then
        assertThat(winningDetails.get(rank)).isEqualTo(1);
    }
}