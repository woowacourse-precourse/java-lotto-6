package lotto;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


import lotto.validation.WinningNumberValidator;
import org.junit.jupiter.api.Test;

public class WinningNumberValidatorTest {

    @Test
    void 입력값에_중복된_숫자가_있을_경우_중복된_숫자_예외를_던진다() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                WinningNumberValidator.validateWinningNumbers("1,2,2,3,4,5")
        );
        assertTrue(exception.getMessage().contains("중복된 숫자가 있습니다."));
    }

    // 실패테스트.
    @Test
    void 입력값에_숫자가_6개가_아닐_경우_6개의_숫자_예외를_던진다() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                WinningNumberValidator.validateWinningNumbers("1,2,3,4,5")
        );
        assertTrue(exception.getMessage().contains("정확히 6개의 숫자를 입력해야 합니다."));
    }

    @Test
    void 입력값에_범위를_벗어난_숫자가_있을_경우_범위_예외를_던진다() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                WinningNumberValidator.validateWinningNumbers("1,2,3,4,5,46")
        );
        assertTrue(exception.getMessage().contains("숫자는 1에서 45 사이어야 합니다"));
    }

    @Test
    void 입력값이_숫자가_아닐_경우_숫자_예외를_던진다() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                WinningNumberValidator.validateWinningNumbers("1,2,3,4,오,6")
        );
        assertTrue(exception.getMessage().contains("숫자만 입력할 수 있습니다."));
    }

    @Test
    void 모든_입력값이_올바를_경우_예외를_던지지_않는다() {
        WinningNumberValidator.validateWinningNumbers("1,2,3,4,5,6");
    }


}
