package lotto.provider;

import static lotto.domain.Customer.*;
import static lotto.domain.LottoMachine.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.ErrorType;
import lotto.domain.Lotto;

public class LottoInputProvider {

	public int getInputPrice(String question) {
		System.out.println(question);
		try {
			return Integer.parseInt(Console.readLine());
		} catch (NumberFormatException e) {
			System.out.println(ErrorType.INVALID_PURCHASE_ERROR.getErrorMessage());
			throw new IllegalArgumentException(ErrorType.INVALID_PURCHASE_ERROR.getErrorMessage());
		}
	}

	public Lotto getInputWinningNumber(String question) {
		System.out.println(question);
		List<Integer> numbers;

		try {
			numbers = Arrays.stream(Console.readLine().split(","))
				.map(num -> Integer.parseInt(num))
				.collect(Collectors.toList());
		} catch (NumberFormatException e) {
			System.out.println(ErrorType.INVALID_LOTTO_NUMBER.getErrorMessage());
			throw new IllegalArgumentException(ErrorType.INVALID_LOTTO_NUMBER.getErrorMessage());
		}

		return new Lotto(numbers);
	}

	public int getInputBonusNumber(String question) {
		System.out.println(question);

		try {
			return Integer.parseInt(Console.readLine());
		} catch (NumberFormatException e) {
			System.out.println(ErrorType.INVALID_BONUS_NUMBER.getErrorMessage());
			throw new IllegalArgumentException(ErrorType.INVALID_BONUS_NUMBER.getErrorMessage());
		}
	}

}
