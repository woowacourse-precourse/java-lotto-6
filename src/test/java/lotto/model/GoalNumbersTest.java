package lotto.model;

import static lotto.exception.ExceptionMessage.GOAL_NUMBER_SIZE_EXCEPTION;
import static lotto.exception.ExceptionMessage.NUMBER_DUPLICATE_EXCEPTION;
import static lotto.exception.ExceptionMessage.NUMBER_FORMAT_EXCEPTION;
import static lotto.exception.ExceptionMessage.UNVALID_GOAL_NUMBER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class GoalNumbersTest {

    @Test
    @DisplayName("정상적인 경우 로또 정답 번호들이 생성되어야 한다.")
    void validGoalNumbersInputTest() {
        // given
        String goalNumbersInput = "1,2,3,4,5,6";

        // when & then
        assertDoesNotThrow(() -> GoalNumbers.from(goalNumbersInput));
    }

    @Nested
    @DisplayName("정답 번호 예외 테스트")
    class GoalNumbersExceptionTest {

        @Test
        @DisplayName("일반 문자가 포함되었을 때 예외가 발생한다.")
        void notNumberValueExceptionTest() {
            // given
            String goalNumbersInput = "10,20,30,abc,40,50";

            // when & then
            assertThatThrownBy(() -> GoalNumbers.from(goalNumbersInput)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(NUMBER_FORMAT_EXCEPTION.getMessage());
        }

        @Test
        @DisplayName("로또 정답 갯수만큼만 있어야 한다.")
        void overNumbersSizeExceptionTest() {
            // given
            String goalNumbersInput = "1,2,3,4,5,6,7";

            // when & then
            assertThatThrownBy(() -> GoalNumbers.from(goalNumbersInput)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(GOAL_NUMBER_SIZE_EXCEPTION.getMessage());
        }

        @Test
        @DisplayName("중복된 수가 있으면 안 된다.")
        void duplicateNumbersExceptionTest() {
            // given
            String goalNumbersInput = "1,1,2,3,4,5";

            // when & then
            assertThatThrownBy(() -> GoalNumbers.from(goalNumbersInput)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(NUMBER_DUPLICATE_EXCEPTION.getMessage());
        }

        @Test
        @DisplayName("로또 숫자에서 생성될 수 없는 수가 있으면 안 된다.")
        void unvalidNumberValueExceptionTest() {
            // given
            String goalNumbersInput = "1,2,900,-20,5,10";

            // when & then
            assertThatThrownBy(() -> GoalNumbers.from(goalNumbersInput)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(UNVALID_GOAL_NUMBER.getMessage());
        }
    }
}
