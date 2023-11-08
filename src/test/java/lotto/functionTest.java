package lotto;

import lotto.controller.LottoGameManager;
import lotto.controller.UserInputManager;
import lotto.model.Lotto;
import lotto.model.BonusNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class functionTest {

    private LottoGameManager testManager;
    private UserInputManager userInputManager;

    @BeforeEach
    void setUpTest() {
        userInputManager = Mockito.mock(UserInputManager.class);
        testManager = new LottoGameManager(userInputManager);
        when(userInputManager.getWinningNumbersInput()).thenReturn("1,2,3,4,5,6");
        when(userInputManager.getBonusNumberInput()).thenReturn("7");
        testManager.settingWinningNumberAndBonusNumber();
    }

    @Test
    void determiningTheNumberOfLottoTest() {
        when(userInputManager.getPurchasePriceInput()).thenReturn("10000");
        assertEquals(10, testManager.determiningTheNumberOfLotto());
    }

    @Test
    void createLottoTest() {
        testManager.creatingAndCheckingLotto(3);
        List<Lotto> userLottos = testManager.getUserLottos();
        assertEquals(3, userLottos.size());

        for (Lotto lotto : userLottos) {
            for (int number : lotto.getNumbers()) {
                assertTrue(number >= 1 && number <= 45);
            }
        }
    }

    @Test
    void setWinningNumberAndBonusNumberTest() {
        Lotto winningLotto = testManager.getWinningLotto();
        BonusNumber bonusNumber = testManager.getBonusNumber();
        assertEquals(Arrays.asList(1,2,3,4,5,6), winningLotto.getNumbers());
        assertEquals(7, bonusNumber.getBonusNumber());
    }

    @Test
    void checkResultTest() {
        Lotto userLotto = new Lotto(Arrays.asList(1, 2, 3, 10, 20, 30));
        testManager.getUserLottos().add(userLotto);

        testManager.JudgementOfWinning();

        assertEquals(1, testManager.getMatchCounts().get(WinningRanking.FIFTH.getRank() - 1));
    }

    @Test
    void profitCalculating_ShouldCalculateProfitCorrectly() {
        when(userInputManager.getPurchasePriceInput()).thenReturn("7000");
        testManager.determiningTheNumberOfLotto();

        testManager.getMatchCounts().set(WinningRanking.FIFTH.getRank() - 1, 5);
        testManager.profitCalculating();

        BigDecimal expectedProfitRate = new BigDecimal("357.1428").setScale(1, RoundingMode.HALF_UP);

        assertEquals(expectedProfitRate, testManager.getProfitRate());
    }

    @Test
    void resultAggregation_ShouldAggregateCorrectly() {
        Lotto secondWinningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        Lotto thirdWinnigLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8));
        Lotto fourthWinningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9));
        Lotto losingWinningLotto = new Lotto(Arrays.asList(8, 9, 10, 11, 12, 13));

        testManager.getUserLottos().addAll(Arrays.asList(secondWinningLotto, thirdWinnigLotto, fourthWinningLotto, losingWinningLotto));

        testManager.JudgementOfWinning();

        List<Integer> matchCounts = testManager.getMatchCounts();
        assertEquals(0, matchCounts.get(WinningRanking.FIRST.getRank() - 1));
        assertEquals(1, matchCounts.get(WinningRanking.SECOND.getRank() - 1));
        assertEquals(1, matchCounts.get(WinningRanking.THIRD.getRank() - 1));
        assertEquals(1, matchCounts.get(WinningRanking.FOURTH.getRank() - 1));
        assertEquals(0, matchCounts.get(WinningRanking.FIFTH.getRank() - 1));
    }

}