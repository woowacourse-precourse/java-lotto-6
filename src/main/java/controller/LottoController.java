package controller;

import View.InputView;
import View.OuputView;
import domain.Lottos;
import service.MakeObjectService;
import service.UserInputService;

public class LottoController {

    Lottos lottos;

    public void run() {
        //buyLotto
        InputView.buyMessage();
        lottos = MakeObjectService.lottos(UserInputService.amount());
        OuputView.buyMessage(lottos);

        //createLotto
        //createWinningNumbers
        //compareLottoNumbers
        //printResult
    }

}


