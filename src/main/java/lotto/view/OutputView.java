package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.dto.AmountDto;
import lotto.dto.EarningDto;

import static lotto.system.SystemMessage.INPUT_AMOUNT_MESSAGE;
import static lotto.system.SystemMessage.OUTPUT_QUANTITY_MESSAGE;
import static lotto.system.SystemMessage.NEWLINE;
import static lotto.system.SystemMessage.INPUT_WINNING_MESSAGE;
import static lotto.system.SystemMessage.INPUT_BONUS_MESSAGE;
import static lotto.system.SystemMessage.RESULT_STATISTICS;
import static lotto.system.SystemMessage.LINE;
import static lotto.system.SystemMessage.COUNT_MESSAGE;
import static lotto.system.SystemMessage.STATISTICS_START_MESSAGE;
import static lotto.system.SystemMessage.STATISTICS_END_MESSAGE;
import static lotto.system.SystemMessage.LAST_RANK_MATCH_MESSAGE;
import static lotto.system.SystemMessage.FOURTH_RANK_MATCH_MESSAGE;
import static lotto.system.SystemMessage.THIRD_RANK_MATCH_MESSAGE;
import static lotto.system.SystemMessage.SECOND_RANK_MATCH_MESSAGE;
import static lotto.system.SystemMessage.FIRST_RANK_MATCH_MESSAGE;
import static lotto.system.Constant.LAST_RANK;
import static lotto.system.Constant.FOURTH_RANK;
import static lotto.system.Constant.THIRD_RANK;
import static lotto.system.Constant.SECOND_RANK;
import static lotto.system.Constant.FIRST_RANK;

public class OutputView {
	public static void printInputAmount() {
		System.out.println(INPUT_AMOUNT_MESSAGE);
	}
	
	public static void printQuantity(int availableQuantity) {
		System.out.print(NEWLINE);
		System.out.println(availableQuantity + OUTPUT_QUANTITY_MESSAGE.getMessage());
	}
	
	public static void printLottos(List<Lotto> lottos) {
		for (int i=0; i<lottos.size(); i++) {
			System.out.println(lottos.get(i).getNumbers());
		}
		System.out.print(NEWLINE);
	}
	
	public static void printInputWinning() {
		System.out.println(INPUT_WINNING_MESSAGE);
	}
	
	public static void printInputBonus() {
		System.out.print(NEWLINE);
		System.out.println(INPUT_BONUS_MESSAGE);
	}
	
	public static void printResult(EarningDto earning, AmountDto amount) {
		System.out.print(NEWLINE);
		System.out.println(RESULT_STATISTICS);
		System.out.println(LINE);
		printMatchCount(earning);
		printStatistics(earning, amount);
	}
	
	private static void printMatchCount(EarningDto earning) {
		System.out.print(LAST_RANK_MATCH_MESSAGE);
		printCount(earning, LAST_RANK.getconstant());
		System.out.print(FOURTH_RANK_MATCH_MESSAGE);
		printCount(earning, FOURTH_RANK.getconstant());
		System.out.print(THIRD_RANK_MATCH_MESSAGE);
		printCount(earning, THIRD_RANK.getconstant());
		System.out.print(SECOND_RANK_MATCH_MESSAGE);
		printCount(earning, SECOND_RANK.getconstant());
		System.out.print(FIRST_RANK_MATCH_MESSAGE);
		printCount(earning, FIRST_RANK.getconstant());
	}

	private static void printCount(EarningDto earning, int n) {
		System.out.print(earning.getRankCount(n));
		System.out.println(COUNT_MESSAGE);
	}
	private static void printStatistics(EarningDto earning, AmountDto amount) {
		System.out.print(STATISTICS_START_MESSAGE);
		System.out.print(earning.calculateEarningRate(amount.getAmount()));
		System.out.println(STATISTICS_END_MESSAGE);
	}
}