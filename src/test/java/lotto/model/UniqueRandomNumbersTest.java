package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UniqueRandomNumbersTest {
    final UniqueRandomNumbers numbers = new UniqueRandomNumbers();

    @DisplayName("생성된 값이 1~45범위를 벗어나지 않는지 테스트")
    @Test
    void 생성값_범위테스트() {
        assertThat(numbers.getNumbers().stream().allMatch(n -> 1 <= n && n <= 45)).isTrue();
    }
}