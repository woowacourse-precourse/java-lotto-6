package lotto;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputTest {

    public static InputStream setConsole(String readLine) {
        return new ByteArrayInputStream(readLine.getBytes());
    }

    @Test
    @DisplayName("사용자가 구입 금액을 정확하게 입력한다")
    @ParameterizedTest
    @ValueSource(strings = {"8000"})
    public void rightAmountInput(String amount){
        //given
        InputStream inputStream = setConsole(amount);
        System.setIn(inputStream);

        String input = Input.getAmount();
        Assertions.assertEquals(input, amount);
    }
}
