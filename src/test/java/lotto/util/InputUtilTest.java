package lotto.util;

import static lotto.constant.message.ErrorMessage.BLANK_LINE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputUtilTest {
    private ByteArrayInputStream emptyInput;

    @BeforeEach
    public void setUp() {
        emptyInput = new ByteArrayInputStream("\n".getBytes());
    }

    @DisplayName("입력받은 후 올바른 값인지 판별하는 기능 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"\n", " ", "hi"})
    public void inputUntilValidLine(String input) {
        if (input.isEmpty() || input.trim().isEmpty()) {
            System.setIn(emptyInput);
            try {
                InputUtil.getUserInput();
            } catch (NoSuchElementException e) {
                System.out.println("NoSuchElementException");
                Console.close();
            }
        } else {
            ByteArrayInputStream inputStream = new ByteArrayInputStream((input + "\n").getBytes());
            System.setIn(inputStream);

            String result = InputUtil.getUserInput();
            assertEquals(input, result);
            Console.close();
        }
    }

    @DisplayName("빈 문자열 입력 시 NoSuchElementException 반환 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"\n", " ", " \n"})
    public void validateEmptyLineTest(String input) throws Exception {
        assertThatThrownBy(() ->
                InputUtil.validateEmptyLine(input))
                .isInstanceOf(NoSuchElementException.class)
                .hasMessage(BLANK_LINE);
    }
}