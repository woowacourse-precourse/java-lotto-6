package lotto.service;

import java.util.List;

import lotto.domain.Lotto;
import lotto.util.LottoUtil;
import lotto.view.InputView;
import lotto.view.OutputView;

public class InputLottoInfoService {
	private OutputView outputView = new OutputView();
	private InputView inputView = new InputView();
	private LottoUtil lottoUtil= new LottoUtil();

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
		List<Integer> lottoNumbers = lottoUtil.lottoNumberParser(inputView.inputLottoNumbers());
		return lottoNumbers;
	}

    public int inputBonusNumber() {
        outputView.printAskingBonusNumber();
        int bonusNumber = lottoUtil.bonusNumberParser(inputView.inputBonusNumber());
        return bonusNumber;
    }
    
}
