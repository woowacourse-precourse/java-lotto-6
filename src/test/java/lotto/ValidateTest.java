package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.model.Lotto;
import lotto.service.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidateTest extends NsTest {
    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
    @DisplayName("당첨 번호가 공백일 경우 예외 처리")
    @Test
    void isWinningNumbersEmptyTest () {
        String input = " ,2,3";
        String [] numbers = input.split(",");
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            for (String num : numbers) {
                Validator.isEmpty(num);
            }
        });
        assertThat(exception.getMessage()).isEqualTo("[ERROR] 숫자를 입력하세요.");
    }

    @DisplayName("당첨 번호에 문자 또는 기호가 입력되었을 경우 예외 처리")
    @Test
    void isWinningNumbersSymbolTest () {
        String input = "ㅏ,2,3";

        String [] numbers = input.split(",");

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            for (String num : numbers) {
                Validator.isNumericInput(num);
            }
        });

        assertThat(exception.getMessage()).isEqualTo("[ERROR] 숫자만 입력하세요.");
    }

    @DisplayName("당첨 번호가 1~45 사이가 아닐 경우 예외 처리")
    @Test
    void isWinningNumbersRangeTest () {
        String input = "1,2,3,47,5,6";
        String [] numbers = input.split(",");

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            for (String num : numbers) {
                Validator.isNumberInRange(num);
            }
        });

        assertThat(exception.getMessage()).isEqualTo("[ERROR] 1에서 45 사이의 숫자만 입력하세요.");
    }

    @DisplayName("당첨 번호가 6개가 아니면 예외 처리")
    @Test
    void isWinningNumbersCount () {
        String input = "1,2,3,4,5";
        String [] numbers = input.split(",");
        List<Integer> winningNumbers = new ArrayList<>();

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            for (String num : numbers) {
                Validator.isEmpty(num);
                Validator.isNumericInput(num);
                Validator.isNumberInRange(num);
                int number = Integer.parseInt(num);
                winningNumbers.add(number);
            }

            new Lotto(winningNumbers);
        });

        assertThat(exception.getMessage()).isEqualTo("[ERROR] 숫자를 6개 입력하세요.");
    }

}
