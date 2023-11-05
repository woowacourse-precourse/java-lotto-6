package study.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

public class TotalAmountTest {

    @Test
    void overflow() {
        long totalAmount = Stream.of(Long.MAX_VALUE, 1L)
                .mapToLong(value -> value)
                .sum();

        assertThat(totalAmount).isLessThan(0);
    }
}
