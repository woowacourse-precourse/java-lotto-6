package lotto.domain.number;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        List<Number> numbers = Stream.of(1, 2, 3, 4, 5, 6, 7)
                .map(Number::new)
                .toList();

        assertThatThrownBy(() -> Lotto.of(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        List<Number> numbers = Stream.of(1, 2, 3, 4, 5, 5)
                .map(Number::new)
                .toList();

        assertThatThrownBy(() -> Lotto.of(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}