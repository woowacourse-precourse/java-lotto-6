package lotto.view;

import static lotto.constant.GameMessage.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import lotto.domain.Lotto;
import lotto.domain.Prize;

public class OutputView {
	public static void printLottos(int amount, List<Lotto> lotts) {
		System.out.println(String.format(PRINT_LOTTO_AMOUNT, amount));

		for(Lotto lotto : lotts) {
			List<Integer> sortedNumbers = sortAscending(new ArrayList<>(lotto.getLotto()));
			System.out.println(sortedNumbers);
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

	private static List<Integer> sortAscending(List<Integer> numbers) {
		Collections.sort(numbers);
		return numbers;
	}

	private static String convertWithDelimiter(int number) {
		DecimalFormat formatter = new DecimalFormat("#,###");
		return formatter.format(number);
	}

	public static void printRateOfResult(double rateOfReturn) {
		double value = Math.round(rateOfReturn * 100.0) / 100.0;
		System.out.println(String.format(PRINT_RATE_OF_RETURN, value));
	}
}
