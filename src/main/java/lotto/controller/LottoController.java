package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.io.LineNumberReader;
import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    private final LottoMachine lottoMachine;

    public LottoController(LottoMachine lottoMachine) {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoMachine = lottoMachine;
    }

    public void startGame() {

        Money purchaseMoney = getMoney();
        outputView.printInputMessage();

        List<Lotto> lottoBundle = lottoMachine.buyLotto(purchaseMoney);

        outputView.printIssuedLottoCount(lottoBundle);
        outputView.printIssuedLottoBundle(lottoBundle);

        WinLotto winLotto = getWinLotto();

        Result lottoResult = new Result(lottoBundle, winLotto);
        Double earningRatio = lottoResult.calculateEarningRatio(purchaseMoney);
        printLottoResult(lottoResult, earningRatio);
    }

    private Money getMoney() {
        return inputView.readPurchaceMoney();
    }

    private void printIssuedLotto(List<Lotto> lottoBundle) {
        outputView.printIssuedLottoCount(lottoBundle);
        outputView.printIssuedLottoBundle(lottoBundle);
    }

    private WinLotto getWinLotto() {
        List<Integer> winLottoNumbers = inputView.readWinLottoNumbers();
        Integer winLottoBonus = inputView.readWinLottoBonusNumber();

        return new WinLotto(winLottoNumbers, winLottoBonus);
    }

    private void printLottoResult(Result lottoResult, Double earningRatio) {
        outputView.printLottoResult(lottoResult, earningRatio);
    }
}
