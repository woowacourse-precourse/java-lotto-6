package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import lotto.io.InputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @AfterEach
    void after() {
        Console.close();
    }

    public void setUpInputStream(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }

    @Test
    void inputViewTest() {
        // given
        String input = "150000";
        setUpInputStream(input);

        // when
        String userInput = InputView.userInput();

        // then
        Assertions.assertEquals("150000", userInput);
    }
}
