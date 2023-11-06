package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomLottoGeneratorTest {
    @DisplayName("generateLotto가 예외를 반환하지 않는다.")
    @Test
    void generateLottoDoesNotThrow() {
        assertDoesNotThrow(RandomLottoGenerator::generateLotto);
    }
}
