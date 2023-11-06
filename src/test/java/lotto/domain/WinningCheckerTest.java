package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WinningCheckerTest {

    @Test
    @DisplayName("맞은 로또 갯수를 센다.")
    void countWinningLottosTest() {
        //given
        List<Lotto> myLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6))        //1등
                , new Lotto(List.of(1, 2, 3, 4, 5, 7))      //2등
                , new Lotto(List.of(1, 2, 3, 4, 5, 10))     //3등
                , new Lotto(List.of(1, 2, 3, 4, 10, 11))    //4등
                , new Lotto(List.of(1, 2, 3, 10, 11, 12))); //5등
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);

        WinningChecker winningChecker = new WinningChecker(myLottos, winningNumbers, bonusNumber);

        //when
        List<Integer> winningLottos = winningChecker.countWinningLottos();

        //then
        Assertions.assertThat(winningLottos).isEqualTo(List.of(1, 1, 1, 1, 1));
    }
}