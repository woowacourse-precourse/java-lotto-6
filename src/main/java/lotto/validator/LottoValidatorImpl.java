package lotto.validator;

import java.util.StringTokenizer;

import lotto.enumContainer.ErrorOperation;
import lotto.utils.ParserFromString;
import lotto.utils.ParserFromStringImpl;

public class LottoValidatorImpl implements LottoValidator {

	private ParserFromString parser;
	public LottoValidatorImpl() {
		parser = new ParserFromStringImpl();
	}

	@Override
	public int validatePrice(String price) {
		validateEmptyString(price);
		validateIsDigit(price);
		int parsePrice = validateRange(price);
		validateRest(parsePrice);
		return parsePrice;
	}

	@Override
	public void validateWinningNumber(StringTokenizer numberSplitter) {
		for (int i = 0; i < numberSplitter.countTokens(); i++) {
			String lottoNumber = numberSplitter.nextToken();
			validateEmptyString(lottoNumber);
			validateIsDigit(lottoNumber);
			validatelottoRange(lottoNumber);
		}
	}

	private void validatelottoRange(String lottoNumber) {

	}

	private void validateEmptyString(String price) {
		if (price.isEmpty()) {
			ErrorOperation.EMPTY_ERROR.apply();
		}
	}

	private void validateIsDigit(String price) {
		for (int i = 0; i < price.length(); i++) {
			char digit = price.charAt(i);
			if (!Character.isDigit(digit)) {
				ErrorOperation.DIGIT_ERROR.apply();
			}
		}
	}

	private int validateRange(String price) {
		int parsePrice = 0;
		try {
			parsePrice = Integer.parseInt(price);
		} catch (NumberFormatException e) {
			ErrorOperation.RANGE_ERROR.apply();
		}
		return validateMinimum(parsePrice);
	}

	private int validateMinimum(int parsePrice) {
		if (parsePrice < 1000) {
			ErrorOperation.MINIMUM_ERROR.apply();
		}
		return parsePrice;
	}

	private void validateRest(int parsePrice) {
		if (parsePrice % 1000 != 0) {
			ErrorOperation.UNIT_ERROR.apply();
		}
	}
}
