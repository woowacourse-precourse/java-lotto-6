package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {
    @BeforeEach
    void createWinningNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        WinningNumbers.createForTesting(numbers);
    }

    @DisplayName("보너스 번호가 당첨 번호에 포함되어 있는 숫자이면 예외가 발생한다.")
    @Test
    void testBonusNumberInWinningNumbers() {
        assertThatThrownBy(() -> BonusNumber.validate(6)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호의 범위가 1-45를 벗어나면 예외가 발생한다.")
    @Test
    void testBonusNumberInvalidRange() {
        assertThatThrownBy(() -> BonusNumber.validate(46)).isInstanceOf(IllegalArgumentException.class);
    }
}