package lotto.ModelTest;

import lotto.Model.LottoPrize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoPrizeTest {

    @DisplayName("FirstPrize 판별")
    @Test
    public void testCheckLottoResult_FirstPrize() {
        // Arrange
        int count = 6;
        boolean hasBonus = false;

        // Act
        LottoPrize result = LottoPrize.checkLottoResult(count, hasBonus);

        // Assert
        assertEquals(LottoPrize.FIRST, result);
    }

    @DisplayName("SecondPrize 판별")
    @Test
    public void testCheckLottoResult_SecondPrize() {
        // Arrange
        int count = 5;
        boolean hasBonus = true;

        // Act
        LottoPrize result = LottoPrize.checkLottoResult(count, hasBonus);

        // Assert
        assertEquals(LottoPrize.SECOND, result);
    }

    @DisplayName("ThirdPrize 판별")
    @Test
    public void testCheckLottoResult_ThirdPrize() {
        // Arrange
        int count = 5;
        boolean hasBonus = false;

        // Act
        LottoPrize result = LottoPrize.checkLottoResult(count, hasBonus);

        // Assert
        assertEquals(LottoPrize.THIRD, result);
    }

    @DisplayName("FourthPrize 판별")
    @Test
    public void testCheckLottoResult_FourthPrize() {
        // Arrange
        int count = 4;
        boolean hasBonus = false;

        // Act
        LottoPrize result = LottoPrize.checkLottoResult(count, hasBonus);

        // Assert
        assertEquals(LottoPrize.FOURTH, result);
    }

    @DisplayName("FifthPrize 판별")
    @Test
    public void testCheckLottoResult_FifthPrize() {
        // Arrange
        int count = 3;
        boolean hasBonus = false;

        // Act
        LottoPrize result = LottoPrize.checkLottoResult(count, hasBonus);

        // Assert
        assertEquals(LottoPrize.FIFTH, result);
    }

    @DisplayName("Fail 판별")
    @Test
    public void testCheckLottoResult_Fail() {
        // Arrange
        int count = 2;
        boolean hasBonus = false;

        // Act
        LottoPrize result = LottoPrize.checkLottoResult(count, hasBonus);

        // Assert
        assertEquals(LottoPrize.FAIL, result);
    }

}
