package lotto.controller;

import lotto.model.LottoGame;
import lotto.model.User;
import lotto.view.OutputView;

public class Controller {

    static LottoGame lottoGame = new LottoGame();
    public static void InitGame(){
        User user = lottoGame.InitUser();
    }
}
