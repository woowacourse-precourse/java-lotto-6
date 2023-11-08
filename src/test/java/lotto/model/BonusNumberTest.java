package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {

    @DisplayName("보너스 번호가 숫자가 아니면 예외가 발생한다.")
    @Test
    void createBonusByNotNumber() {
        assertThatThrownBy(() -> new BonusNumber("abc", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1에서 45 사이 숫자가 아니면 예외가 발생한다.")
    @Test
    void createBonusByOutOfRange() {
        assertThatThrownBy(() -> new BonusNumber("0", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 같으면 예외가 발생한다.")
    @Test
    void createBonusByDuplicatedNumber() {
        assertThatThrownBy(() -> new BonusNumber("6", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
