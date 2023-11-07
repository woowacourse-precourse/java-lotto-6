package controller;

import View.InputView;
import View.OuputView;
import domain.Amount;
import domain.BonusNumber;
import domain.Lotto;
import domain.Lottos;
import domain.Rank;
import domain.WinningNumbers;
import service.CompareLottoServcie;
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
        InputView.bonusNumberMessage();
        BonusNumber bonusNumber = UserInputService.bonusNumber(lotto);
        WinningNumbers winningNumbers = MakeObjectService.winningNumbers(lotto, bonusNumber);

        //compareLottoNumbers
        Rank rank = CompareLottoServcie.rank(amount, lottos, winningNumbers);

        //printResult
        OuputView.lottosResult(amount, rank);
    }

}


