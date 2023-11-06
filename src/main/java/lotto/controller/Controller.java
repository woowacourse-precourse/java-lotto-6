package lotto.controller;

import java.util.List;
import lotto.view.BonusLottoInput;
import lotto.view.BuyLottoInput;
import lotto.view.LottosOutput;
import lotto.view.BonusLottoInput;
import lotto.view.WinningLottoInput;

public class Controller {

    public static void Run() {
        int tickets = BuyLottoInput.buyLottoInput();
        LottosOutput.lottosOutput(tickets);
        List<Integer> wins = WinningLottoInput.winnigLottoInput();
        int bonus = BonusLottoInput.bonusLottoInput(wins);
    }

}