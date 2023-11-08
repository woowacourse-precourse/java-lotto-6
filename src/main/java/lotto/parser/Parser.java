package lotto.parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static lotto.exception.InputViewExceptionMessage.WRONG_NUMBER_FORMAT;
import static lotto.util.CharacterUnits.SEPARATOR;

public class Parser {

	public static List<Integer> parseNumbers(String input) {
		List<String> numberDummy = parseSeparator(input);
		return parseNumberDummy(numberDummy);
	}


	public static List<String> parseSeparator(String input) {
		return Arrays.stream(input
				.split(SEPARATOR.getUnit()))
			.toList();
	}

	public static List<Integer> parseNumberDummy(List<String> numberDummy) {
		return numberDummy.stream()
			.map(Parser::parseInt)
			.collect(Collectors.toList());
	}


	public static Integer parseInt(String input) {
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(WRONG_NUMBER_FORMAT.getMessage());
		}
	}

}
