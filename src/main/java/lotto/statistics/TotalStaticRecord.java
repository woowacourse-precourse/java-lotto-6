package lotto.statistics;

import java.util.List;

public record TotalStaticRecord(List<StaticsRecord> records, double yield) {

  public static TotalStaticRecord of(List<StaticsRecord> records, double yield) {
    return new TotalStaticRecord(records, yield);
  }
}
