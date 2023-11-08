package lotto;

import lotto.model.LotteryCalculator;
import lotto.model.Lotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LotteryCalculatorTest {


  @Test
  public void testDivideByLottoPrice() {
    Assertions.assertEquals(2000, LotteryCalculator.divideByLottoPrice("2000000"));
  }

  @Test
  public void testMatchAndCountWinningNumbers() {
    Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

    int count = LotteryCalculator.matchAndCountWinningNumbers(lotto, winningNumbers);
    assertEquals(6, count);
  }

  @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
  @Test
  public void testMatchBonusNumber() {
    Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    int bonusNumber = 6;

    assertTrue(LotteryCalculator.matchBonusNumber(lotto, bonusNumber));
  }
}
