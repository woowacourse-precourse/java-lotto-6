package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.service.LottoCalculateService;
import lotto.service.LottoInputDataService;
import lotto.service.UserInputDataService;

public class LottoController {
    private final LottoCalculateService lottoCalculateService = new LottoCalculateService();
    private final LottoInputDataService lottoInputDataService = new LottoInputDataService();
    private final UserInputDataService userInputDataService = new UserInputDataService();

    public void start() {
        User user = setUserData();
        Lotto lotto = setLottoData();
        calculateLottoWinning(user, lotto);
    }
}
