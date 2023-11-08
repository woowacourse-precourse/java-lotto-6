package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.List;

class LottoTest {

    @Test
    void createLotto() {
        List<Integer> numbers = List.of(1, 3, 7, 18, 9, 33);
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.getNumbers()).isEqualTo(numbers);
    }

    @Test
    void createLottoWithNumbersOutOfRange() {
        List<Integer> numbers = List.of(1, 3, 7, 66, 18, 9);
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1~45 사이의 숫자(정수)만 입력 가능합니다.");
    }

    @Test
    void createLottoWithNotSixNumbers() {
        List<Integer> numbers = List.of(1, 3, 7, 18, 9);
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 6개여야 합니다.");
    }
}