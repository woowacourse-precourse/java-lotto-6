package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoWinningBonusNumberTest {
    @Test
    @DisplayName("입력받은 보너스 번호의 범위가 1 ~ 45가 아니면 예외가 발생한다.")
    public void 보너스_번호_범위() throws Exception {
        //given
        String winningBonusNumberZeroString = "0";
        String winningBonusNumberOverString = "46";
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            new LottoWinningBonusNumber(winningBonusNumberZeroString, winningNumbers);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new LottoWinningBonusNumber(winningBonusNumberOverString, winningNumbers);
        });

    }

    @Test
    @DisplayName("입력받은 보너스 번호가 이미 당첨 번호에 있는 경우 예외가 발생한다.")
    public void 보너스_번호_중복() throws Exception {
        //given
        String winningBonusNumberDuplicateString = "1";
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            new LottoWinningBonusNumber(winningBonusNumberDuplicateString, winningNumbers);
        });
    }

}
