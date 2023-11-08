package lotto.controller;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.domain.UserBuyLotto;
import lotto.domain.Lotto;
import lotto.domain.MakeLotto;
import lotto.domain.Winning;
import lotto.domain.Ranking;

public class Controller {
  public Controller() {

  }
  private static UserBuyLotto user;
  private static List<Integer> lotto = new ArrayList<>();
  private static List<Lotto> lottoList;
  private static Winning winning;
  public void run() {
    try {
      start();
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }
  }

  public void start() {
    // user 입력으로 티켓 개수 가져온다
    int ticketCount = inputPlayerAmount();
    OutputView.printTicketCount(ticketCount);

    // 로또 당첨번호 + 보너스 번호 입력
    lottoList = makeLottoList(ticketCount);
    winning = validateBonus();

    lottoResult(lottoList, winning, ticketCount);

  }

  private void lottoResult(List<Lotto> lottoList, Winning winningLotto, int amount) {
    Map<Ranking, Integer> result = setResult();
    Ranking rank;

    OutputView.printSuccessResult();
    for (int i = 0; i < lottoList.size(); i++) {
      rank = winningLotto.match(lottoList.get(i));
      result.put(rank, result.get(rank) + 1);
    }
    printResult(result);
    printEarningRate(result, amount);
  }

  private Map<Ranking, Integer> setResult() {
    Map<Ranking, Integer> result = new LinkedHashMap<>();

    for (Ranking rank : Ranking.values()) {
      result.put(rank, 0);
    }
    return result;
  }

  private void printEarningRate(Map<Ranking, Integer> result, int lottoAmount) {
    double EarningRate = 0;
    for (Ranking rank : result.keySet()) {
      EarningRate =
        EarningRate + ((double) (rank.getWinningAmount()) / (lottoAmount * 1000) * (result.get(
          rank)) * (100));

    }
    OutputView.printRevenueRate(EarningRate);
  }

  private void printResult(Map<Ranking, Integer> result) {
    for (int i = Ranking.values().length - 1; i >= 0; i--) {
      Ranking.values()[i].printMessage(result.get(Ranking.values()[i]));
    }
  }

  public int inputPlayerAmount() {
    user = new UserBuyLotto(InputView.inputPlayerAmount());
    return user.calculateLottoCount();
  }

  private static List<Lotto> makeLottoList(int ticketCount) {
    lottoList = new ArrayList<>();
    for (int i = 0; i < ticketCount; i++) {
      lottoList.add(makeLotto());
    }
    return lottoList;
  }

  private static Lotto makeLotto() {
    MakeLotto makeLotto = new MakeLotto();
    lotto = new ArrayList<>();

    lotto = makeLotto.makeLotto();
    System.out.println(lotto);
    return new Lotto(lotto);
  }

  public Winning validateBonus() {
    Lotto lotto = new Lotto(InputView.inputLottoWinningNum());
    // 당첨번호
    List<Integer> winningNumber = lotto.getLottoNumbers();
    // 보너스 번호
    int ball = InputView.inputBonusNumber();
    // 중복 체크
    lotto.validateBonusNumber(winningNumber, ball);

    // 당첨 로또 값 저장
    winning = new Winning(new Lotto(winningNumber), ball);

    return winning;
  }


}
