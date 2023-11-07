package lotto.domain;

import static lotto.Validator.*;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class NumberGeneratorTest {
    @Test
    void 랜덤숫자6() {
        NumberGenerator generator = new NumberGenerator();
        assertThat(isUniqueNumber(generator.createRandomNumbers())).isTrue();
    }
}