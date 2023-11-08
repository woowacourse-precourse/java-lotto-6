package lotto.controller;

import lotto.model.*;
import lotto.util.ConvertUtil;
import lotto.util.LottoNumberGenerator;
import lotto.util.NumberGenrator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final NumberGenrator lottoNumberGenerator = new LottoNumberGenerator();

    public void start() {
        PurchaseAmount purchaseAmount = getPurchaseAmount();
        Lottos lottos = new Lottos(createLotto(purchaseAmount.getLottoCount()));
        WinningNumber winningNumber = getWinningNumber();
        BonusNumber bonusNumber = getBonusNumber();
    }

    private List<Lotto> createLotto(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(lottoNumberGenerator.generate());
            outputView.printLottoNumber(lotto.getNumbers());
            lottos.add(lotto);
        }
        return lottos;
    }

    private PurchaseAmount getPurchaseAmount() {
        outputView.printPurchaseAmountInputMessage();
        return new PurchaseAmount(inputView.readPurchaseAmount());
    }

    private WinningNumber getWinningNumber() {
        outputView.printWinningNumbersInputMessage();
        return new WinningNumber(inputView.readWinningNumber());
    }

    private BonusNumber getBonusNumber() {
        outputView.printBonusNumberInputMessage();
        return new BonusNumber(inputView.readBonusNumber());
    }
}
