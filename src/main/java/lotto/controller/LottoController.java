package lotto.controller;

import lotto.model.domain.*;
import lotto.model.service.LottoService;
import lotto.model.service.UserService;
import lotto.view.InputView;
import lotto.view.OutputView;


public class LottoController {
    LottoService lottoService = new LottoService();
    UserService userService = new UserService();
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    public void game() {
        OutputView.printStartMessage();
        User user = userService.setUserInfo();

        outputView.printPurchaseMesssage(user.getHavingLottosCount());
        Lottos lottos = lottoService.makeLottoAndLottos(user);

        outputView.printPurchasedLottoList(lottos);

        OutputView.printInputWinnerNumMessage();
        WinningNum winningNum = new WinningNum(inputView.readWinningNum());

        OutputView.printInputBonusNumMessasge();
        BonusNum bonusNum = new BonusNum(inputView.readBonusNum());

        for (Lotto lotto : lottos.getLottos()) {
            int identifyNum = lottoService.makeIdentifyNum(lotto, winningNum, bonusNum);
            userService.updateUserRank(user,identifyNum);
        }

        outputView.printResult(user);
        outputView.printProfitRate(user, userService.calcutateProfitRate(user));
    }
}
