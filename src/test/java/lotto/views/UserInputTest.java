package lotto.views;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserInputTest {
    @AfterEach
    void closeConsole() {
        Console.close();
    }

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @Test
    @DisplayName("올바른 값을 입력할 때까지 로또 구매 금액을 재입력받는다.")
    void readPurchasePrice() {
        // given
        System.setIn(generateUserInput("1500\n-2000\n3000"));

        // when
        Integer result = UserInput.readPurchasePrice();

        // then
        assertThat(result).isEqualTo(3000);
    }
}
