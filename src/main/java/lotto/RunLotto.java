package lotto;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.UserInputNumbers;
import lotto.service.LottoProfitRateCalculator;
import lotto.service.LottoResultCalculator;
import lotto.util.InputManager;
import lotto.service.LottoGenerator;
import lotto.util.OutputManager;
import lotto.domain.WinningCheck;

public class RunLotto {

  private final InputManager inputManager = new InputManager();
  private final LottoGenerator lottoGenerator = new LottoGenerator();
  private final LottoResultCalculator lottoResultCalculator = new LottoResultCalculator();
  private final LottoProfitRateCalculator lottoProfitRateCalculator = new LottoProfitRateCalculator();
  private final OutputManager outputManager = new OutputManager();

  public void runLotto() {
    PurchaseAmount purchaseAmount = inputManager.receivePurchaseAmount();

    List<Lotto> generatedLottos = lottoGenerator.generateLottos(purchaseAmount);
    outputManager.printGeneratedLottoNumbers(generatedLottos);

    UserInputNumbers userInputNumbers = inputManager.receiveLottoNumber();

    Map<WinningCheck, Integer> result = lottoResultCalculator
        .calculateWinningResult(generatedLottos, userInputNumbers);
    double profitRate = lottoProfitRateCalculator
        .calculateProfitRate(purchaseAmount, result);

    outputManager.printResults(result, profitRate);
  }
}
