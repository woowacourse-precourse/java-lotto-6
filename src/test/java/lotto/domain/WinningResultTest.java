package lotto.domain;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningResultTest {
    WinningResult winningResult;
    Lottos lottos;
    WinningNumber winningNumber;

    @BeforeEach
    void init() {
        winningResult = new WinningResult();
        Lotto firstLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto secondLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        lottos = new Lottos(List.of(firstLotto, secondLotto));
        winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
        winningNumber.setBonusNumber(7);
    }

    @DisplayName("전체 로또와 , 당첨 번호를 통해 몇등에 몇개 당첨됐는지를 계산함")
    @Test
    void calculateWinningFirstTest() {
        //given
        winningResult.calculateWinning(lottos, winningNumber);

        //when
        int firstCount = winningResult.getWinningCount(Rank.FIRST);
        int secondCount = winningResult.getWinningCount(Rank.SECOND);

        //then
        Assertions.assertEquals(1, firstCount);
        Assertions.assertEquals(1, secondCount);
    }

}
