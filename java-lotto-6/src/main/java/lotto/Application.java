package lotto;

import static lotto.domain.Calculate.returnStatistics;
import static lotto.domain.Calculate.printReturnValue;
import static lotto.domain.Generate.generateLotto;
import static lotto.domain.Input.LOTTO_PRICE;
import static lotto.domain.Output.printLotto;
import static lotto.domain.Output.printLottoCount;
import static lotto.domain.Output.printStatistics;
import java.util.List;
import lotto.domain.Input;


public class Application {
  public static void main(String[] args) {
    int LottoPurchaseAmount = Input.buyLotto();

    printLottoCount(LottoPurchaseAmount);
    Lotto[] myLotto = new Lotto[LottoPurchaseAmount / LOTTO_PRICE];
    generateLotto(myLotto);
    printLotto(myLotto);

    List<Integer> winNum = Input.enterWinningNumber();

    int bonusNum = Input.enterBonusNumber();

    List<Integer> statistics = returnStatistics(myLotto, winNum, bonusNum);

    printStatistics(statistics);
    printReturnValue(statistics, LottoPurchaseAmount);

  }

}
