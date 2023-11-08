package lotto;

import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
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
        assertThat(expect).isEqualTo(actual);
    }

    @Test
    @DisplayName("구입 금액 유효 검사 정상 동작하는지 테스트")
    public void testAmountValid() {
        //given
        String expect = "123";
        InputStream inputStream = setConsole(expect);
        System.setIn(inputStream);

        // then
        assertThatThrownBy(() -> {
                    Input.getAmount();
                })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호 입력 테스트")
    public void inputLottoNumberRight(){
        //given
        String input = "1,2,3,4,5,6";
        InputStream inputStream = setConsole(input);
        System.setIn(inputStream);

        //when
        List<Integer> expect = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> actual = Input.getLottoNumbers();

        //then
        assertThat(expect).isEqualTo(actual);
    }

    @Test
    @DisplayName("당첨 번호 입력 형식 유효 테스트")
    public void testValidLottoFormat() {
        //given
        String expect = "123456";
        InputStream inputStream = setConsole(expect);
        System.setIn(inputStream);

        // then
        assertThatThrownBy(() -> {
            Input.getLottoNumbers();
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호 입력 범위 유효 테스트")
    public void testLottoRangeValid() {
        //given
        String expect = "0,2,3,4,5,46";
        InputStream inputStream = setConsole(expect);
        System.setIn(inputStream);

        // then
        assertThatThrownBy(() -> {
            Input.getLottoNumbers();
        })
                .isInstanceOf(IllegalArgumentException.class);
    }
}
