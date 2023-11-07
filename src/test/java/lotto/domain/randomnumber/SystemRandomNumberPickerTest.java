package lotto.domain.randomnumber;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SystemRandomNumberPickerTest {

    @DisplayName("지정된 범위 내에서 중복되지 않는 6개의 숫자를 추출할 수 있다.")
    @Test
    void pickSixUniqueNumbersInRange() {
        // given
        RandomNumberPicker picker = new SystemRandomNumberPicker();
        int startInclusive = 1;
        int endInclusive = 45;

        // when
        List<Integer> numbers = picker.pickSixUniqueNumbersInRange(startInclusive, endInclusive);

        // then
        assertThat(numbers)
                .hasSize(6)
                .doesNotHaveDuplicates()
                .allMatch(number -> number >= startInclusive && number <= endInclusive);
    }

}