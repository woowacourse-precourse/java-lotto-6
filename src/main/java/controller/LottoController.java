package controller;

import View.InputView;
import View.OuputView;
import domain.Amount;
import domain.Lottos;
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

        //createWinningNumbers
        //compareLottoNumbers
        //printResult
    }

}


