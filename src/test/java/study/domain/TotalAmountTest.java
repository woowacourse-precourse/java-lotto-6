package study.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import lotto.domain.TotalAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TotalAmountTest {

    @DisplayName("Long.MAX_VALUE 값에서 1L을 더했을때 오버플로우가 발생해 음수값이 되는지 확인해보기")
    @Test
    void overflow() {
        long totalAmount = Stream.of(Long.MAX_VALUE, 1L)
                .mapToLong(value -> value)
                .sum();

        assertThat(totalAmount).isLessThan(0);
    }

    @DisplayName("상금 계산결과가 오버플로우로 음수가 들어왔을때 에러 발생")
    @Test
    void TotalAmount_overflow() {
        assertThatThrownBy(() -> new TotalAmount(Long.MAX_VALUE + 1L)).isInstanceOf(
                IllegalStateException.class);
    }

}
