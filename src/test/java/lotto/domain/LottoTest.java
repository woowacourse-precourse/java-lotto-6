package lotto.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    void validateLottoSizeTest() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);
        Assertions.assertThatThrownBy(() -> {
                    new Lotto(numbers);
                })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateDistinctNumbersTest() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 6, 6);
        Assertions.assertThatThrownBy(() -> {
                    new Lotto(numbers);
                })
                .isInstanceOf(IllegalArgumentException.class);
    }
}
