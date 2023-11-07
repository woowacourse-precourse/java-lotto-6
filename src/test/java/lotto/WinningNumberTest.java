package lotto;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumberTest {

    @DisplayName("당첨 번호 입력값에 숫자와 쉼표 이외의 문자가 왔는지 확인")
    @Test
    void checkDelimiter() {
        Application application = new Application();
        String input = "1,2,3,4.5";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> application.checkDelimiter(input))
                .withMessage("입력 값은 숫자와 쉼표만 올 수 있습니다.");
    }
}
