package lotto.view;

import lotto.io.OutputViewPrinter;
import lotto.util.message.ProgressMessage;
import lotto.util.message.WinningStatisticsMessage;

public class OutputView {

	private static final OutputViewPrinter PRINTER = new OutputViewPrinter();
	private static final String NEWLINE = "\n";

	public void printInputMoneyMessage() {
		PRINTER.printLine(ProgressMessage.INPUT_MONEY.getMessage());
	}

	public void printBuyedLottoNumberMessage(int buyedCount) {
		PRINTER.printLine(NEWLINE + ProgressMessage.BUYED_LOTTO_NUMBER.getForMatMessage(buyedCount));
	}

	public void printLottoNumbers(String message) {
		PRINTER.printLine(message);
	}

	public void printInputAnswerLottoNumberMessage() {
		PRINTER.printLine(NEWLINE + ProgressMessage.INPUT_ANSWER_LOTTO_NUMBER.getMessage());
	}

	public void printInputBonusNumberMessage() {
		PRINTER.printLine(NEWLINE + ProgressMessage.INPUT_BONUS_NUMBER.getMessage());
	}

	public void printWinningStatisticsTopMessage() {
		PRINTER.printLine(NEWLINE + WinningStatisticsMessage.TOP.getMessage());
	}

	public void printWinningStatisticsMessage(String message) {
		PRINTER.printLine(message);
	}

	public void printTotalReturn(double totalReturn) {
		PRINTER.printLine(WinningStatisticsMessage.TOTAL_RETURN.getForMatMessage(totalReturn));
	}
	
	public void printErrorMessage(Exception exception) {
		System.out.println(exception.getMessage());
	}
}
