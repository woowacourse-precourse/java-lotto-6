package lotto;

import java.util.Arrays;
import lotto.domain.BonusNumber;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {
    @DisplayName("보너스 숫자가 범위를 벗어나는 경우 예외 발생")
    @Test
    public void 보너스_숫자_범위_유효성_테스트_범위밖인경우() {
        int bonusNumber = 500;
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new BonusNumber(bonusNumber, winningNumbers));
    }

    @DisplayName("보너스 숫자가 범위 내인 경우 예외 발생하지 않음")
    @Test
    public void 보너스_숫자_범위_유효성_테스트_범위내인경우() {
        int bonusNumber = 7;
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        Assertions.assertDoesNotThrow(() -> new BonusNumber(bonusNumber, winningNumbers));
    }

    @DisplayName("보너스숫자가 당첨번호와 중복되는 경우 예외 발생")
    @Test
    public void 보너스_숫자가_당첨번호와_중복되는_경우_테스트() {
        int bonusNumber = 27;
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 27));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new BonusNumber(bonusNumber, winningNumbers));
    }

    @DisplayName("유효한 보너스숫자를 넣었을 경우 예외가 발생하지 않음")
    @Test
    public void 유효한_보너스_숫자인_경우_예외_발생여부_테스트() {
        int bonusNumber = 7;
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        Assertions.assertDoesNotThrow(() -> new BonusNumber(bonusNumber, winningNumbers));
    }
}
