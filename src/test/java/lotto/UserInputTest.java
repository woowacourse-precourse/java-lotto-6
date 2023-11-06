package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

public class UserInputTest {

    @Test
    void 금액_입력_테스트() {
        String input = "1000";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        UserInput userInput = new UserInput();
        assertThat(userInput.money()).isEqualTo(1000);
        System.setIn(System.in);
        Console.close();
    }

    @Test
    void 금액이_천보다_작을_때() {
        String input = "999";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        UserInput userInput = new UserInput();
        assertThatThrownBy(userInput::money)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("천보다 큰 금액을 입력해주세요.");
        System.setIn(System.in);
        Console.close();
    }

    @Test
    void 숫자가_아닐_때() {
        String input = "I000";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        UserInput userInput = new UserInput();
        assertThatThrownBy(userInput::money)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력 해주세요.");
        System.setIn(System.in);
        Console.close();
    }

    @Test
    void 천원_단위가_아닐_때() {
        String input = "1001";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        UserInput userInput = new UserInput();
        assertThatThrownBy(userInput::money)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("금액은 천원 단위로 입력 해주세요.");
        System.setIn(System.in);
        Console.close();
    }

    @Test
    void 금액이_너무_클_때() {
        String input = "3000000";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        UserInput userInput = new UserInput();
        assertThatThrownBy(userInput::money)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("100만을 넘는 금액은 입력 할 수 없습니다.");
        System.setIn(System.in);
        Console.close();
    }
}
