package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @Test
    @DisplayName("generate 메서드가 리턴한 리스트의 사이즈는 6이다.")
    void generate_Method_Return_Six_Size() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        assertEquals(numberGenerator.generate().size(), 6);
    }
}
