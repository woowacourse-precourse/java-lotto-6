package lotto;


import java.util.List;
import lotto.Model.Bonus;
import lotto.Model.Lotto;
import lotto.Model.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @DisplayName("당첨번호가 올바르게 생성되는지 테스트")
    @Test
    void createWinningLotto() {
        String invalidInput = "1,2,3,4,5, 30";

        Assertions.assertThatThrownBy(() -> new WinningLotto(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 예시처럼 입력해주세요. 예시) 1,2,3,4,5,6");
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
    void contain() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6");

        Assertions.assertThatThrownBy(() -> winningLotto.contain(new Bonus("5")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 당첨 번호에 포함되면 안됩니다.");
    }
}
