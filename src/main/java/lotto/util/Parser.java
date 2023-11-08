package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.vo.LottoNumbers;
import lotto.validation.Validator;
import lotto.validation.validators.EmptyInput;
import lotto.validation.validators.LottoGameValidator;
import lotto.validation.validators.NonIntegerInput;
import lotto.validation.validators.WinningNumbersFormat;

public class Parser {
	public static List<Integer> parseWinningNumber(final String input) {
		Validator.of(new LottoGameValidator[]{
				new EmptyInput(),
				new WinningNumbersFormat()
		}).validate(input);

		List<Integer> winningNumbers = Arrays.stream(input.split(","))
				.mapToInt(Integer::parseInt)
				.boxed()
				.toList();
		return winningNumbers;
	}

	public static int parseInteger(final String input) {
		Validator.of(new LottoGameValidator[]{
				new EmptyInput(),
				new NonIntegerInput()
		}).validate(input);
		return Integer.parseInt(input);
	}

	public static String parseLottoNumbers(final Lotto lotto) {
		return lotto.getLotto().stream()
				.map(LottoNumbers::getLottoNumbers)
				.map(Parser::ascendingList)
				.map(String::valueOf)
				.collect(Collectors.joining("\n"));
	}

	private static List<Integer> ascendingList(List<Integer> lottoNumbers) {
		return lottoNumbers.stream()
				.sorted()
				.toList();
	}
}
