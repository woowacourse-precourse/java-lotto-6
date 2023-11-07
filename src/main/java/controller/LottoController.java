package controller;

import View.InputView;
import View.OutputView;
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
        Amount amount = buyLotto();
        Lottos lottos = createLottos(amount);
        WinningNumbers winningNumbers = createWinningNumbers();
        Rank rank = CompareLottoServcie.calculateRank(amount, lottos, winningNumbers);
        OutputView.lottosResult(amount, rank);
    }

    private Amount buyLotto() {
        InputView.buyMessage();
        Amount amount = UserInputService.amount();
        OutputView.buyMessage(amount);

        return amount;
    }

    private Lottos createLottos(Amount amount) {
        Lottos lottos = MakeObjectService.lottos(amount);
        OutputView.lottosNumbers(lottos);

        return lottos;
    }

    private WinningNumbers createWinningNumbers() {
        InputView.winningNumbersMessage();
        Lotto lotto = UserInputService.lotto();
        InputView.bonusNumberMessage();
        BonusNumber bonusNumber = UserInputService.bonusNumber(lotto);

        return MakeObjectService.winningNumbers(lotto, bonusNumber);
    }

}


