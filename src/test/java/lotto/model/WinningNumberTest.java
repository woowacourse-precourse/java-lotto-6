package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WinningNumberTest {
    @Test
    public void 당첨번호_생성_테스트() {
        //given
        WinningNumber winningNumber = new WinningNumber(List.of(1,2,3,4,5,6));
        int bonusNumber = 7;

        //when
        winningNumber.addBonusNumber(String.valueOf(bonusNumber));

        //then
        Assertions.assertThat(winningNumber.contains(1)).isTrue();
        Assertions.assertThat(winningNumber.contains(2)).isTrue();
        Assertions.assertThat(winningNumber.contains(3)).isTrue();
        Assertions.assertThat(winningNumber.contains(4)).isTrue();
        Assertions.assertThat(winningNumber.contains(5)).isTrue();
        Assertions.assertThat(winningNumber.contains(6)).isTrue();
        Assertions.assertThat(winningNumber.contains(7)).isFalse();

        Assertions.assertThat(winningNumber.getBonusNumber()).isEqualTo(7);
    }
}
