package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CommonFunctionTest {
    @DisplayName("번호들 중 1~45의 범위를 벗어난 수가 있으면 예외가 발생한다.")
    @Test
    void 리스트의_번호들_범위_확인() {
        // given
        List<Integer> input_numbers1 = List.of(0,2,3,4,5,6);
        List<Integer> input_numbers2 = List.of(1,2,3,4,5,46);

        // then
        assertThrows(IllegalArgumentException.class, () -> {
            CommonFunction.checkNumbersIn1to45(input_numbers1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            CommonFunction.checkNumbersIn1to45(input_numbers2);
        });
    }

    @DisplayName("하나의 수가 1~45의 범위를 벗어나면 예외가 발생한다.")
    @Test
    void 하나의_번호_범위_확인() {
        // given
        int input_number1 = -1;
        int input_number2 = 100;

        // then
        assertThrows(IllegalArgumentException.class, () -> {
            CommonFunction.checkNumberIn1to45(input_number1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            CommonFunction.checkNumberIn1to45(input_number2);
        });
    }

    @DisplayName("입력된 문자열이 정수가 아니면 예외가 발생한다.")
    @Test
    void 문자열이_정수인지_확인() {
        // given
        String input_number1 = "1.1";
        String input_number2 = "abc";
        String input_number3 = "";
        String input_number4 = " ";
        String input_number5 = null;

        // then
        assertThrows(IllegalArgumentException.class, () -> {
            CommonFunction.convertToInt(input_number1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            CommonFunction.convertToInt(input_number2);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            CommonFunction.convertToInt(input_number3);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            CommonFunction.convertToInt(input_number4);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            CommonFunction.convertToInt(input_number5);
        });
    }
}