package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
  public static void main(String[] args) {
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();
    
    int purchaseAmount = inputView.requestPurchaseAmount();
    LottoMachine lottoMachine = new LottoMachine(purchaseAmount);
    List<Lotto> lottos = lottoMachine.purchaseLottos();
    
    resultView.printLottos(lottos);
    
    List<Integer> winningNumbers = inputView.requestWinningNumbers();
    int bonusBall = inputView.requestBonusBall();
    
    WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusBall);
    
    Map<LottoRank, Integer> result = new HashMap<>();
    
    for (Lotto lotto : lottos) {
      LottoRank rank = winningLotto.rank(lotto);
      result.put(rank, result.getOrDefault(rank, 0) + 1);
    }
    
    resultView.printResult(result);
  }
}

