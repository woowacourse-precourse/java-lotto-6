package lotto.domain;

import lotto.domain.number.NumberUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberGeneratorTest {

    @DisplayName("FakeNumberGenenrator가 잘 작동하는지 확인")
    @Test
    void generateNumber() {
        NumberUtil fakeNumberGenerator = new FakeNumberGenerator();
        List<Integer> result = fakeNumberGenerator.generateNumbers();

        assertThat(result)
                .containsExactly(1,2,3,4,5,6);
    }
}
