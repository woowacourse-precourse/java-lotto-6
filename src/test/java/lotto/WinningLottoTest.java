package lotto;


import java.util.List;
import lotto.Model.Bonus;
import lotto.Model.Lotto;
import lotto.Model.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @DisplayName("당첨번호가 숫자와 쉼표로만 구성되어 있는지 테스트")
    @Test
    void validateWinningLotto1() {
        String invalidInput = "1,2,3,4,5, 30";

        Assertions.assertThatThrownBy(() -> new WinningLotto(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자와 쉼표로만 당첨 번호를 입력해 주세요.");
    }

    @DisplayName("당첨번호가 쉼표로 끝나지 않는지 테스트")
    @Test
    void validateWinningLotto2() {
        String invalidInput = "1,2,3,4,5,30,";

        Assertions.assertThatThrownBy(() -> new WinningLotto(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 쉼표로 끝나는 당첨번호는 입력할 수 없습니다.");
    }

    @DisplayName("당첨번호에 보너스 번호가 있으면 예외 테스트")
    @Test
    void compare() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6");

        Assertions.assertThatThrownBy(() -> winningLotto.compare(new Bonus("5")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 당첨 번호에 포함되면 안됩니다.");
    }
}
