package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import lotto.dto.InputBonus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningBonusNumberTest {
    @Test
    @DisplayName("입력받은 보너스 번호가 정수가 아닌 경우 예외가 발생한다.")
    public void 보너스_번호_정수_아님() throws Exception {
        assertThatThrownBy(() -> new InputBonus("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력받은 보너스 번호의 범위가 1 ~ 45가 아니면 예외가 발생한다.")
    public void 보너스_번호_범위() throws Exception {
        //given
        String winningBonusNumberZero = "0";
        String winningBonusNumberOver = "46";

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            new InputBonus(winningBonusNumberZero);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new InputBonus(winningBonusNumberOver);
        });

    }

    @Test
    @DisplayName("입력받은 보너스 번호가 이미 당첨 번호에 있는 경우 예외가 발생한다.")
    public void 보너스_번호_중복() throws Exception {
        //given
        int winningBonusNumberDuplicate = 1;
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            new WinningBonusNumber(winningBonusNumberDuplicate, winningNumbers);
        });
    }
}
