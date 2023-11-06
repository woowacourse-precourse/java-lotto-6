package controller;

import View.InputView;
import View.OuputView;
import domain.Amount;
import domain.Lotto;
import domain.Lottos;
import domain.WinningNumbers;
import service.MakeObjectService;
import service.UserInputService;

public class LottoController {

    public void run() {
        //buyLotto
        InputView.buyMessage();
        Amount amount = MakeObjectService.amount(UserInputService.amount());
        OuputView.buyMessage(amount);

        //createLottos
        Lottos lottos = MakeObjectService.lottos(amount);
        OuputView.lottosNumbers(lottos);

        //createWinningNumbers
        InputView.winningNumbersMessage();
        Lotto lotto = UserInputService.lotto();

        //compareLottoNumbers
        //printResult
    }

}


