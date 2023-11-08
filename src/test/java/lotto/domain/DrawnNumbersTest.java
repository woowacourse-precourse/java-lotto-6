package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DrawnNumbersTest {

    @Test
    @DisplayName("같은 값을 가진 래퍼 클래스의 중복을 제거한다.")
    void Number_중복_제거_테스트() {
        // given
        List<Number> numbers = List.of(
                Number.valueOf(1),
                Number.valueOf(2),
                Number.valueOf(2));

        // then
        int count = (int) numbers.stream()
                .distinct()
                .count();

        // then
        assertThat(count).isEqualTo(2);
    }
}
