package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class conversion {

	public static List<Integer> changeNumbers(String winningNumbers) {
		String[] numbers = winningNumbers.split(",");
		List<Integer> result = new ArrayList<>();
		for (String number : numbers) {
			result.add(Integer.parseInt(number));
		}
		return result;
	}
}
