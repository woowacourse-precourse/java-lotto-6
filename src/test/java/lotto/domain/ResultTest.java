package lotto.domain;

import lotto.enumeration.WinningType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {
    @DisplayName("입력받은 WinningType에 해당하는 value의 값에 1을 더한다.")
    @Test
    void update() {
        Result result = new Result();
        result.update(WinningType.SECOND);
        assertThat(result.getResult().get(WinningType.SECOND))
                .isEqualTo(1);
    }
}
