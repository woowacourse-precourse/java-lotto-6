package lotto.statistics;

public class StatisticsPrintCommand {
  private final TotalStaticRecord totalStaticRecord;

  private StatisticsPrintCommand(TotalStaticRecord totalStaticRecord) {
    this.totalStaticRecord = totalStaticRecord;
  }

  public static StatisticsPrintCommand of(TotalStaticRecord totalStaticRecord) {
    return new StatisticsPrintCommand(totalStaticRecord);
  }

  public TotalStaticRecord getTotalStaticRecord() {
    return totalStaticRecord;
  }
}
