package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberGeneratorTest {

    @DisplayName("로또 번호는 6자리이고, 1~45 사이의 숫자이다.")
    @Test
    void getLottoNumber() {
        List<Integer> lottoNumbers = NumberGenerator.getLottoNumber();
        assertEquals(6, lottoNumbers.size());
        for (Integer lottoNumber : lottoNumbers) {
            assertThat(lottoNumber).isBetween(1, 45);
        }
    }
}