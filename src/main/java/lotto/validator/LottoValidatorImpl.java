package lotto.validator;

import java.util.StringTokenizer;

import lotto.Lotto;
import lotto.enumContainer.ErrorOperation;
import lotto.enumContainer.LottoRange;
import lotto.utils.ParserFromString;
import lotto.utils.ParserFromStringImpl;

public class LottoValidatorImpl implements LottoValidator {

	private final ParserFromString parser;
	public LottoValidatorImpl() {
		parser = new ParserFromStringImpl();
	}

	@Override
	public void validatePrice(String lottoPrice) {
		validateEmptyString(lottoPrice);
		validateIsDigit(lottoPrice);
		int parsePrice = validateRange(lottoPrice);
		validateRest(parsePrice);
	}

	@Override
	public void validateWinningNumber(StringTokenizer numberSplitter, Lotto lotto) {
		validateCountOfTokens(numberSplitter.countTokens());
		for (int i = 0; i < numberSplitter.countTokens(); i++) {
			String lottoNumber = numberSplitter.nextToken();
			validateIsDigit(lottoNumber);
			int parseNumber = validatelottoRange(lottoNumber);
			lotto.pushIntoCollection(parseNumber);
		}
	}

	@Override
	public void validateBonusNumber(String bonusNumber) {
		validateIsDigit(bonusNumber);
		int parseNumber = validatelottoRange(bonusNumber);
	}

	private int validatelottoRange(String lottoNumber) {
		int parseNumber = parser.toIntPaser(lottoNumber);
		if (parseNumber < LottoRange.START.range()) {
			ErrorOperation.UNDER_ERROR.apply();
		}
		if (parseNumber > LottoRange.END.range()) {
			ErrorOperation.OVER_ERROR.apply();
		}
		return parseNumber;
	}

	private void validateCountOfTokens(int numberOfTokens) {
		if (numberOfTokens != 6) {
			ErrorOperation.TOKEN_NUMBER_ERROR.apply();
		}
	}

	private void validateEmptyString(String lottoPrice) {
		if (lottoPrice.isEmpty()) {
			ErrorOperation.EMPTY_ERROR.apply();
		}
	}

	private void validateIsDigit(String lottoPrice) {
		for (int i = 0; i < lottoPrice.length(); i++) {
			char digit = parser.toCharacterParser(lottoPrice, i);
			if (!Character.isDigit(digit)) {
				ErrorOperation.DIGIT_ERROR.apply();
			}
		}
	}

	private int validateRange(String lottoPrice) {
		int parsePrice = 0;
		try {
			parsePrice = parser.toIntPaser(lottoPrice);
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
