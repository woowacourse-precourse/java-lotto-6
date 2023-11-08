package lotto.statistics;

public class StaticsCalculatedEvent {

  private final TotalStaticRecord totalStaticRecord;

  private StaticsCalculatedEvent(TotalStaticRecord totalStaticRecord) {
    this.totalStaticRecord = totalStaticRecord;
  }

  public static StaticsCalculatedEvent of(TotalStaticRecord totalStaticRecord) {
    return new StaticsCalculatedEvent(totalStaticRecord);
  }

  public StatisticsPrintCommand toStatisticsPrintCommand() {
    return StatisticsPrintCommand.of(totalStaticRecord);
  }

  public TotalStaticRecord getTotalStaticRecord() {
    return totalStaticRecord;
  }
}
