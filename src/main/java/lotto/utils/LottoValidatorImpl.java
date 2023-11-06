package lotto.utils;

import java.util.List;
import java.util.StringTokenizer;

import lotto.enumContainer.ErrorOperation;
import lotto.enumContainer.LottoRange;

public class LottoValidatorImpl implements LottoValidator {

	private final ParserFromString parser;
	public LottoValidatorImpl() {
		parser = new ParserFromStringImpl();
	}

	@Override
	public int validatePrice(String lottoPrice) {
		validateEmptyString(lottoPrice);
		validateIsDigit(lottoPrice);
		return validateRange(lottoPrice);
	}

	@Override
	public void validateWinningNumber(StringTokenizer numberSplitter, List<Integer> lottoNumbers) {
		while(numberSplitter.hasMoreTokens()) {
			String lottoNumber = numberSplitter.nextToken();
			validateIsDigit(lottoNumber);
			int parseNumber = validateLottoRange(lottoNumber);
			lottoNumbers.add(parseNumber);
		}
	}

	@Override
	public int validateBonusNumber(String bonusNumber) {
		validateIsDigit(bonusNumber);
		return validateLottoRange(bonusNumber);
	}

	private int validateLottoRange(String lottoNumber) {
		int parseNumber = validateRange(lottoNumber);
		if (parseNumber < LottoRange.START.range()) {
			ErrorOperation.UNDER_ERROR.apply();
		}
		if (parseNumber > LottoRange.END.range()) {
			ErrorOperation.OVER_ERROR.apply();
		}
		return parseNumber;
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
		return parsePrice;
	}
}
