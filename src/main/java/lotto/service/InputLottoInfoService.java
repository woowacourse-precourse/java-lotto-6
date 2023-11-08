package lotto.service;

import java.util.List;

import lotto.domain.Lotto;


public class InputLottoInfoService {

	public Lotto inputLottoInfo() {
		List<Integer> lottoNumbersList = inputLottoNumbers();
		int bonusNumber = inputBonusNumber();
		return setLottoNumber(lottoNumbersList, bonusNumber);
		
	}
	public Lotto setLottoNumber(List<Integer> lottoNumbersList, int bonusNumber) {
		Lotto lotto = new Lotto(lottoNumbersList);
		lotto.setBonusNumber(bonusNumber);
		return lotto;
		
	}

}
