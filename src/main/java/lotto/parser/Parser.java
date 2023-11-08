package lotto.parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.exception.InputViewExceptionMessage.WRONG_NUMBER_FORMAT;
import static lotto.util.CharacterUnits.SEPARATOR;

public class Parser {

	public static List<Integer> parseNumbers(final String input) {
		List<String> numberDummy = parseSeparator(input);
		return parseNumberDummy(numberDummy);
	}


	public static List<String> parseSeparator(final String input) {
		return Arrays.stream(input
				.split(SEPARATOR.getUnit()))
			.toList();
	}

	public static List<Integer> parseNumberDummy(final List<String> numberDummy) {
		return numberDummy.stream()
			.map(Parser::parseNumber)
			.collect(Collectors.toList());
	}


	public static Integer parseNumber(final String input) {
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(WRONG_NUMBER_FORMAT.getMessage());
		}
	}

}
