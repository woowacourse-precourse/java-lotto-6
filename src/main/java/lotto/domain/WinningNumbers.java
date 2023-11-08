package lotto.domain;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.vo.LottoNumber;
import lotto.domain.vo.LottoNumbers;
import lotto.validation.Validator;
import lotto.validation.validators.InvalidBonusNumber;
import lotto.validation.validators.LottoGameValidator;

public class WinningNumbers {
	private final LottoNumber bonusNumber;
	private final LottoNumbers winningNumbers;

	public WinningNumbers(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
		validate(winningNumbers, bonusNumber);
		this.winningNumbers = winningNumbers;
		this.bonusNumber = bonusNumber;
	}

	public void setLottoResult(Lotto lotto) {
		IntStream.range(0, lotto.getLotto().size())
				.forEach(index -> {
					int matchAmount = matchWinningNumbers(lotto).get(index);
					boolean BonusStatus = matchBonusNumber(lotto).get(index);
					LottoResult.setResult(matchAmount, BonusStatus);
				});
	}

	private List<Integer> matchWinningNumbers(Lotto lotto) {
		return lotto.getLotto().stream()
				.mapToInt(this.winningNumbers::countMatchingNumber)
				.boxed()
				.toList();
	}

	private List<Boolean> matchBonusNumber(Lotto lotto) {
		return lotto.getLotto().stream()
				.map(lottoNumbers -> lottoNumbers.hasDuplicateValue(this.bonusNumber))
				.toList();
	}

	private void validate(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
		List<Object> target = List.of(winningNumbers, bonusNumber);
		Validator.of(new LottoGameValidator[]{
				new InvalidBonusNumber()
		}).validate(target);
	}
}
