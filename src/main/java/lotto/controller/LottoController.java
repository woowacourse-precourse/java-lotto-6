package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.LottoGame;
import lotto.model.LottoResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

  private static lotto.model.LottoGame LottoGame;

  public LottoController() {
    LottoGame = new LottoGame();
  }

  public static List<List<Integer>> createLottos(int calculateLottoCount) {
    List<List<Integer>> lottos = new ArrayList<>();
    for (int i = 0; i < calculateLottoCount; i++) {
      List<Integer> lotto = LottoGame.createRandomLottoNumber();
      lottos.add(lotto);
    }
    return lottos;
  }

  public static void run() {
    int money = InputView.inputMoney();
    int calculateLottoCount = InputProcessor.calculateLottoCount(money);
    OutputView.printLottoCountMessage(calculateLottoCount);
    List<List<Integer>> lottos = createLottos(calculateLottoCount);
    OutputView.printLottos(lottos);
    String winningNumber = InputView.inputWinningNumber();
    List<String> winningNumbers = InputProcessor.splitWinningNumbers(winningNumber);
    List<Integer> winningNumberSet = InputProcessor.convertToIntegerList(winningNumbers);
    int bonusNumber = InputView.inputBonusNumber(winningNumberSet);
    List<Integer> rank = checkLottoResults(lottos, winningNumberSet, bonusNumber);
    printLottoResults(money, rank);
  }

  public static List<Integer> checkLottoResults(List<List<Integer>> lottos, List<Integer> winningNumberSet, int bonusNumber) {
    return LottoGame.checkWinningStatus(lottos, winningNumberSet, bonusNumber);
  }

  public static void printLottoResults(int money, List<Integer> rank) {
    OutputView.printSuccessResult();
    OutputView.printRanking(rank);

    int prize = LottoResult.lottoPrizeCalculator(rank);
    double profitability = LottoResult.profitabilityCalculator(money, prize);
    String formattedValue = LottoResult.calculateRoundedProfitabilityWithCommas(profitability);
    OutputView.printProfitability(formattedValue);
  }
}
