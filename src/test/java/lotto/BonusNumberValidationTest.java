package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.util.Validator;
import lotto.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BonusNumberValidationTest extends NsTest {
    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

    @DisplayName("보너스 번호가 공백일 경우 예외 처리")
    @Test
    void isWinningNumbersEmptyTest () {
        String input = " ";
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Validator.isEmpty(input);
        });
        assertThat(exception.getMessage()).isEqualTo("[ERROR] 숫자를 입력하세요.");
    }

    @DisplayName("보너스 번호가 공백일 경우 예외 처리")
    @Test
    void isWinningNumbersEmptyTest () {
        String input = " ";
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Validator.isEmpty(input);
        });
        assertThat(exception.getMessage()).isEqualTo("[ERROR] 숫자를 입력하세요.");
    }


}
