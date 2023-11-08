package lotto.service;

import java.util.List;

import lotto.domain.Lotto;
import lotto.view.OutputView;


public class InputLottoInfoService {
	private OutputView outputView = new OutputView();

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
	
	public List<Integer> inputLottoNumbers(){
		outputView.printAskingLottoNumbers();
		List<Integer> lottoNumbers = lottoUtil();
		return lottoNumbers;
	}

}
