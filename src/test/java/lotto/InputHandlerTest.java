package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputHandlerTest {

    private final InputHandler inputHandler = new InputHandler();
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("가격 입력이 잘못된 경우")
    void inputTest() {
        String input = "2145g";
        assertThatThrownBy(() -> {
            inputHandler.readCost(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
    
    @Test
    @DisplayName("당첨 숫자 잘못 입력: ")
    void readWinningNumberTest1_1() {
        String input = "";
        assertThatThrownBy(() -> {
            inputHandler.readWinningNumber(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + " 숫자만을 입력해야 합니다.");
    }
    @Test
    @DisplayName("당첨 숫자 잘못 입력: 32,45,12,7,34,ㄷ")
    void readWinningNumberTest1_2() {
        String input = "32,45,12,7,34,ㄷ";
        assertThatThrownBy(() -> {
            inputHandler.readWinningNumber(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + " 숫자만을 입력해야 합니다.");
    }

    @Test
    @DisplayName("당첨 숫자 잘못 입력: 45 보다 큰 숫자를 입력한 경우")
    void readWinningNumberTest2() {
        String input = "12,45,34,11,56,33";
        assertThatThrownBy(() -> {
            inputHandler.readWinningNumber(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + " 1~45 사이의 숫자를 입력해야 합니다.");
    }

    @Test
    @DisplayName("당첨 숫자 잘못 입력: 6 개 이상의 숫자를 입력한 경우")
    void readWinningNumberTest3() {
        String input = "12,45,34,11,33,1,7";
        assertThatThrownBy(() -> {
            inputHandler.readWinningNumber(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + " 6 개의 숫자를 입력해 주세요.");
    }

    @Test
    @DisplayName("당첨 숫자 잘못 입력: 적은 숫자를 입력한 경우")
    void readWinningNumberTest4() {
        String input = "12,45";
        assertThatThrownBy(() -> {
            inputHandler.readWinningNumber(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + " 6 개의 숫자를 입력해 주세요.");
    }

    @Test
    @DisplayName("당첨 숫자 잘못 입력: 중복이 있는 입력")
    void readWinningNumberTest5() {
        String input = "12,45,34,12,33,1";
        assertThatThrownBy(() -> {
            inputHandler.readWinningNumber(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + " 중복된 숫자를 입력하습니다.");
    }

    @Test
    @DisplayName("당첨 숫자 잘못 입력: 중복 1개 있는데 1개 초과 입력한 경우")
    void readWinningNumberTest6() {
        String input = "12,45,34,12,33,1,7";
        assertThatThrownBy(() -> {
            inputHandler.readWinningNumber(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + " 6 개의 숫자를 입력해 주세요.");
    }


    @Test
    @DisplayName("보너스 숫자 잘못 입력: 2 개 이상의 숫자를 입력한 경우")
    void readBonusNumberTest1_1() {
        String input = "12,45";
        List<Integer> input2 = List.of(3, 5, 11, 16, 32, 38);
        assertThatThrownBy(() -> {
            inputHandler.readBonusNumber(input, input2);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + " 하나의 숫자만을 입력해야 합니다.");
    }

    @Test
    @DisplayName("보너스 숫자 잘못 입력: 2 개 이상의 동일한 숫자를 입력한 경우")
    void readBonusNumberTest1_2() {
        String input = "12,12";
        List<Integer> input2 = List.of(3, 5, 11, 16, 32, 38);
        assertThatThrownBy(() -> {
            inputHandler.readBonusNumber(input, input2);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + " 하나의 숫자만을 입력해야 합니다.");
    }

    @Test
    @DisplayName("보너스 숫자 잘못 입력: 중복된 숫자를 입력한 경우")
    void readBonusNumberTest2() {
        String input = "11";
        List<Integer> input2 = List.of(3, 5, 11, 16, 32, 38);
        assertThatThrownBy(() -> {
            inputHandler.readBonusNumber(input, input2);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + " 이미 입력한 당첨 번호와 중복됩니다.");
    }

    @Test
    @DisplayName("보너스 숫자 잘못 입력: 범위 밖의 숫자를 입력한 경우")
    void readBonusNumberTest3() {
        String input = "54";
        List<Integer> input2 = List.of(3, 5, 11, 16, 32, 38);
        assertThatThrownBy(() -> {
            inputHandler.readBonusNumber(input, input2);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + " 1~45 사이의 숫자를해야 합니다.");
    }

    @Test
    @DisplayName("보너스 숫자 잘못 입력: 숫자가 아닌 것을 입력한 경우")
    void readBonusNumberTest4() {
        String input = "ㅎ";
        List<Integer> input2 = List.of(3, 5, 11, 16, 32, 38);
        assertThatThrownBy(() -> {
            inputHandler.readBonusNumber(input, input2);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + " 하나의 숫자만을 입력해야 합니다.");
    }
    
    @Test
    @DisplayName("1000원 단위로 나누어 떨어지지 않는 경우")
    void inputTest2() {
        String input = "12345";
        assertThatThrownBy(() -> {
            inputHandler.readCost(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    @DisplayName("제대로 된 입력값의 경우")
    void inputTest3() {
        String input = "12000";
        assertThat(inputHandler.readCost(input)).isEqualTo(12000);
    }
}
