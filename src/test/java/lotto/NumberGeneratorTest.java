package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberGeneratorTest {
    @DisplayName("주어진 범위 내의 랜덤한 번호 6개를 포함하는 리스트를 생성한다.")
    @Test
    void generate() {
        List<Integer> result = NumberGenerator.generate();

        for (Integer integer : result) {
            assertThat(integer).isBetween(1, 45);
        }
        assertThat(result.size()).isEqualTo(6);
    }
}