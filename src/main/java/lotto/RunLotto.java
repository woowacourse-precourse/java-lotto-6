package lotto;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.UserInputNumbers;
import lotto.sevice.Calculator;
import lotto.util.InputManager;
import lotto.sevice.LottoGenerator;
import lotto.util.OutputManager;
import lotto.domain.WinningCheck;

public class RunLotto {

  private final InputManager inputManager = new InputManager();
  private final LottoGenerator lottoGenerator = new LottoGenerator();
  private final Calculator calculator = new Calculator();
  private final OutputManager outputManager = new OutputManager();

  public void runLotto() {
    PurchaseAmount purchaseAmount = inputManager.receivePurchaseAmount();
    List<Lotto> generatedLottos = lottoGenerator.generateLottos(purchaseAmount);
    outputManager.printGeneratedLottoNumbers(generatedLottos);

    UserInputNumbers userInputNumbers = inputManager.receiveLottoNumber();

    Map<WinningCheck, Integer> result = calculator.calculateWinningResult(generatedLottos,
        userInputNumbers);
    double profitRate = calculator.calculateProfitRate(purchaseAmount, result);

    outputManager.printResults(result, profitRate);
  }
}
