package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {

    private RandomNumberGenerator randomNumberGenerator;

    @BeforeEach
    void init() {
        randomNumberGenerator = new RandomNumberGenerator();
    }

    @DisplayName("랜덤 생성된 6개의 번호를 오름차순으로 정렬하여 반환한다.")
    @Test
    void 랜덤_번호_오름차순() {
        assertThatNoException().isThrownBy(() -> randomNumberGenerator.createUniqueRandomNumbers());
    }

}
