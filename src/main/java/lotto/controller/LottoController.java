package lotto.controller;

import lotto.domain.LottoStore;
import lotto.domain.User;
import lotto.ui.InputView;

import java.util.List;

public class LottoController {

    private User user;
    private LottoStore lottoStore;

    private List<Integer> winningNumbers;
    private int bonusNumber;

    private LottoController(User user, LottoStore lottoStore) {
        this.user = user;
        this.lottoStore = lottoStore;
        runLottoGame();
    }
    public static LottoController startProgram(){
        return new LottoController(User.buyLotto(),new LottoStore());
    }

    public void runLottoGame(){
        winningNumbers = InputView.inputWinningNumbers();
        bonusNumber = InputView.inputBonusNumbers();
    }




}


















