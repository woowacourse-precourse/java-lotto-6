package lotto.controller.validation.lotto;

import static lotto.model.constant.IntegerSymbolicConstantEnum.END_OF_COUNT;
import static lotto.model.constant.IntegerSymbolicConstantEnum.INDEX_PIVOT_STEP;
import static lotto.model.constant.IntegerSymbolicConstantEnum.MAX_NUMBER_FOR_LOTTO_NUMBERS;
import static lotto.model.constant.IntegerSymbolicConstantEnum.MIN_NUMBER_FOR_LOTTO_NUMBERS;

import java.util.List;

public class LottoNumberRangeChecker {
	Integer minValue = MIN_NUMBER_FOR_LOTTO_NUMBERS.getValue();
	Integer maxValue = MAX_NUMBER_FOR_LOTTO_NUMBERS.getValue();

	public void checkLottoNumberRange(List<Integer> lottoNumberList, int counterForIterate) {
		if (lottoNumberList.get(counterForIterate)< minValue){
			throw new IllegalArgumentException();
		}
		if (lottoNumberList.get(counterForIterate) > maxValue){
			throw new IllegalArgumentException();
		}
		if (counterForIterate == END_OF_COUNT.getValue()){
			return ;
		}
		checkLottoNumberRange(lottoNumberList, counterForIterate- INDEX_PIVOT_STEP.getValue());
	}
}
