package lotto.provider;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

public class LottoInputProvider {

	public LottoInputProvider() {
	}

	public int getInputPrice() {
		System.out.println("구입금액을 입력해 주세요.");
		return Integer.parseInt(Console.readLine());
	}

	public Lotto getInputWinningNumber() {
		System.out.println("당첨 번호를 입력해 주세요.");
		List<Integer> numbers = Arrays.stream(Console.readLine().split(","))
			.map(num -> Integer.parseInt(num))
			.collect(Collectors.toList());

		return new Lotto(numbers);
	}

}