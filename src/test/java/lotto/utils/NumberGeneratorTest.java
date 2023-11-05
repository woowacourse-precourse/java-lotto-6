package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberGeneratorTest {

    @DisplayName("범위를 지정하고 랜덤숫자를 생성하면 범위 내의 숫자가 생성된다")
    @Test
    void generateNumber() {
        int startInclusive = 1;
        int endInclusive = 45;

        List<Integer> inRangeNumber = NumberGenerator.createInRangeNumber(startInclusive, endInclusive, 6);

        assertThat(inRangeNumber)
                .allSatisfy(num -> assertThat(num).isBetween(startInclusive, endInclusive));
    }

    @DisplayName("랜덤숫자를 생성하면 중복되지 않은 숫자가 생성된다")
    @Test
    void distinctNumber() {
        int startInclusive = 1;
        int endInclusive = 45;

        int count = 6;
        List<Integer> inRangeNumber = NumberGenerator.createInRangeNumber(startInclusive, endInclusive, count);

        assertThat(count)
                .isEqualTo(inRangeNumber.stream().distinct().count());
    }
}
