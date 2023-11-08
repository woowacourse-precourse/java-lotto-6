package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import lotto.view.UserInput;
import org.junit.jupiter.api.Test;

public class UserInputMoneyTest {

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
}
