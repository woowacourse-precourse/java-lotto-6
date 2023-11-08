package lotto.controller.validation.lotto;

import static lotto.model.constant.IntegerSymbolicConstantEnum.MAX_SIZE_FOR_LOTTO_NUMBERS;

import java.util.List;

public class LottoNumberCountChecker {

	public void checkLottoNumberCount(List<Integer> lottoNumberStringList) {
		if (lottoNumberStringList.size() != MAX_SIZE_FOR_LOTTO_NUMBERS.getValue()) {
			throw new IllegalArgumentException();
		}
	}
}
