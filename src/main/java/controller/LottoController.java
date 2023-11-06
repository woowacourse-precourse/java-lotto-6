package controller;

import View.InputView;
import View.OuputView;
import domain.Lottos;
import service.MakeObjectService;
import service.UserInputService;
import service.ValidationService;

public class LottoController {

    Lottos lottos;

    public void run() {
        //buyLotto
        InputView.buyMessage();
        lottos = MakeObjectService.lottos(ValidationService.amount(UserInputService.run()));
        OuputView.buyMessage(lottos);

        //createLotto
        //createWinningNumbers
        //compareLottoNumbers
        //printResult
    }

}
