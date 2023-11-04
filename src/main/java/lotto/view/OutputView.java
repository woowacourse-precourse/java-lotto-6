package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import static lotto.system.SystemMessage.INPUT_AMOUNT_MESSAGE;
import static lotto.system.SystemMessage.OUTPUT_QUANTITY_MESSAGE;
import static lotto.system.SystemMessage.NEWLINE;
import static lotto.system.SystemMessage.INPUT_WINNING_MESSAGE;
import static lotto.system.SystemMessage.INPUT_BONUS_MESSAGE;
import static lotto.system.SystemMessage.RESULT_STATISTICS;
import static lotto.system.SystemMessage.LINE;
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
	
	public static void printResult() {
		System.out.print(NEWLINE);
		System.out.println(RESULT_STATISTICS);
		System.out.println(LINE);
	}
}