package lotto;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import lotto.validate.Validate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ValidateTest {
    private Validate validate;

    @BeforeEach
    public void setUp() {
        validate = new Validate();
    }

    @Test
    public void 정수형_입력_예외() {
        // given
        String input = "1000원";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> validate.validateInteger(input));
    }

    @Test
    public void 양의값_입력_예외() {
        // given
        List<Integer> tests = Arrays.asList(-1, 0, -999);

        // when & then
        for(int test: tests) {
            assertThrows(IllegalArgumentException.class, () -> validate.validatePositiveNumber(test));
        }
    }

    @Test
    public void 나누어_떨어지지_않는_입력값_예외() {
        // given
        int number = 8500;
        int divide = 1000;

        // when & then
        assertThrows(IllegalArgumentException.class, () -> validate.validateDivideNumber(number, divide));
    }

    @Test
    public void List에_중복되는_값_입력_예외() {
        // given
        int number = 5;
        List<Integer> checkDuplicated = Arrays.asList(1, 2, 3, 4, 5, 6);

        // when & then
        assertThrows(IllegalArgumentException.class, () -> validate.validateDuplicatedInList(number, checkDuplicated));
    }

    @Test
    public void List에_중복되는_값이_있을_경우_예외() {
        // given
        List<Integer> checkDuplicated = Arrays.asList(1, 1, 3, 4, 5, 6);

        // when & then
        assertThrows(IllegalArgumentException.class, () -> validate.validateDuplicatedOfList(checkDuplicated));
    }

    @Test
    public void 범위에_맞지_않는_입력_예외() {
        // given
        List<Integer> tests = Arrays.asList(0, 46, 999);
        final int START_RANGE = 1;
        final int END_RANGE = 45;

        // when & then
        for (int test: tests) {
            assertThrows(IllegalArgumentException.class, () -> validate.validateNumberInRange(test, START_RANGE, END_RANGE));
        }
    }
}
