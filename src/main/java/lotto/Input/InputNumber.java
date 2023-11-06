package lotto.Input;

import java.util.List;

import lotto.dataObjects.Lotto;

public interface InputNumber {

	int inputPurchasePrice();

	void inputWinningNumbers(List<Integer> lottoNumbers);

	void inputBonusNumber();

}
