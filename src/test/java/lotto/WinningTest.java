package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningTest {
    @Test
    @DisplayName("Winning 생성")
    public void createWinning() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Winning winning = new Winning(numbers, bonusNumber);

        assertThat(winning.getNumbers()).isEqualTo(numbers);
        assertThat(winning.getBonusNumber()).isEqualTo(bonusNumber);
    }

    @Test
    @DisplayName("보너스 번호가 로또 번호에 포함되어 있을 수 없다.")
    public void validateBonusNumberIncludedInNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;

        assertThatThrownBy(() -> new Winning(numbers, bonusNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("보너스 번호가 1부터 45의 범위를 벗어날 수 없다.")
    public void validateBonusNumberOutOfRange() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 50;

        assertThatThrownBy(() -> new Winning(numbers, bonusNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 보너스 번호는 1부터 45의 숫자입니다.");
    }
}
