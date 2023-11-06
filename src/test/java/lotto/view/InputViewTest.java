package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {
    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    void notThousandsMoney() {
        System.setIn(createUserInput("500"));
        assertThatThrownBy(() -> inputView.askMoney())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void notIntegerMoney() {
        System.setIn(createUserInput("2천"));
        assertThatThrownBy(() -> inputView.askMoney())
                .isInstanceOf(IllegalArgumentException.class);
    }

    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}