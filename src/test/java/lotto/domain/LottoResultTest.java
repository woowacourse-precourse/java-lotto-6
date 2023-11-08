package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    private static final int SUM_OF_SAME_NUM = 3;
    private static final int BONUS_NUM = 43;
    private static final List<Integer> RESULT_NUM_OF_MATCHES = Arrays.asList(1, 1, 0, 0, 1);
    private static final LottoResult[] LOTTO_RESULT_VALUES = LottoResult.values();

    @DisplayName("당첨 번호와 발행한 로또 번호를 비교해 맞은 개수를 return 한다.")
    @Test
    void returnWinningNumberSameAsLottoNumberNum() {
        List<Integer> eachLotto = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> numbers = Arrays.asList(1, 8, 3, 7, 9, 6);

        assertThat(LottoResult.eachCount(eachLotto, numbers)).isEqualTo(SUM_OF_SAME_NUM);
    }

    @DisplayName("당첨 번호와 로또 번호를 비교해 맞은 개수에 대해 enum에 값을 count 한다.")
    @Test
    void resultOfWinningStats() {
        LottoResult.makeMatchCntNull();
        List<List<Integer>> allLotto = new ArrayList<>();
        allLotto.add(Arrays.asList(1,2,3,4,5,6));
        allLotto.add(Arrays.asList(1,3,5,7,9,10));
        allLotto.add(Arrays.asList(2,3,4,5,7,10));

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);

        LottoResult.countResult(allLotto, numbers, BONUS_NUM);
        for (var i=0; i<LOTTO_RESULT_VALUES.length; i++) {
            assertThat(LOTTO_RESULT_VALUES[i].getNumOfMatches()).isEqualTo(RESULT_NUM_OF_MATCHES.get(i));
        }
    }
}
