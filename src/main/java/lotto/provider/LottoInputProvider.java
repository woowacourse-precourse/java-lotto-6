package lotto.provider;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

public class LottoInputProvider {

	public int getInputPrice(String question) {
		System.out.println(question);
		return Integer.parseInt(Console.readLine());
	}

	public Lotto getInputWinningNumber(String question) {
		System.out.println(question);
		List<Integer> numbers = Arrays.stream(Console.readLine().split(","))
			.map(num -> Integer.parseInt(num))
			.collect(Collectors.toList());

		return new Lotto(numbers);
	}

	public int getInputBonusNumber(String question) {
		System.out.println(question);
		return Integer.parseInt(Console.readLine());
	}
}
