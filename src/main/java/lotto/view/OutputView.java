package lotto.view;

import lotto.domain.IncomeRate;
import lotto.domain.LottoPack;
import lotto.domain.LottoStatistics;
import lotto.util.Printer.IPrinter;

import static lotto.constant.OutputMessage.*;

public class OutputView {

    private final IPrinter printer;

    public OutputView(IPrinter printer) {
        this.printer = printer;
    }

    public void printGetMoney() {
        printer.println(GET_MONEY_MESSAGE);
    }

    public void newline() {
        printer.println();
    }

    public void printLottoPack(LottoPack lottoPack) {
        printer.println(buildLottoPackMessage(lottoPack));
        printer.println(lottoPack.toString());
    }

    private String buildLottoPackMessage(LottoPack lottoPack) {
        return String.format(BOUGHT_LOTTO_PACK_MESSAGE, lottoPack.size());
    }

    public void printGetWinningNumbers() {
        printer.println(GET_WINNING_NUMBERS_MESSAGE);
    }

    public void printGetBonusNumber() {
        printer.println(GET_BONUS_NUMBER_MESSAGE);
    }

    public void printResult(LottoStatistics lottoStatistics) {
        printer.println(LOTTO_RESULT_MESSAGE);
        printer.println(lottoStatistics.toString());
    }

    public void printIncomeRate(IncomeRate incomeRate) {
        printer.println(String.format(INCOME_RATE_MESSAGE, incomeRate.getIncomeRate()));
    }

    public void printException(Exception exception) {
        printer.println(exception.getMessage());
    }

}
