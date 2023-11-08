package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    private static final int SUM_OF_SAME_NUM = 3;

    @DisplayName("당첨 번호와 발행한 로또 번호를 비교해 맞은 개수를 return 한다.")
    @Test
    void returnWinningNumberSameAsLottoNumberNum() {
        List<Integer> eachLotto = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> numbers = Arrays.asList(1, 8, 3, 7, 9, 6);

        assertThat(LottoResult.eachCount(eachLotto, numbers)).isEqualTo(SUM_OF_SAME_NUM);
    }
}
