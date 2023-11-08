package lotto.generator;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {
    @DisplayName("주어진 List를 오름차순으로 정렬하는지 확인한다.")
    @Test
    void setGameStatusByEqual() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        List<Integer> sampleNumbers1 = randomNumberGenerator.ascendOrder(List.of(2, 5, 7, 1, 8, 4));
        List<Integer> sampleNumbers2 = randomNumberGenerator.ascendOrder(List.of(45, 41, 42, 44, 43, 40));

        assertSoftly(softAssertions -> {
            softAssertions.assertThat(sampleNumbers1).isEqualTo(List.of(1, 2, 4, 5, 7, 8));
            softAssertions.assertThat(sampleNumbers2).isEqualTo(List.of(40, 41, 42, 43, 44, 45));
        });
    }
}
