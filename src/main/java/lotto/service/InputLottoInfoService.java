package lotto.service;

import java.util.List;

import lotto.Lotto;

public class InputLottoInfoService {

	public Lotto inputLottoInfo() {
		List<Integer> lottoNumbersList = inputLottoNumbers();
		int bonusNumber = inputBonusNumber();
		return setLotto(lottoNumbersList, bonusNumber);
		
	}
	public Lotto setLotto(List<Integer> lottoNumbersList, int bonusNumber) {
		Lotto lotto = new Lotto(lottoNumbers);
		
	}

}
