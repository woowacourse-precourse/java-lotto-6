package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    static final int LOTTO_NUMBER_SIZE = 6;
    static final int LOTTO_NUMBER_MIN = 1;
    static final int LOTTO_NUMBER_MAX = 45;

    @Test
    @DisplayName("로또 번호 생성 테스트")
    void createLottoNumber() {
        LottoNumber lottoNumber = new LottoNumber();
        List<Integer> numbers = lottoNumber.getNumbers();

        assertThat(numbers).hasSize(LOTTO_NUMBER_SIZE);
        for (Integer number : numbers) {
            assertThat(number).isBetween(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX);
        }
        assertThat(new HashSet<>(numbers).size()).isEqualTo(LOTTO_NUMBER_SIZE);
    }
}