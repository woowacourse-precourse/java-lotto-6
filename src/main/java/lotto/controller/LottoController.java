package lotto.controller;

import java.util.List;
import lotto.domain.LottoList;
import lotto.domain.LottoMaker;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void playLotto() {
        long purchaseAmount = inputView.getPurchaseAmount();
        LottoList lottoList = new LottoList(LottoMaker.makeLottoList(purchaseAmount));
        outputView.printLottoList(lottoList);

        List<Integer> winningNumber = inputView.getWinningNumbers();
        int bonusNumber = inputView.getBonusNumber(winningNumber);
        WinningNumbers winningNumbers = new WinningNumbers(winningNumber, bonusNumber);
        outputView.printTotalResult(lottoList.getLottoResult(winningNumbers).toString());
    }
}
