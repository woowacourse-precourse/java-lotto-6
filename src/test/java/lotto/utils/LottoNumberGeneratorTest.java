package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberGeneratorTest {

    @DisplayName("랜덤숫자를 생성하면 로또 숫자 범위 내의 숫자 리스트가 생성된다")
    @Test
    void generateNumber() {
        int startInclusive = 1;
        int endInclusive = 45;

        List<Integer> inRangeNumber = LottoNumberGenerator.createInRangeNumber();

        assertThat(inRangeNumber)
                .allSatisfy(num -> assertThat(num).isBetween(startInclusive, endInclusive));
    }

    @DisplayName("랜덤숫자를 생성하면 중복되지 않은 숫자가 생성된다")
    @Test
    void distinctNumber() {
        List<Integer> inRangeNumber = LottoNumberGenerator.createInRangeNumber();

        assertThat(6)
                .isEqualTo(inRangeNumber.stream().distinct().count());
    }
}
