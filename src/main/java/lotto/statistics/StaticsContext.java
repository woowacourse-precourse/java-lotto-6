package lotto.statistics;

import java.util.Arrays;
import java.util.List;
import lotto.Either;
import lotto.Input.StatisticsStartCommand;
import lotto.Lotto;
import lotto.statistics.calculatewinning.CalculateWinningContext;
import lotto.statistics.calculatewinning.NotWin;
import lotto.statistics.calculatewinning.Ranking;
import lotto.statistics.calculatewinning.WinningRecord;

public class StaticsContext {

  public static StaticsCalculatedEvent calculateStatics(StatisticsStartCommand command) {
    List<Lotto> issuedLottos = command.getIssuedLottos();
    Lotto winningNumber = command.getWinningNumber();
    int bonusNumber = command.getBonusNumber();
    int standardPrice = command.getStandardPrice();
    Either<NotWin, List<WinningRecord>> winningResult = CalculateWinningContext.calculateWinning(
        issuedLottos, winningNumber, bonusNumber);
    if (winningResult.isLeft()) {
      return StaticsCalculatedEvent.of(TotalStaticRecord.of(getStaticsRecords(), 0));
    }
    List<WinningRecord> records = winningResult.getRight();
    double yield = calculateYield(standardPrice * issuedLottos.size(),
        records);
    List<StaticsRecord> list = changeStaticsRecords(records);
    return StaticsCalculatedEvent.of(TotalStaticRecord.of(list, yield));
  }

  private static List<StaticsRecord> getStaticsRecords() {
    return Arrays.stream(Ranking.values())
        .map(ranking -> StaticsRecord.of(ranking.getRankMatchCount().getMatchCount(), ranking.getWinningMoney(), 0))
        .toList();
  }

  private static List<StaticsRecord> changeStaticsRecords(List<WinningRecord> records) {
    return records.stream()
        .map(StaticsContext::getStaticsRecords)
        .flatMap(List::stream)
        .distinct()
        .toList();
  }

  private static List<StaticsRecord> getStaticsRecords(WinningRecord record) {
    return Arrays.stream(Ranking.values())
        .map(ranking -> getStaticsRecord(record, ranking))
        .toList();
  }

  private static StaticsRecord getStaticsRecord(WinningRecord record, Ranking ranking) {
    if (ranking == record.ranking()) {
      return StaticsRecord.of(ranking.getRankMatchCount().getMatchCount(), ranking.getWinningMoney(),
          record.matchCount());
    }
    return StaticsRecord.of(ranking.getRankMatchCount().getMatchCount(), ranking.getWinningMoney(), 0);
  }

  private static double calculateYield(int purchaseAmount, List<WinningRecord> winningRecords) {
    double sum = winningRecords.stream()
        .mapToDouble(WinningRecord::winningMoney)
        .sum();
    double v = sum / purchaseAmount * 100;
    return Math.round(v * 100) / 100.0;
  }
}
