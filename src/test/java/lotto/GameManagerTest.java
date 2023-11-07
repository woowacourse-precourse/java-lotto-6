package lotto;

import org.assertj.core.api.AssertionsForClassTypes;
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
        gameManager.setWinningNumbersAndBonusNumber(winningNumbers, bonusNumber);
        String profit = gameManager.getProfitRate(List.of(lotto), 3000);

        // Assert
        assertThat(profit).isEqualTo("166.7");
    }


    @Test
    void 로또번호를_3개이상_맞춘경우_winningCount_증가() {
        // Arrange
        List<Integer> myNumber = List.of(2, 4, 5, 6, 7, 8);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 9;

        // Action
        Lotto lotto = new Lotto(myNumber);
        gameManager.setWinningNumbersAndBonusNumber(winningNumbers, bonusNumber);

        // Assert
        assertThat(gameManager.getWinningCount(lotto)).isEqualTo(4);
    }

    @Test
    void 일반번호와_보너스번호를_맞춘경우_WinningCount가_증가한다(){
        // Arrange
        List<Integer> myNumber = List.of(1, 2, 7, 8, 9, 10);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // Action
        Lotto lotto = new Lotto(myNumber);
        gameManager.setWinningNumbersAndBonusNumber(winningNumbers, bonusNumber);

        // Assert
        assertThat(gameManager.getWinningCount(lotto)).isEqualTo(3);
    }

    @Test
    void 일반번호_3개를_맞춘_경우_5000원_금액을_탈수있다(){
        // Arrange
        List<Integer> myNumber = List.of(1, 2, 3, 4, 5, 10);
        List<Integer> winningNumbers = List.of(1, 2, 3, 11, 12, 13);
        int bonusNumber = 14;

        // Action
        Lotto lotto = new Lotto(myNumber);
        gameManager.setWinningNumbersAndBonusNumber(winningNumbers, bonusNumber);

        // Assert
        AssertionsForClassTypes.assertThat(gameManager.getWinningMoney(lotto)).isEqualTo(5000);
    }

    @Test
    void 일반번호_4개를_와_보너스번호_1개를_맞춘_경우_3천만원_금액을_탈수있다(){
        // Arrange
        List<Integer> myNumber = List.of(1, 2, 3, 4, 5, 10);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 12, 13);
        int bonusNumber = 5;

        // Action
        Lotto lotto = new Lotto(myNumber);
        gameManager.setWinningNumbersAndBonusNumber(winningNumbers, bonusNumber);

        // Assert
        AssertionsForClassTypes.assertThat(gameManager.getWinningMoney(lotto)).isEqualTo(30000000);
    }

    @Test
    void 일반번호_5개를_맞춘_경우_천오백만원_금액을_탈수있다(){
        // Arrange
        List<Integer> myNumber = List.of(1, 2, 3, 4, 5, 10);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 13);
        int bonusNumber = 14;

        // Action
        Lotto lotto = new Lotto(myNumber);
        gameManager.setWinningNumbersAndBonusNumber(winningNumbers, bonusNumber);

        // Assert
        AssertionsForClassTypes.assertThat(gameManager.getWinningMoney(lotto)).isEqualTo(1500000);
    }
}
