package lotto.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.Console;

public class InputViewTest {
    InputView inputView = new InputView();

    @AfterEach
    void tearDown() {
        Console.close();
    }

    @Test
    void 로또_구입_금액_입력_테스트() {
        // given
        String userInput = "14000";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        // when
        InputInfo info = inputView.inputPurchaseAmount();
        // then
        assertEquals(true, info.isValidate());
        assertEquals(14000, Integer.parseInt(info.getUserInput()));
    }
}
