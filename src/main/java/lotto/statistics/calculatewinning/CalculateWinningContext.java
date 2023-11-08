package lotto.statistics.calculatewinning;

import java.util.List;
import java.util.stream.Collectors;
import lotto.Either;
import lotto.Lotto;

public class CalculateWinningContext {

  public static Either<NotWin, List<WinningRecord>> calculateWinning(List<Lotto> issuedLottos, Lotto winningNumber, int bonusNumber) {
    List<ComparativeRecord> comparativeRecords = getComparativeRecords(issuedLottos, winningNumber);
    List<WinningRecord> winningRecords = getWinningRecords(comparativeRecords, bonusNumber);
    if (winningRecords.isEmpty()){
      return Either.left(NotWin.NOT_WIN);
    }
    return Either.right(winningRecords);
  }

  private static List<ComparativeRecord> getComparativeRecords(
      List<Lotto> issuedLottos, Lotto winningNumber) {
    return issuedLottos.stream()
        .map(lotto -> new ComparativeRecord(lotto, lotto.match(winningNumber)))
        .toList();
  }

  private static List<WinningRecord> getWinningRecords(
      List<ComparativeRecord> comparativeRecords, int bonusNumber) {
    return comparativeRecords.stream()
        .filter(comparativeRecord -> comparativeRecord.results().isWin())
        .map(comparativeRecord -> Ranking.findRanking(comparativeRecord.results().getWin(),
            comparativeRecord.lotto().matchBonusNumber(bonusNumber)))
        .map(ranking -> new WinningRecord(ranking, 1))
        .collect(Collectors.toMap(
            WinningRecord::ranking,
            w -> w,
            WinningRecord::plusMatchCount))
        .values().stream().sorted().toList();
  }
}
