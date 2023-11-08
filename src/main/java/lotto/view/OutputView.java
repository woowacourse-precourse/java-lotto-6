package lotto.view;

import java.util.StringJoiner;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.WinningStatistic;
import lotto.exception.ErrorMessage;
import lotto.util.Parser;

public class OutputView {

	private static final String PURCHASE_LOTTO_STATUS = "%d개를 구매했습니다.";
	private static final String WINNING_STATISTIC = "당첨 통계";
	private static final String BLANK = "";
	private static final String BREAK_LINE = "---";
	private static final String TOTAL_INCOMING_RATE = "총 수익률은 %,.1f%%입니다.";
	private static final String LINE_SPACE = "\n";

	public void printLottoContent(final Lotto lotto) {
		System.out.println(generateLottoContent(lotto));
	}

	public void printResultContent(final WinningStatistic statistic) {
		System.out.println(generateResultContent(statistic));
	}

	public static void printErrorMessage(ErrorMessage errorMessage) {
		String message = String.format("%n%s", errorMessage.getMessage());
		System.out.println(message);
	}

	public void printLineSpace() {
		System.out.print(LINE_SPACE);
	}

	private String generateLottoContent(final Lotto lotto) {
		StringJoiner lottoContent = new StringJoiner(LINE_SPACE);
		lottoContent.add(String.format(PURCHASE_LOTTO_STATUS, lotto.getLotto().size()))
				.add(Parser.parseLottoNumbers(lotto))
				.add(BLANK);
		return lottoContent.toString();
	}

	private String generateResultContent(final WinningStatistic statistic) {
		StringBuilder resultContent = new StringBuilder(WINNING_STATISTIC);
		resultContent.append(LINE_SPACE)
				.append(BREAK_LINE)
				.append(LINE_SPACE)
				.append(LottoResult.generateResultContent())
				.append(String.format(TOTAL_INCOMING_RATE, statistic.getIncomeRate()));
		return resultContent.toString();
	}
}
