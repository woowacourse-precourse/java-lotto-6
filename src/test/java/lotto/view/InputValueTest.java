package lotto.view;

import lotto.exception.ErrorCode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValueTest {

    @BeforeAll
    static void beforeAll() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @Test
    void 빈값_입력시_예외발생() {

        String input = " ";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> InputValue.getPurchasePrice())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.EMPTY_VALUE.getMessage());
    }

    @Test
    void 숫자가_아닌값_입력시_예외발생() {

        String input = "숫자";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> InputValue.getPurchasePrice())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.NOT_NUMBER.getMessage());
    }

    @Test
    void 입력값_단위가_1000원_단위가_아니면_예외발생() {

        String input = "2100";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> InputValue.getPurchasePrice())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INCORRECT_UNIT.getMessage());
    }

}
