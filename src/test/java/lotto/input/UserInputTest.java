package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserInputTest {
    private UserInput userInput;

    @BeforeEach
    void setUp() {
        userInput = new UserInput();
    }

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    void notThousandsMoney() {
        System.setIn(createUserInput("500"));
        assertThatThrownBy(() -> userInput.askMoney())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void notIntegerMoney() {
        System.setIn(createUserInput("2천"));
        assertThatThrownBy(() -> userInput.askMoney())
                .isInstanceOf(IllegalArgumentException.class);
    }

    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}