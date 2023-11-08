package lotto.model;

import lotto.Lotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoPlayerTest {

    private LottoPlayer lottoPlayer;
    private MockedStatic<LottoGame> mockedLottoGame;

    @BeforeEach
    void setUp() {
        lottoPlayer = new LottoPlayer();
        mockedLottoGame = Mockito.mockStatic(LottoGame.class);
    }

    @AfterEach
    void tearDown() {
        mockedLottoGame.close();
    }

    @Test
    @DisplayName("LottoPlayer는 주어진 수의 로또를 구매해야 한다")
    void testPurchaseLottos() {
        // Arrange
        int numberOfLottosToPurchase = 5;
        Lotto mockLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        mockedLottoGame.when(() -> LottoGame.generatePurchasedLotto(numberOfLottosToPurchase))
                .thenReturn(Collections.nCopies(numberOfLottosToPurchase, mockLotto));

        // Act
        lottoPlayer.purchaseLottos(numberOfLottosToPurchase);

        // Assert
        assertEquals(numberOfLottosToPurchase, lottoPlayer.getPurchasedLottos().size());
        assertEquals(Lotto.LottoConstants.LOTTO_PRICE.getPrice() * numberOfLottosToPurchase, lottoPlayer.getTotalSpendings());
    }

    @Test
    @DisplayName("LottoPlayer는 총 상금을 업데이트 해야 한다")
    void testUpdateTotalWinning() {
        // Arrange
        long winningAmount = 1000L;

        // Act
        lottoPlayer.updateTotalWinning(winningAmount);

        // Assert
        assertEquals(winningAmount, lottoPlayer.getTotalWinnings());
    }


    @Test
    @DisplayName("수익률을 올바르게 계산해야 한다")
    void testGetEarningRate() {
        // Arrange
        long winnings = 1500L;
        int numberOfLottosPurchased = 5;
        int lottoPrice = Lotto.LottoConstants.LOTTO_PRICE.getPrice();
        lottoPlayer.updateTotalWinning(winnings);
        lottoPlayer.purchaseLottos(numberOfLottosPurchased);

        // Act
        double earningRate = lottoPlayer.getEarningRate();

        // Assert
        double expectedEarningRate = ((double) winnings / (numberOfLottosPurchased * lottoPrice)) * 100;
        assertEquals(expectedEarningRate, earningRate, 0.001); // delta for floating point comparison
    }
}
