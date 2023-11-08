package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    private final Lotto drawNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));

    @DisplayName("보너스 번호가 중복되었으면 예외가 발생한다.")
    @Test
    void validateBonusBallByDuplicateNumber() {
        assertThatThrownBy(() -> new WinningLotto(drawNumbers, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호의 크기가 상한을 벗어나면 예외가 발생한다.")
    @Test
    void validateBonusBallByOverMaxNumber() {
        assertThatThrownBy(() -> new WinningLotto(drawNumbers, 46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호의 크기가 하한을 벗어나면 예외가 발생한다.")
    @Test
    void validateBonusBallByUnderMinNumber() {
        assertThatThrownBy(() -> new WinningLotto(drawNumbers, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
