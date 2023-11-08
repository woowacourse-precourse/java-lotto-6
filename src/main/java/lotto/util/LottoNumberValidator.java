package lotto.util;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LottoNumberValidator {
	public void validateLottoNumber(String input) {
		validateInteger(input);
		validateNumberCount(input);
		validateNumberRange(input);
		validateDuplicatedNumber(input);
	}

	private void validateNumberCount(String input) {
		if (input.split(",").length != Constant.LOTTO_SIZE) {
			throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUM_SIZE_MESSAGE);
		}
	}

	private void validateNumberRange(String input) {
		for (String number : input.split(",")) {
			if (Integer.parseInt(number) < Constant.LOTTO_MIN_NUMBER || Integer.parseInt(number) > Constant.LOTTO_MAX_NUMBER) {
				throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUM_OUT_OF_RANGE_MESSAGE);
			}
		}
	}

	private void validateDuplicatedNumber(String input) {
		int inputNumberCount = input.split(",").length;
		int inputNumberSetCount = Arrays.stream(input.split(","))
				.collect(Collectors.toSet())
				.size();
		if (inputNumberCount != inputNumberSetCount) {
			throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUM_DUPLICATED_MESSAGE);
		}
	}

	private void validateInteger(String input) {
		String[] numbers = input.split(",");
		try {
			for (String number : numbers) {
				Integer.parseInt(number);
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUM_NOT_INTEGER_MESSAGE);
		}
	}
}
