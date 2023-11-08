package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import java.util.List;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {

    private static List<Integer> lottoNum;

    @Test
    void setRandomNumbers() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        lottoNum = lottoNumbers.setRandomNumbers();
        assertThat(lottoNum.size()).isEqualTo(6);
    }

}