package lotto.domain;

import java.util.List;

import lotto.util.InputLottoException;
import lotto.view.InputView;

public class Lotto {
	private List<Integer> lottoNumbers;
	public InputView inputView;
	public InputLottoException inputLottoException;
	private final static int BONUS_NUMBER_INDEX =6;
	
	public Lotto(List<Integer> lottoNumbers) {
		validateLottoNumbers(lottoNumbers);
		this.lottoNumbers = lottoNumbers;
	}
	public void setBonusNumber(int inputBonusNumber) {
		inputLottoException.validateInputBonusNumbers(lottoNumbers, inputBonusNumber);
		lottoNumbers.add(inputBonusNumber);
	}
	public void validateLottoNumbers(List<Integer> lottoNumbers) {
		
	}
	public List<Integer> getLottoNumbers(){
		return lottoNumbers;
	}
	
	public int getBonusNumber() {
		return lottoNumbers.get(BONUS_NUMBER_INDEX);
	}
}
