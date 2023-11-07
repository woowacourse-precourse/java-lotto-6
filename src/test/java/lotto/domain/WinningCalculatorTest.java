package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningCalculatorTest {

    private WinningCalculator winningCalculator;

    @BeforeEach
    void setWinningNumberAndBonusNumber() {
        List<Integer> winningNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        Integer bonusNumber = 7;
        winningCalculator = new WinningCalculator(winningNumbers, bonusNumber);
    }

    @DisplayName("로또 번호가 모두 일치하면 1등")
    @Test
    void calculateFirstPlaceWinner() {
        List<Lotto> lottoes = new ArrayList<>();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lottoes.add(lotto);

        WinningResult winningResult = winningCalculator.calculate(lottoes);

        Assertions.assertEquals(winningResult.getNumberOfFirst(), 1);
    }

    @DisplayName("로또 번호 5개와 보너스번호가 일치하면 2등")
    @Test
    void calculateSecondPlaceWinner() {
        List<Lotto> lottoes = new ArrayList<>();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        lottoes.add(lotto);

        WinningResult winningResult = winningCalculator.calculate(lottoes);

        Assertions.assertEquals(winningResult.getNumberOfSecond(), 1);
    }
}
