package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
  public static void main(String[] args) {
//    사용자로부터 구입금액을 입력받는다.
    InputView inputView = new InputView();
//    결과를 출력하기 위해 ResultView 객체를 생성한다.
    ResultView resultView = new ResultView();

//    로또 구매 금액을 사용자로부터 입력 받는다.
    int purchaseAmount = inputView.requestPurchaseAmount();
//    로또 머신을 생성하고, 구매 금액을 전달한다.
    LottoMachine lottoMachine = new LottoMachine(purchaseAmount);
//    로또 머신에서 로또를 구매하고 해당 결과를 받는다.
    List<Lotto> lottos = lottoMachine.purchaseLottos();

//    구매한 로또의 결과를 출력한다.
    resultView.printLottos(lottos);

//    당첨 번호를 사용자로부터 입력받는다.
    List<Integer> winningNumbers = inputView.requestWinningNumbers();
//    보너스 번호를 사용자로부터 입력받는다.
    int bonusBall = inputView.requestBonusBall();

//    당첨 번호와 보너스 번호를 가지고 WinningLotto 객체를 생성한다.
    WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusBall);

//    결과를 저장하기 위한 Map 객체를 생성한다.
    Map<LottoRank, Integer> result = new HashMap<>();

//    구매한 모든 로또에 대해 당첨 결과를 계산하고 그 결과를 Map에 저장한다.
    for (Lotto lotto : lottos) {
      LottoRank rank = winningLotto.rank(lotto);
      result.put(rank, result.getOrDefault(rank, 0) + 1);
    }

//    최종 결과를 출력한다.
    resultView.printResult(result);
  }
}