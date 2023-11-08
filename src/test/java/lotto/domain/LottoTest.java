package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 번호가 정렬이 되는지 확인한다.")
    @Test
    void sortedLottoNumber() {
        List<Integer> numbers = List.of(8, 5, 11, 7, 6, 22);
        List<Integer> answerNumbers = List.of(5, 6, 7, 8, 11, 22);

        Lotto lotto = new Lotto(numbers);

        assertThat(lotto.toString()).isEqualTo(answerNumbers.toString());
    }

}