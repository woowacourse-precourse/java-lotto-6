package lotto.utility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RetryLogicTest {
    int count;

    @BeforeEach
    void init() {
        count = 0;
    }

    @DisplayName("재시도 기능이 지정한 5회만큼 정상적으로 작동한다.")
    @Test
    void retryTest() {
        assertThatThrownBy(() -> RetryLogic.retryCount(new Retry() {
            @Override
            public void run() {
                plusCount();
            }
        })).isInstanceOf(IllegalArgumentException.class);
        assertThat(count).isEqualTo(5);
    }

    @DisplayName("재시도 기능이 지정한 5회만큼 정상적으로 작동한다. -람다")
    @Test
    void retryLamdaTest() {
        assertThatThrownBy(() -> RetryLogic.retryCount(() -> plusCount()))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(count).isEqualTo(5);
    }

    private void plusCount() {
        count++;
        throw new IllegalArgumentException("예외 발생!");
    }
}