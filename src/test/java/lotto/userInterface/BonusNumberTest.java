package lotto.userInterface;

import lotto.input.BonusNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;

public class BonusNumberTest extends BonusNumber {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("2개 이상의 숫자가 입력되면 예외가 발생한다.")
    @Test
    void testValidateInputLength() {
        String input = "1, 2, 3";
        assertThatThrownBy(() -> BonusNumber.validateInputLength(input, ERROR_MESSAGE))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 중 보너스 번호와 중복되는 번호가 있으면 예외가 발생한다.")
    @Test
    void testValidateDuplicate() {
        int bonusNum = 1;
        Set<Integer> winningNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> BonusNumber.validateDuplicate(bonusNum, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
