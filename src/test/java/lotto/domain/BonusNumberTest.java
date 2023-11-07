package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import lotto.constants.Messages;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {
    @DisplayName("당첨번호와 보너스번호가 중복일때 예외가 발생한다.")
    @Test
    void createBonusNumberByDuplicatedNumber() {
        Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int number = 1;
        assertThatThrownBy(() -> new BonusNumber(number, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Messages.ERROR_DUPLICATE_BONUS_NUMBER);
    }

    @DisplayName("보너스 번호가 로또 범위 밖 일때 예외가 발생한다.")
    @Test
    void createBonusNumberByNumberOutsideRange() {
        Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int number = 46;
        assertThatThrownBy(() -> new BonusNumber(number, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Messages.ERROR_RANGE_BONUS_NUMBER);
    }

    @DisplayName("보너스번호가 정상적으로 생성된다.")
    @Test
    void shouldCreateBonusNumberSuccessfully() {
        Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int number = 10;
        Assertions.assertDoesNotThrow(() -> new BonusNumber(number, winningNumbers));
    }
}
