package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    @Test
    @DisplayName("금액 입력 기능 테스트")
    public void requestBudgetTest() {
        String expected = "15000";
        System.setIn(new ByteArrayInputStream(expected.getBytes()));
        String input = InputView.requestBudget();
        Console.close();
        assertEquals(expected,input);
    }
}
