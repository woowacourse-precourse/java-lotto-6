package lotto.controller;

import jdk.dynalink.beans.StaticClass;
import lotto.model.LottoGame;
import lotto.model.User;
import lotto.model.WinningLotto;
import lotto.utils.Calculator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Stack;

public class Controller {

    static LottoGame lottoGame = new LottoGame();
    Calculator calculator = new Calculator();
    public static void InitGame(){
        User user = lottoGame.InitUser();
        String[] numbers = InputView.validateInputNumbers();
        String bonusNumber = InputView.validateInputBonusNumber();
        WinningLotto winningLotto = new WinningLotto(numbers,bonusNumber);
        List<Integer> ranks = lottoGame.createRankList(user,winningLotto);
        user.setRank(ranks);
    }
}
