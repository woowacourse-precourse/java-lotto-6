package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StatusTest {
    @DisplayName("각 결과값 true false 기대값 확인")
    @Test
    void statusReturnCheck() {
        assertThat(Status.GOT_MESSAGE.getStatus()).isFalse();
        assertThat(Status.GOT_ERROR.getStatus()).isTrue();
        assertThat(Status.GOT_NOTHING.getStatus()).isTrue();
    }
}
