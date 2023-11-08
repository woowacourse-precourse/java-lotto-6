package lotto.print;

import static java.lang.String.format;
import static java.lang.System.*;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import lotto.Lotto;
import lotto.publish.IssuedLottoPrintCommand;
import lotto.statistics.StaticsRecord;
import lotto.statistics.StatisticsPrintCommand;

public class PrintContext {
  public static void printIssuedLotto(IssuedLottoPrintCommand command){
    List<Lotto> lottos = command.getLottos();
    out.println(lottos.size() + "개를 구매했습니다.");
    for (Lotto lotto : lottos) {
      out.println(lotto.getNumbers());
    }
  }

  public static void printStatistics(StatisticsPrintCommand command){
    List<StaticsRecord> records = command.getTotalStaticRecord().records();
    double yield = command.getTotalStaticRecord().yield();
    out.println();
    out.println("당첨 통계");
    out.println("---");
    NumberFormat nf = NumberFormat.getInstance(Locale.US);
    for(int i =0; i<records.size(); i++){
      StaticsRecord record = records.get(i);
      if (i == 3){
        out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개%n", record.winningNumber(), nf.format(record.prize()), record.matchCount());
        continue;
      }
      out.printf("%d개 일치 (%s원) - %d개%n", record.winningNumber(), nf.format(record.prize()), record.matchCount());
    }
    out.println(format("총 수익률은 %.1f", yield) + "%입니다.");
  }
}
