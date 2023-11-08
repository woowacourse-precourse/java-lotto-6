package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest {
    Player player;

    @BeforeEach
    void SetUp() {
        player = new Player();
    }

    @Test
    void 구입_금액_입력() {
        int purChaseAmountInput = 100000;
        player.insertPurchaseAmount(purChaseAmountInput);

        assertEquals(purChaseAmountInput, player.getPurChaseAmount());
    }

    @Test
    void 당첨_번호_입력() {
        String winningNumbers = "1,2,3,4,5,6";
        player.insertWinningNumbers(winningNumbers);

        List<Integer> expectedWinningNumber = List.of(1,2,3,4,5,6);
        assertEquals(expectedWinningNumber, player.getWinningNumbers());
    }

    @Test
    void 보너스_번호_입력() {
        String bonusNumber = "3";
        player.insertBonusNumber(bonusNumber);

        assertEquals(Integer.parseInt(bonusNumber), player.getBonusNumber());
    }

    @Test
    void 수익률_반환() {
        int purChaseAmountInput = 100000;
        player.insertPurchaseAmount(purChaseAmountInput);
        double expectedRateOfReturn = 1000.0;

        player.calculateRateOfReturn(1000000);

        assertEquals(expectedRateOfReturn, player.getRateOfReturn());
    }
}
