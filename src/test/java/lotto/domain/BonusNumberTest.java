package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BonusNumberTest {

    @DisplayName("로또 번호가 정해진 범위를 넘어서면 예외가 발생한다.")
    @Test
    void createLottoByOverRange() {
        assertThatThrownBy(() -> Lotto.of(List.of(1, 2, 3, 4, 46, 5)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Lotto.of(List.of(1, 2, 3, 4, 0, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}