package lotto.ui;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputTest {

    private Input input;

    @BeforeEach
    public void setUp() {
        input = new Input();
    }

    @Test
    @DisplayName("자연수가 아닌 숫자가 주어질 경우, 예외가 발생한다.")
    public void testInvalidNumberFormat() throws Exception {
        // given
        String invalidInput = "1, 2, 3.3, 4, 5";

        // when
        Method method = Input.class.getDeclaredMethod("parseIntegers", String.class);
        method.setAccessible(true);

        //then
        assertThrows(InvocationTargetException.class, () -> {
            method.invoke(input, invalidInput);
        });
    }
}