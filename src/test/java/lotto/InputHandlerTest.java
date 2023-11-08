package lotto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class InputHandlerTest{

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }
    
    @AfterEach
    public void done() {
        System.setOut(standardOut);
    }

    @Test
    @DisplayName("가격 입력이 잘못된 경우")
    void inputTest() {
        String input = "2145g";
        InputHandler.readCost(input);
        assertThat(outputStream.toString()).contains(Constants.ERROR_MESSAGE + " 숫자만을 입력해야 합니다.");
    }
    
    @Test
    @DisplayName("당첨 숫자 잘못 입력: ")
    void readWinningNumberTest1_1() {
        String input = "";
        InputHandler.readCost(input);
        assertThat(outputStream.toString()).contains(Constants.ERROR_MESSAGE + " 숫자만을 입력해야 합니다.");
    }
    @Test
    @DisplayName("당첨 숫자 잘못 입력: 32,45,12,7,34,ㄷ")
    void readWinningNumberTest1_2() {
        String input = "32,45,12,7,34,ㄷ";
        InputHandler.readWinningNumber(input);
        assertThat(outputStream.toString()).contains(Constants.ERROR_MESSAGE+" 숫자만을 입력해야 합니다.");
    }

    @Test
    @DisplayName("당첨 숫자 잘못 입력: 45 보다 큰 숫자를 입력한 경우")
    void readWinningNumberTest2() {
        String input = "12,45,34,11,56,33";
        InputHandler.readWinningNumber(input);
        assertThat(outputStream.toString())
                .contains(Constants.MESSAGE_INSTRUCTION);
    }

    @Test
    @DisplayName("당첨 숫자 잘못 입력: 6 개 이상의 숫자를 입력한 경우")
    void readWinningNumberTest3() {
        String input = "12,45,34,11,33,1,7";
        InputHandler.readWinningNumber(input);
        assertThat(outputStream.toString()).contains(Constants.MESSAGE_INSTRUCTION);
    }

    @Test
    @DisplayName("당첨 숫자 잘못 입력: 적은 숫자를 입력한 경우")
    void readWinningNumberTest4() {
        String input = "12,45";
        InputHandler.readWinningNumber(input);
        assertThat(outputStream.toString()).contains(Constants.MESSAGE_INSTRUCTION);
    }

    @Test
    @DisplayName("당첨 숫자 잘못 입력: 중복이 있는 입력")
    void readWinningNumberTest5() {
        String input = "12,45,34,12,33,1";
        InputHandler.readWinningNumber(input);
        assertThat(outputStream.toString()).contains(Constants.MESSAGE_INSTRUCTION);
    }

    @Test
    @DisplayName("당첨 숫자 잘못 입력: 중복 1개 있는데 1개 초과 입력한 경우")
    void readWinningNumberTest6() {
        String input = "12,45,34,12,33,1,7";
        InputHandler.readWinningNumber(input);
        assertThat(outputStream.toString()).contains(Constants.MESSAGE_INSTRUCTION);
    }


    @Test
    @DisplayName("보너스 숫자 잘못 입력: 2 개 이상의 숫자를 입력한 경우")
    void readBonusNumberTest1_1() {
        String input = "12,45";
        List<Integer> input2 = List.of(3, 5, 11, 16, 32, 38);
        InputHandler.readBonusNumber(input, input2);
        assertThat(outputStream.toString()).contains(Constants.MESSAGE_INSTRUCTION_BONUS);
    }

    @Test
    @DisplayName("보너스 숫자 잘못 입력: 2 개 이상의 동일한 숫자를 입력한 경우")
    void readBonusNumberTest1_2() {
        String input = "12,12";
        List<Integer> input2 = List.of(3, 5, 11, 16, 32, 38);
        InputHandler.readBonusNumber(input, input2);
        assertThat(outputStream.toString()).contains(Constants.MESSAGE_INSTRUCTION_BONUS);
    }

    @Test
    @DisplayName("보너스 숫자 잘못 입력: 중복된 숫자를 입력한 경우")
    void readBonusNumberTest2() {
        String input = "11";
        List<Integer> input2 = List.of(3, 5, 11, 16, 32, 38);
        InputHandler.readBonusNumber(input, input2);
        assertThat(outputStream.toString()).contains(Constants.MESSAGE_INSTRUCTION_BONUS);
    }

    @Test
    @DisplayName("보너스 숫자 잘못 입력: 범위 밖의 숫자를 입력한 경우")
    void readBonusNumberTest3() {
        String input = "54";
        List<Integer> input2 = List.of(3, 5, 11, 16, 32, 38);
        InputHandler.readBonusNumber(input, input2);
        assertThat(outputStream.toString()).contains(Constants.MESSAGE_INSTRUCTION_BONUS);
    }

    @Test
    @DisplayName("보너스 숫자 잘못 입력: 숫자가 아닌 것을 입력한 경우")
    void readBonusNumberTest4() {
        String input = "ㅎ";
        List<Integer> input2 = List.of(3, 5, 11, 16, 32, 38);
        InputHandler.readBonusNumber(input, input2);
        assertThat(outputStream.toString()).contains(Constants.MESSAGE_INSTRUCTION_BONUS);
    }
    
    @Test
    @DisplayName("1000원 단위로 나누어 떨어지지 않는 경우")
    void inputTest2() {
        String input = "12345";
        InputHandler.readCost(input);
        assertThat(outputStream.toString()).contains(Constants.ERROR_MESSAGE + " 1000 단위의 자연수를 입력해야 합니다.");
    }

    @Test
    @DisplayName("제대로 된 입력값의 경우")
    void inputTest3() {
        String input = "12000";
        assertThat(InputHandler.readCost(input)).isEqualTo(12000);
    }
}
