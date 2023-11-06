package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import lotto.Lotto;
import lotto.RankGroup;
import lotto.utils.Printer;

public class OutputView {
    private final Printer printer;
    final private String errorPrefix = "[ERROR] ";
    public OutputView(Printer printer) {
        this.printer = printer;
    }

    public void printError(String errorMessage){
        printer.print(errorPrefix + errorMessage);
    }

    public void printWithArguments(String message, Object... args){
        printer.printf(message, args);
    }

    public void printLottos(List<Lotto> lottos){
        for(Lotto lotto:lottos){
            printer.print(lotto.toString());
        }
    }

    public void printLottoResult(float profitRate){
        printer.print("당첨 통계");
        printer.print("---");
        for(RankGroup rankGroup : RankGroup.values()){
            printer.printf("%s (%s원) - %d개%n", rankGroup.getTemplate(), new DecimalFormat("###,###").format(rankGroup.getReward()), rankGroup.getResult());
        }
        printer.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }
}
