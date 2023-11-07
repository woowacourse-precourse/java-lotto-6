package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
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


    @DisplayName("당첨 번호가 6개가 아닐 때 예외 발생")
    @Test
    void validateCount() {
        List<Integer> input = List.of(1, 2, 3, 4, 5);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(input));
    }

    @DisplayName("당첨 번호가 중복될 때 예외 발생")
    @Test
    void validateDuplication() {
        List<Integer> input = List.of(1, 2, 3, 3, 4, 5);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(input))
                .withMessage(ErrorMessage.DUPLICATED_LOTTO);
    }

    @DisplayName("당첨 번호가 주어진 범위에서 벗어날 때 예외 발생")
    @Test
    void validateRange() {
        List<Integer> input = List.of(1, 2, 3, 46, 4, 5);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(input))
                .withMessageContaining("로또 번호의 숫자 범위는");
    }

    @DisplayName("당첨 번호 생성 성공")
    @Test
    void createWinningNumber() {
        Application application = new Application();
        String input = "1,2,3,4,5,6";

        Lotto winningNumber = application.createWinningNumber(input);

        assertThat(winningNumber)
                .usingRecursiveComparison()
                .isEqualTo(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
    }
}
