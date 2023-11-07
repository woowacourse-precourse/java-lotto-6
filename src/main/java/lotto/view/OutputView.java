package lotto.view;

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

    public void printLottoPack(int lottoPackCount, String lottoPackMessage) {
        printer.println(String.format(BOUGHT_LOTTO_PACK_MESSAGE, lottoPackCount));
        printer.println(lottoPackMessage);
    }

    public void printGetWinningNumbers() {
        printer.println(GET_WINNING_NUMBERS_MESSAGE);
    }

    public void printGetBonusNumber() {
        printer.println(GET_BONUS_NUMBER_MESSAGE);
    }

    public void printResult(String lottoStatisticsMessage) {
        printer.println(LOTTO_RESULT_MESSAGE);
        printer.println(lottoStatisticsMessage);
    }

    public void printIncomeRate(float percentageIncomeRate) {
        printer.println(String.format(INCOME_RATE_MESSAGE, percentageIncomeRate));
    }

    public void printException(Exception exception) {
        printer.println(exception.getMessage());
    }

}
