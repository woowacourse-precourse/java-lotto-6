package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WiningLottoTest {
    @DisplayName("보너스 입력 값이 1과 45 사이의 숫자가 아닐때 예외가 발생한다.")
    @Test
    void createBonusNumberByOutOfRange() {
        assertThatThrownBy(() -> new WiningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 50))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1과 45 사이의 수를 입력하세요");
    }

    @DisplayName("보너스 값과 당첨 번호 값이 중복될 때 예외가 발생한다.")
    @Test
    void createBonusDuplication() {
        assertThatThrownBy(
                () -> new WiningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호와 보너스 번호는 서로 중복된 숫자가 없어야 합니다.");
    }

    @DisplayName("당첨 숫자들을 전달한다.")
    @Test
    void createPassingWinNumbers() {
        assertThat(new WiningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7).showWinNumber()).isInstanceOf(List.class);
    }
}
