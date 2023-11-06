package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputTest {


    public static InputStream setConsole(String readLine) {
        return new ByteArrayInputStream(readLine.getBytes());
    }

    @Test
    @DisplayName("사용자가 구입 금액을 정확하게 입력한다")
    public void rightAmountInput(){
        //given
        String expect = "8000";
        InputStream inputStream = setConsole(expect);
        System.setIn(inputStream);

        // then
        String actual = Input.getAmount();
        Assertions.assertEquals(expect, actual);
    }
}
