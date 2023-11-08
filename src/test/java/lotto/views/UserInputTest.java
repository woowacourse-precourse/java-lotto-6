package lotto.views;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
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

    @Test
    @DisplayName("올바른 값을 입력할 때까지 로또 당첨 번호를 재입력받는다.")
    void readWinningNumber() {
        // given
        System.setIn(generateUserInput("1,2,3,4,5,5\n1,2,3\n1,2,3,4,5,50\n1,2,3,4,5,6"));

        // when
        List<Integer> winningNumbers = UserInput.readWinningNumber();

        // then
        System.out.println("winningNumbers = " + winningNumbers.size());
        assertThat(winningNumbers).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("올바른 값을 입력할 때까지 보너스 번호를 재입력받는다.")
    void readBonusNumber() {
        // given
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.setIn(generateUserInput("1\n50\n10"));

        // when
        Integer bonusNumber = UserInput.readBonusNumber(winningNumbers);

        // then
        assertThat(bonusNumber).isEqualTo(10);
    }
}
