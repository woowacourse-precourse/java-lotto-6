package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class GameManagerTest {

    private GameManager gameManager;

    @BeforeEach
    void setUp(){
        gameManager = new GameManager();
    }
    @Test
    void 수익률은_소수_둘째자리에서_반올림한다(){
        // Arrange
        List<Integer> myNumber = List.of(1, 2, 3, 4, 5, 10);
        List<Integer> winningNumbers = List.of(1, 2, 3, 11, 12, 13);
        int bonusNumber = 14;

        // Action
        Lotto lotto = new Lotto(myNumber);
        lotto.setWinningNumbersAndBonusNumber(winningNumbers, bonusNumber);
        String profit = gameManager.getProfitRate(List.of(lotto), 3000);

        // Assert
        assertThat(profit).isEqualTo("166.7");
    }

}
