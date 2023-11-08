package lotto;

import lotto.Input.InputContext;
import lotto.Input.IssueLottoCommand;
import lotto.Input.StatisticsStartCommand;
import lotto.Input.winningnumber.NumberEnteredCommand;
import lotto.print.PrintContext;
import lotto.publish.IssueLottoContext;
import lotto.publish.IssuedLottoPrintCommand;
import lotto.statistics.StaticsContext;
import lotto.statistics.StatisticsPrintCommand;

public class Application {
    public static void main(String[] args) {
        IssueLottoCommand issueLottoCommand = InputContext.inputPurchaseAmount().toIssueLottoCommand();
        IssuedLottoPrintCommand outputCommand = IssueLottoContext.issue(issueLottoCommand).toOutputCommand();
        PrintContext.printIssuedLotto(outputCommand);
        StatisticsStartCommand statisticsStartCommand = InputContext.inputWinningNumber(NumberEnteredCommand.of(outputCommand.getLottos()));
        StatisticsPrintCommand statisticsPrintCommand = StaticsContext.calculateStatics(statisticsStartCommand).toStatisticsPrintCommand();
        PrintContext.printStatistics(statisticsPrintCommand);
    }
}
