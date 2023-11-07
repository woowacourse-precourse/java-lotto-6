package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.service.LottoResultService;
import lotto.service.UserLottoService;
import lotto.service.WinningLottoService;


public class LottoController {

    private final LottoResultService lottoResultService = new LottoResultService();
    private final UserLottoService userLottoService = new UserLottoService();
    private final WinningLottoService winningLottoService = new WinningLottoService();

    public void start() {
        User user = setUserData();
        Lotto lotto = setLottoData();
        calculateLottoWinning(user, lotto);
    }

    public User setUserData() {
        return userLottoService.inputUserData();
    }

    public Lotto setLottoData() {
        return winningLottoService.inputLottoData();
    }

    public void calculateLottoWinning(User user, Lotto lotto) {
        lottoResultService.lottoResult(user, lotto);
    }
}
