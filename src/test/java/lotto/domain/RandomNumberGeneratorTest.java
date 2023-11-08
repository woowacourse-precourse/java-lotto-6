package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class RandomNumberGeneratorTest {
    @DisplayName("generate는 6개의, 중복되지 않는, 1~45 사이 숫자 리스트를 반환한다.")
    @RepeatedTest(10)
    void check_generate() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        assertThat(numberGenerator.generate())
                .hasSize(6)
                .doesNotHaveDuplicates()
                .allSatisfy(number -> assertThat(number).isBetween(1, 45));
    }
}
