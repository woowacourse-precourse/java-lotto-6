package lotto.controller;

import lotto.model.LottoGame;
import lotto.model.User;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Controller {
    public static void initGame() {
        User user = LottoGame.InitUser();
        String[] numbers = InputView.validateInputNumbers();
        String bonusNumber = InputView.validateInputBonusNumber();
        WinningLotto winningLotto = new WinningLotto(numbers, bonusNumber);
        List<Integer> ranks = LottoGame.createRankList(user, winningLotto);
        user.setRank(ranks);
        OutputView.displayResult(user);
    }
}
