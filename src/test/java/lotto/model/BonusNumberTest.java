package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.*;

public class BonusNumberTest {
    WinningNumbers winningNumbers;

    @BeforeEach
    void preset() {
        winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("객체 생성 성공")
    @Test
    void createBonusNumberComplete() {
        Integer bonusNumber = 7;
        BonusNumber normalBonusNumber = new BonusNumber(winningNumbers, bonusNumber);
        assertTrue(normalBonusNumber.equals(bonusNumber));
    }

    @DisplayName("보너스 번호가 당첨 번호들과 중복되면 예외가 발생한다.")
    @Test
    void createBonusNumberDuplication() {
        assertThatThrownBy(() -> new BonusNumber(winningNumbers, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 최소 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createBonusNumberByOutOfMinRange() {
        assertThatThrownBy(() -> new BonusNumber(winningNumbers, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 최대 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createBonusNumberByOutOfMaxRange() {
        assertThatThrownBy(() -> new BonusNumber(winningNumbers, 46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
