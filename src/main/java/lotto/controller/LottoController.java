package lotto.controller;

import lotto.Lotto;
import lotto.domain.User;
import lotto.service.CalculateLottoService;
import lotto.service.InputLottoInfoService;
import lotto.service.InputUserInfoService;

public class LottoController {
	public void startLotto() {
		User user = setUserInfo();
		Lotto lotto = setLottoInfo();
		calculatingWinningLotto(user, lotto);
	}
	public User setUserInfo() {
		return InputUserInfoService.inputUserInfo();
	}
	public Lotto setLottoInfo() {
		return InputLottoInfoService.inputLottoInfo();
	}
	public void calculatingWinningLotto(User user, Lotto lotto) {
		CalculateLottoService.calculatingWinning(user, lotto);
	}
}
