package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.function.Consumer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserInputTest {
    private final InputStream systemIn = System.in;

    @AfterEach
    void tearDown() {
        System.setIn(systemIn);
        Console.close();
    }

    private void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @Test
    @DisplayName("검증조건이 통과할 때까지 입력을 받습니다.")
    void 검증조건_통과까지_입력() {
        // GIVEN
        Consumer<String> identity = me -> {
        };
        String expectedInput = "1,2,3,4,5,6";
        setInput(expectedInput);
        // WHEN
        String input = UserInput.getValidInput(identity);
        // THEN
        assertEquals(expectedInput, input);
    }
}