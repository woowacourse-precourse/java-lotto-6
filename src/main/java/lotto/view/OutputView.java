package lotto.view;

import static lotto.config.RuleConfig.DIGIT;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.RankGroup;
import lotto.utils.Printer;

public class OutputView {
    private final Printer printer;

    public OutputView(Printer printer) {
        this.printer = printer;
    }

    public void printError(String errorMessage){
        String errorPrefix = "[ERROR] ";
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

    public void printLottoResult(BigDecimal profitRate){
        printer.print("당첨 통계");
        printer.print("---");
        for(RankGroup rankGroup : RankGroup.values()){
            printer.printf("%s (%s원) - %d개%n", rankGroup.getTemplate(), new DecimalFormat("###,###").format(rankGroup.getReward()), rankGroup.getResult());
        }
        String formattedProfitRate = profitRate.setScale(DIGIT, RoundingMode.HALF_EVEN).toString();
        printer.printf("총 수익률은 %s%%입니다.%n", formattedProfitRate);
    }
}
