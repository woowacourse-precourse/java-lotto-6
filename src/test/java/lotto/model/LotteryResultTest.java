package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import lotto.model.enums.WinningMoney;
import lotto.util.NumbersGenerator;
import lotto.util.TestFixNumbersGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteryResultTest {

  private NumbersGenerator numbersGenerator;

  @BeforeEach
  void setup() {
    numbersGenerator = new TestFixNumbersGenerator();
  }

  @Test
  @DisplayName("수익률을 항상 0보다 크거나 같다.")
  void testCheckProfitPercentage() {
    int money = 4000;
    PurchaseMoney purchasedMoney = new PurchaseMoney(money);
    PersonLotto personLotto = new PersonLotto(numbersGenerator, purchasedMoney);

    Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
    WinningLotto winningLotto = new WinningLotto(lotto);
    LotteryMachine lotteryMachine = new LotteryMachine(personLotto, winningLotto);

    int bonusNumber = 22;
    Bonus bonus = new Bonus(new Number(bonusNumber), winningLotto);

    Map<WinningMoney, Integer> store = lotteryMachine.drawingLotto(bonus);

    LotteryResult lotteryResult = new LotteryResult(store);
    String profitPercentage = lotteryResult.getProfitPercentage(purchasedMoney);


    assertThat(profitPercentage).isGreaterThanOrEqualTo("0");
  }
}