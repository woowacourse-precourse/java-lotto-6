package lotto.domain;

import static lotto.domain.LottoNumbers.setRandomLottoNumbers;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {

    @Test
    void test_6자리_랜덤넘버가_만들어져야한다() {
        //LottoNumbers lottoNumbers = new LottoNumbers();
        List<Integer> result = setRandomLottoNumbers();
        Assertions.assertThat(result.size()).isEqualTo(6);
    }
}