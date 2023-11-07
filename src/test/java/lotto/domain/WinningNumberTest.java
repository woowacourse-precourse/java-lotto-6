package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {
    @DisplayName("보너스번호와 당첨번호의 중복된 숫자가 있을시 예외가 발생한다.")
    @Test
    void createLottoByBonusUnique() {
        assertThatThrownBy(() -> new WinningNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)),"6"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("보너스번호가 숫자가 아닐경우 예외가 발생한다.")
    @Test
    void createBonusByNumber() {
        assertThatThrownBy(() -> new WinningNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)),"a"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("보너스번호가 숫자가 1 ~ 45 사이가 아닐경우 예외가 발생한다.")
    @Test
    void createBonusByBetweenNumber() {
        assertThatThrownBy(() -> new WinningNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)),"47"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
