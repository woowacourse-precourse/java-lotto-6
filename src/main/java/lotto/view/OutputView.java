package lotto.view;

import lotto.domain.LottoRepository;
import lotto.io.OutputViewPrinter;
import lotto.util.message.ProgressMessage;

public class OutputView {

	private static final OutputViewPrinter PRINTER = new OutputViewPrinter();

	public void printInputMoneyMessage() {
		PRINTER.printLine(ProgressMessage.INPUT_MONEY.getMessage());
	}

	public void printBuyedLottoNumberMessage(int buyedCount) {
		PRINTER.printLine(ProgressMessage.BUYED_LOTTO_NUMBER.getForMatMessage(buyedCount));
	}

	public void printLottoNumbers() {
		PRINTER.printLine(LottoRepository.printLottoNumbers());
	}

	public void printInputAnswerLottoNumberMessage() {
		PRINTER.printLine(ProgressMessage.INPUT_ANSWER_LOTTO_NUMBER.getMessage());
	}

	public void printInputBonusNumberMessage() {
		PRINTER.printLine(ProgressMessage.INPUT_BONUS_NUMBER.getMessage());
	}

	public void printWinningStatisticsMessage() {
		PRINTER.printLine(ProgressMessage.WINNING_STATISTICS.getMessage());
	}

	public void printTotalReturn(double totalReturn) {
		PRINTER.printLine(ProgressMessage.TOTAL_RETURN.getForMatMessage(totalReturn));
	}
}
