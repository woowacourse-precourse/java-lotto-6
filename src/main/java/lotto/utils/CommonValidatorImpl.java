package lotto.utils;

import java.util.List;
import java.util.StringTokenizer;

import lotto.enumContainer.ErrorOperation;
import lotto.enumContainer.RelateToLotto;

//공통 검증 기능 클래스
public class CommonValidatorImpl implements CommonValidator {

	private final ParserFromString parser;

	public CommonValidatorImpl() {
		this.parser = new ParserFromStringImpl();
	}

	@Override
	public int validatePrice(String lottoPrice) {
		validateEmptyString(lottoPrice);
		validateIsDigit(lottoPrice);
		int parsePrice = validateRange(lottoPrice);
		validateNatural(parsePrice);
		return parsePrice;
	}

	@Override
	public void validateWinningNumber(StringTokenizer numberSplitter, List<Integer> lottoNumbers) {
		validateTokenizer(numberSplitter.countTokens());
		while(numberSplitter.hasMoreTokens()) {
			String lottoNumber = numberSplitter.nextToken();
			validateIsDigit(lottoNumber);
			int parseNumber = validateLottoRange(lottoNumber);
			lottoNumbers.add(parseNumber);
		}
	}

	public void validateTokenizer(int count) {
		if (count == 0) {
			ErrorOperation.EMPTY_ERROR.apply();
		}
	}

	@Override
	public int validateBonusNumber(String bonusNumber) {
		validateEmptyString(bonusNumber);
		validateIsDigit(bonusNumber);
		return validateLottoRange(bonusNumber);
	}

	private void validateEmptyString(String number) {
		if (number.isEmpty()) {
			ErrorOperation.EMPTY_ERROR.apply();
		}
	}

	private void validateNatural(int number) {
		if (number <= 0) {
			ErrorOperation.UNDER_ERROR.apply();
		}
	}

	private void validateIsDigit(String number) {
		int startIndex = 0;
		if (containDash(number)) {
			startIndex = 1;
		}
		for (int order = startIndex; order < number.length(); order++) {
			char digit = parser.toCharacterParser(number, order);
			if (!Character.isDigit(digit)) {
				ErrorOperation.DIGIT_ERROR.apply();
			}
		}
	}

	private boolean containDash(String number) {
		char firstWord = parser.toCharacterParser(number, 0);
		return (number.length() > 1 && firstWord == '-');
	}

	private int validateLottoRange(String number) {
		int parseNumber = validateRange(number);
		if (parseNumber < RelateToLotto.START.number()) {
			ErrorOperation.UNDER_ERROR.apply();
		}
		if (parseNumber > RelateToLotto.END.number()) {
			ErrorOperation.OVER_ERROR.apply();
		}
		return parseNumber;
	}

	private int validateRange(String number) {
		int parsePrice = 0;
		try {
			parsePrice = parser.toIntPaser(number);
		} catch (NumberFormatException e) {
			ErrorOperation.RANGE_ERROR.apply();
		}
		return parsePrice;
	}
}
