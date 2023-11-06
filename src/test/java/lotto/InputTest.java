package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.assertj.core.api.Assertions;
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
        String console = "8000";
        InputStream inputStream = setConsole(console);
        System.setIn(inputStream);

        // then
        int expect = 8000;
        int actual = Input.getAmount();
        Assertions.assertThat(expect).isEqualTo(actual);
    }

    @Test
    @DisplayName("구입 금액 유효 검사 정상 동작하는지 테스트")
    public void testAmountValid() {
        //given
        String expect = "123";
        InputStream inputStream = setConsole(expect);
        System.setIn(inputStream);

        Assertions.assertThatThrownBy(() -> {
                    Input.getAmount();
                })
                .isInstanceOf(IllegalArgumentException.class);

        //then
    }
}
