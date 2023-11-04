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
    void 일반번호_3개를_맞춘_경우_금액을_탈수있다(){
        // Arrange
        List<Integer> myNumber = List.of(1, 2, 3, 4, 5, 10);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 6, 7);
        int bonusNumber = 5;

        // Action
        Lotto lotto = new Lotto(myNumber);
        lotto.setWinningNumbersAndBonusNumber(winningNumbers, bonusNumber);
        Double profit = gameManager.getProfitRate(List.of(lotto), 1000);

        // Assert
        assertThat(profit).isEqualTo(5);
    }

}
