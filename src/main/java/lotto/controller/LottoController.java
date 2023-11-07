package lotto.controller;

import lotto.domain.*;
import lotto.util.LottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private Amount amount;
    private WinningLotto winningLotto;
    private BonusLotto bonusLotto;

    public void run() {
        getLottoMoney();
        printLottoList();
        winningLotto();
        bonusLotto();
    }

    private void getLottoMoney() {
        OutputView.printPurchaseAmount();
        int purchaseAmount = InputView.readPurchaseAmount();
        amount = new Amount(purchaseAmount);
    }

    private void printLottoList() {
        int count = amount.getCount();
        OutputView.printPurchaseCount(count);
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        Lottos lottoContainer = new Lottos(new ArrayList<>());
        for(int i = 0; i  < count; i++){
            Lotto lotto = new Lotto(lottoNumberGenerator.generate());
            lottoContainer.addLotto(lotto);
            OutputView.printBoughtLottoNumbers(lotto.getNumbers());
        }
        System.out.println(lottoContainer.size());
    }

    private void winningLotto() {
        OutputView.printWinningNumbers();
        List<Integer> winningNumbers = InputView.readWinningNumbers();
        winningLotto = new WinningLotto(winningNumbers);
    }

    private void bonusLotto() {
        OutputView.printBonusNumber();
        int bonusNumber = InputView.readBonusNumber();
        bonusLotto = new BonusLotto(bonusNumber);

    }
}
