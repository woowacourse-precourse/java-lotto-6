package lotto.validation.validators;

import java.util.List;
import lotto.domain.vo.LottoNumber;
import lotto.domain.vo.LottoNumbers;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public class InvalidBonusNumber implements LottoGameValidator<List<Object>> {
	@Override
	public void validate(List<Object> value) {
		if (checkDuplicate(value)) {
			throw new LottoException(ErrorMessage.INVALID_BONUS_NUMBER);
		}
	}

	private boolean checkDuplicate(List<Object> value) {
		LottoNumbers winningNumbers = (LottoNumbers) value.get(0);
		LottoNumber bonusNumber = (LottoNumber) value.get(1);
		return winningNumbers.hasDuplicateValue(bonusNumber);
	}
}
