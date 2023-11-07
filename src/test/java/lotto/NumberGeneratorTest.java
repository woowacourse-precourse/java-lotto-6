package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberGeneratorTest {

    NumberGenerator numberGenerator;
    private static final String ERROR_INPUT = "1000j";

    @BeforeEach
    void setUp() {
        numberGenerator = new NumberGenerator();
    }

    @DisplayName("숫자가 아닌 string이 입력으로 들어오면 숫자 변환 시 에러가 발생한다")
    @Test
    void createNumberByNotNumberString() {
        assertThatThrownBy(() -> numberGenerator.createOne(ERROR_INPUT))
                .isInstanceOf(IllegalArgumentException.class);
    }

}