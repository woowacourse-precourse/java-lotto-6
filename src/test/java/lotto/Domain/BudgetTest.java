package lotto.Domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BudgetTest {

    @Test
    @DisplayName("금액 객체생성 예외 테스트")
    public void exceptionTest() {
        String[] invalidInputs = {"900","1950", "문자열1", "", null};

        for (String invalidInput : invalidInputs) {
            assertThatThrownBy(() -> new Budget(invalidInput)).isInstanceOf(
                IllegalArgumentException.class);
        }
    }

}
