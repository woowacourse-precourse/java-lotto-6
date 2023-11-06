package lotto.domain.util.referee;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.domain.config.ScoreConfig;
import lotto.domain.entity.lotto.Lotto;
import lotto.domain.entity.lotto.WinningLotto;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoRefereeTest {
    private static final List<Integer> WINNING_NUMBERS = Arrays.asList(1, 2, 3, 4, 5, 6);
    private static final Integer BONUS_NUMBER = 7;
    private static final WinningLotto WINNING_LOTTO = new WinningLotto(WINNING_NUMBERS, BONUS_NUMBER);

    @ParameterizedTest
    @CsvSource({
            "1,2,3,4,5,6,FIRST",
            "1,2,3,4,5,7,SECOND",
            "1,2,3,4,5,10,THIRD",
            "1,2,3,4,10,11,FORTH",
            "1,2,3,10,11,12,FIFTH",
            "1,2,9,11,12,13,NOTHING"
    })
    public void determineRank_당첨_등수(int number1, int number2, int number3, int number4, int number5, int number6,
                                    String expectedRank) {
        //given
        List<Integer> lottoNumbers = Arrays.asList(number1, number2, number3, number4, number5, number6);
        Lotto lotto = new Lotto(lottoNumbers);

        //when
        ScoreConfig result = LottoReferee.determineRank(lotto, WINNING_LOTTO);
        //then
        assertThat(result).isEqualTo(ScoreConfig.valueOf(expectedRank));
    }
}