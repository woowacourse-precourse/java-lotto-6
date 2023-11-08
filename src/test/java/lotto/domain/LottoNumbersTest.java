package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LottoNumbersTest {
    private static List<Integer> lottoNumbersList;

    @Test
    void 로또_난수_생성(){
        LottoNumbers lottoNumbers = new LottoNumbers();
        lottoNumbersList = lottoNumbers.setRandomNumbers();

        assertThat(lottoNumbersList.size()).isEqualTo(6);
    }
}
