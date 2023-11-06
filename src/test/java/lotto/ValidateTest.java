package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class ValidateTest {
    @Test
    void validateBonusNumTest() {
        String input = "1";
        String WinningNum = "1,2,3,4,5,6";
        assertThatThrownBy(() -> {
            Validate.validateBonusNum(input, WinningNum);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[Error]보너스번호는 중복되지않은 숫자 6개입니다.");
    }

}