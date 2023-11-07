package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {

    @Test
    @DisplayName("로또 번호와 중복된 숫자가 있으면 예외가 발생한다.")
    void 보너스_번호_중복_테스트() {
        assertThatThrownBy(() -> new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 1~45 범위내의 숫자가 아니면 예외가 발생한다.")
    void 보너스_번호_범위_테스트() {
        assertThatThrownBy(() -> new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
