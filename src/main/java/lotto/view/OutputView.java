package lotto.view;

import lotto.io.OutputViewPrinter;
import lotto.util.message.ProgressMessage;
import lotto.util.message.WinningStatisticsMessage;

public class OutputView {

	private static final String NEWLINE = "\n";
	
	private final OutputViewPrinter printer;
	
	public OutputView() {
		this.printer = new OutputViewPrinter();;
	}

	public void printInputMoneyMessage() {
		printer.printLine(ProgressMessage.INPUT_MONEY.getMessage());
	}

	public void printBuyedLottoNumberMessage(int buyedCount) {
		printer.printLine(NEWLINE + ProgressMessage.BUYED_LOTTO_NUMBER.getFormattedMessage(buyedCount));
	}

	public void printLottoNumbers(String message) {
		printer.printLine(message);
	}

	public void printInputAnswerLottoNumberMessage() {
		printer.printLine(NEWLINE + ProgressMessage.INPUT_ANSWER_LOTTO_NUMBER.getMessage());
	}

	public void printInputBonusNumberMessage() {
		printer.printLine(NEWLINE + ProgressMessage.INPUT_BONUS_NUMBER.getMessage());
	}

	public void printWinningStatisticsTopMessage() {
		printer.printLine(NEWLINE + WinningStatisticsMessage.TOP.getMessage());
	}

	public void printWinningStatisticsMessage(String message) {
		printer.printLine(message);
	}

	public void printTotalReturn(double totalReturn) {
		printer.printLine(WinningStatisticsMessage.TOTAL_RETURN.getFormattedMessage(totalReturn));
	}
	
	public void printErrorMessage(Exception exception) {
		printer.printLine(exception.getMessage());
	}
}
