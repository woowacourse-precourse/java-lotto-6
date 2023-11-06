package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.util.NumbersGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningResultTest {
    Lottos lottos;
    WinningNumbers firstWinningNumbers;
    WinningNumbers secondWinningNumbers;
    NumbersGenerator numbersGenerator = () -> List.of(1, 2, 3, 4, 5, 6);

    @BeforeEach
    void init() {
        lottos = new Lottos(1000, numbersGenerator);

        firstWinningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        firstWinningNumbers.setBonusNumber(7);

        secondWinningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 45));
        secondWinningNumbers.setBonusNumber(6);
    }

    @DisplayName("전체 로또와 , 당첨 번호를 통해 1등이 몇개 당첨됐는지를 계산함")
    @Test
    void calculateWinningFirstTest() {
        //given
        WinningResult winningResult = new WinningResult(lottos, firstWinningNumbers);

        //when
        int firstCount = winningResult.getWinningCount(Rank.FIRST);

        //then
        assertEquals(1, firstCount);
    }

    @DisplayName("전체 로또와 , 당첨 번호를 통해 2등이 몇개 당첨됐는지를 계산함")
    @Test
    void calculateWinningSecondTest() {
        //given
        WinningResult winningResult = new WinningResult(lottos, secondWinningNumbers);

        //when
        int secondCount = winningResult.getWinningCount(Rank.SECOND);

        //then
        assertEquals(1, secondCount);
    }

    @DisplayName("당첨에 따른 수익률을 계산한다")
    @Test
    void calculateEarningRateTest() {
        //given
        WinningResult winningResult = new WinningResult(lottos, secondWinningNumbers);

        //when
        winningResult.calculateEarningRate(lottos);
    }

}
