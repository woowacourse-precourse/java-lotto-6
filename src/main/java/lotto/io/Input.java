package lotto.io;

import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.LottoSeller;

public class Input {

	private static final String SEPARATOR = ",";

	public static int readPurchaseAmount() {
		while (true) {
			try {
				return LottoSeller.validatePurchaseAmount(Console.readLine());
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static List<Integer> readWinningNumbers() {
		while (true) {
			var input = Console.readLine();
			var split = input.split(SEPARATOR);

			try {
				return LottoSeller.validateWinningNumbers(split);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static int readBonusNumbers() {
		while (true) {
			try {
				final String value = Console.readLine();
				final int number = LottoSeller.parseToInteger(value);
				LottoSeller.checkRange(number);
				return number;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}






}
