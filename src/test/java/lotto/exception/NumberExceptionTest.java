package lotto.exception;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import static lotto.exception.NumberException.*;

public class NumberExceptionTest {

    @DisplayName("입력한 숫자가 범위를 벗어나면 예외 처리")
    @Test
    void checkNumberExceptionTest() {
        int num1 = 0;
        int num2 = 46;
        Assertions.assertThatThrownBy(() -> numberRangeException(num1))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> numberRangeException(num2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 숫자가 범위 내에 있는 경우")
    @Test
    void checkRightNumberExceptionTest() {
        int num1 = 1;
        int num2 = 45;
        numberRangeException(num1);
        numberRangeException(num2);
    }

    @DisplayName("입력한 당첨 숫자가 중복되면 예외 처리")
    @Test
    void checkDuplicateExceptionTest() {
        Assertions.assertThatThrownBy(() -> duplicateException(List.of(1,1,2,3,4,5))).
                isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 당첨 숫자")
    @Test
    void checkRightDuplicateExceptionTest() {
        duplicateException(List.of(1,9,2,3,4,5));
    }

    @DisplayName("입력한 보너스 숫자가 당첨 숫자와 중복되면 예외 처리")
    @Test
    void checkDuplicateExceptionTestBonus() {
        Assertions.assertThatThrownBy(() -> duplicateException(List.of(1,6,2,3,4,5), 1)).
                isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 보너스 숫자가 당첨 숫자와 중복되면 예외 처리")
    @Test
    void checkRightDuplicateExceptionTestBonus() {
        duplicateException(List.of(1,9,2,3,4,5), 10);
    }


}
