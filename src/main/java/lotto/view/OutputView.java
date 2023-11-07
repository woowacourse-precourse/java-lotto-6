package lotto.view;

import static lotto.constant.GameMessage.*;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import lotto.domain.Lotto;
import lotto.domain.Prize;

public class OutputView {
	public static void printLottos(int amount, List<Lotto> lotts) {
		System.out.println(String.format(PRINT_LOTTO_AMOUNT, amount));

		for(Lotto lotto : lotts) {
			System.out.println(lotto.getLotto());
		}
	}

	public static void printResult(Map<Prize, Integer> results) {
		for (Prize prize : Prize.values()) {
			int count = results.getOrDefault(prize, 0);
			if (count >= 0) {
				System.out.println(String.format(PRINT_RESULT, prize.getMatchAmount(), convertWithDelimiter(prize.getPrize()), count));
			}
		}
	}

	private static String convertWithDelimiter(int number) {
		DecimalFormat formatter = new DecimalFormat("#,###");
		return formatter.format(number);
	}
}
