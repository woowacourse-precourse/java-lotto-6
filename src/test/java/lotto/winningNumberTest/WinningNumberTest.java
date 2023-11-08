package lotto.winningNumberTest;

import lotto.controller.WinningNumberController;
import lotto.domain.WinningNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumberTest {
    @DisplayName("당첨 금액 입력 테스트")
    @Test
    void putWinningNums() {
        // given
        String winningNums = "1,2,3,4,5,6";

        // when
        WinningNumber.getInstance().putWinningNums(winningNums);

        //then
        Assertions.assertThat(WinningNumber.getInstance().getWinningNums().get(0)).isEqualTo(1);
        Assertions.assertThat(WinningNumber.getInstance().getWinningNums().get(1)).isEqualTo(2);
        Assertions.assertThat(WinningNumber.getInstance().getWinningNums().get(2)).isEqualTo(3);
        Assertions.assertThat(WinningNumber.getInstance().getWinningNums().get(3)).isEqualTo(4);
        Assertions.assertThat(WinningNumber.getInstance().getWinningNums().get(4)).isEqualTo(5);

    }

    @DisplayName("보너스 금액 입력 테스트")
    @Test
    void putBonusNum() {
        // given
        String winningNums = "1,2,3,4,5,6";
        String bonusNum = "7";

        // when
        WinningNumber.getInstance().putWinningNums(winningNums);
        WinningNumber.getInstance().putBonusNum(bonusNum);

        //then
        Assertions.assertThat(WinningNumber.getInstance().getBonusNum()).isEqualTo(7);


    }
}
