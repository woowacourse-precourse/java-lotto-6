package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.service.CalculateLottoService;
import lotto.service.InputLottoInfoService;
import lotto.service.InputUserInfoService;

public class LottoController {
	private final InputUserInfoService inputUserInfoService = new InputUserInfoService();  
	private final InputLottoInfoService inputLottoInfoService = new InputLottoInfoService();  
	private final CalculateLottoService calculateLottoService = new CalculateLottoService();  
	
	public void startLotto() {
		User user = setUserInfo();
		Lotto lotto = setLottoInfo();
		calculatingWinningLotto(user, lotto);
	}
	public User setUserInfo() {
		return inputUserInfoService.inputUserInfo();
	}
	public Lotto setLottoInfo() {
		return inputLottoInfoService.inputLottoInfo();
	}
	public void calculatingWinningLotto(User user, Lotto lotto) {
		calculateLottoService.calculatingWinning(user, lotto);
	}
}
