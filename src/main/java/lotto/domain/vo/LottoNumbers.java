package lotto.domain.vo;

import java.util.List;
import lotto.domain.constant.LottoValue;
import lotto.validation.Validator;
import lotto.validation.validators.DuplicateNumber;
import lotto.validation.validators.LottoGameValidator;
import lotto.validation.validators.WinningNumbersSize;
import util.RandomNumberGenerator;

public class LottoNumbers extends LottoValue {
	private final List<LottoNumber> lottoNumbers;

	RandomNumberGenerator randomNumber = new RandomNumberGenerator(
			MINIMUM_INCLUSIVE_NUMBER,
			MAXIMUM_INCLUSIVE_NUMBER,
			WINNING_NUMBER_AMOUNT
	);

	public LottoNumbers(int intStream) {
		this.lottoNumbers = generateLottoNumbers(randomNumber.generate());
	}

	public LottoNumbers(List<Integer> inputValue) {
		Validator.of(new LottoGameValidator[]{
				new WinningNumbersSize(),
				new DuplicateNumber()
		}).validate(inputValue);
		this.lottoNumbers = generateLottoNumbers(inputValue);
	}

	public List<Integer> getLottoNumbers() {
		return this.lottoNumbers.stream()
				.map(LottoNumber::getNumber)
				.toList();
	}

	public int countMatchingNumber(LottoNumbers target) {
		return (int) this.lottoNumbers.stream()
				.filter(target::hasDuplicateValue)
				.count();
	}

	public boolean hasDuplicateValue(LottoNumber lottoNumber) {
		return this.lottoNumbers.contains(lottoNumber);
	}

	private List<LottoNumber> generateLottoNumbers(List<Integer> numbers) {
		return numbers.stream()
				.map(LottoNumber::valueOf)
				.toList();
	}
}
