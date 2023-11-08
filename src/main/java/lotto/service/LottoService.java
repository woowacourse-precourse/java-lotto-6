package lotto.service;

import java.text.NumberFormat;
import java.util.List;
import lotto.dto.Result;
import lotto.model.MyLotto;
import lotto.model.Lotto;
import lotto.model.WinLotto;

public class LottoService {

  private final NumberGenerator numberGenerator;

  public LottoService(NumberGenerator numberGenerator) {
    this.numberGenerator = numberGenerator;
  }

  private List<Integer> getLottery() {
    return numberGenerator.generate();
  }

  public MyLotto lotteryIssuance(String amount) {

    MyLotto myLotto = MyLotto.purchase(amount);

    for (int i = 0; i < myLotto.getLottoTickets(); i++)
      myLotto.addLotto(new Lotto(getLottery()));

    return myLotto;
  }

  public WinLotto setWinningLottery(String winLottoValue, String bonusNumValue) {

    return WinLotto.setWinLotto(winLottoValue, bonusNumValue);
  }

  public Result getResultFromComparison(MyLotto myLotto, WinLotto winLotto) {

    String result = generateStatistics(myLotto.getMyLotto(), winLotto.getWinLotto(), winLotto.getBonusNumber());

    return new Result(result);
  }

  private String generateStatistics(List<Lotto> myLotto, List<Integer> winLotto, int bonusNumber) {
    StringBuilder result = new StringBuilder();

    int[] lottoResult = new int[Winning.values().length];

    for (Lotto lotto : myLotto) {
      int matchCount = (int) lotto.getNumbers().stream()
          .filter(winLotto::contains)
          .count();

      if (matchCount < 3) {
        continue;
      }

      boolean hasBonusNumber = lotto.getNumbers().contains(bonusNumber);

      Winning winning = Winning.values()[matchCount - 3];
      if (winning == Winning.FIVE_MATCH && hasBonusNumber) {
        winning = Winning.FIVE_WITH_BONUS;
      }

      lottoResult[winning.ordinal()]++;
    }

    for (int i = 0; i < lottoResult.length; i++) {
      Winning winning = Winning.values()[i];
      String matchCountMessage = winning.getMatchCount() + "개 일치";

      if (winning == Winning.FIVE_WITH_BONUS) {
        matchCountMessage += ", 보너스 볼 일치";
      }

      result.append(matchCountMessage)
          .append(" (")
          .append(NumberFormat.getInstance().format(winning.getPrize()))
          .append("원) - ")
          .append(lottoResult[i])
          .append("개\n");
    }

    double totalPrize = calculateTotalPrize(lottoResult);
    double profitRate = calculateProfitRate(totalPrize, myLotto.size());
    result.append("총 수익률은 ")
        .append(profitRate)
        .append("%입니다.");

    return result.toString();
  }

  private double calculateTotalPrize(int[] lottoResult) {
    double totalPrize = 0;
    for (int i = 0; i < lottoResult.length; i++) {
      Winning winning = Winning.values()[i];
      totalPrize += winning.getPrize() * lottoResult[i];
    }
    return totalPrize;
  }

  private double calculateProfitRate(double totalPrize, int totalInvestment) {
    double investment = totalInvestment * 1000;
    return (totalPrize / investment) * 100;
  }
}
