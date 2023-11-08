package lotto.controller.validation.lotto;

import static lotto.model.constant.IntegerSymbolicConstantEnum.END_OF_COUNT;
import static lotto.model.constant.IntegerSymbolicConstantEnum.FREQUENCY_MAX_VALUE;
import static lotto.model.constant.IntegerSymbolicConstantEnum.INDEX_PIVOT_STEP;

import java.util.Collections;
import java.util.List;

public class LottoNumberDuplicationChecker {
	public void checkLottoNumberDuplication(List<Integer> lottoNumberList, int counterForIterate) {
		Integer comparingFocusedLottoNumberString = lottoNumberList.get(counterForIterate);
		if (FREQUENCY_MAX_VALUE.getValue() < Collections.frequency(lottoNumberList, comparingFocusedLottoNumberString)){
			throw new IllegalArgumentException();
		}
		if (counterForIterate == END_OF_COUNT.getValue()){
			return ;
		}
		checkLottoNumberDuplication(lottoNumberList, counterForIterate - INDEX_PIVOT_STEP.getValue());
	}
}
