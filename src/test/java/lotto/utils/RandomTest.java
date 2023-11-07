package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomTest {
    private final int RANGE_START = 1;
    private final int RANGE_END = 45;
    private final int COUNT = 6;

    @DisplayName("랜덤으로 뽑히는 숫자가 주어진 범위 안인가?")
    @Test
    void random_랜덤숫자_범위() {
        assertThat(Random.generate()).allMatch(i -> i >= RANGE_START && i <= RANGE_END);
    }

    @DisplayName("주어진 수만큼 랜덤으로 숫자가 뽑히는가?")
    @Test
    void random_랜덤숫자_개수() {
        assertThat(Random.generate().size()).isEqualTo(COUNT);
    }
}
