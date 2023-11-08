package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Validate;
import org.junit.jupiter.api.Test;

class ValidateTest {
    @Test
    void validateBonusNumTest() {
        int input = 1;
        List<Integer> WinningNum = Arrays.asList(1,2,3,4,5,6);
        assertThatThrownBy(() -> {
            Validate.validateBonusNum(input, WinningNum);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}