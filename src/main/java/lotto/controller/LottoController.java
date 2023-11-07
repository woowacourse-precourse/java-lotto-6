package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    public PurchaseAmount payMoney() {
        int money = 0;
        try {
            money = InputView.inputPurchaseAmount();
            return new PurchaseAmount(money);
        } catch(IllegalArgumentException e) {
            System.out.println("");
            return payMoney();
        }

    }

    public WinningLotto selectWinningLottoNumbers() {
        try {
            List<Integer> winningSixNumbers = InputView.inputWinnerNumbers();
            int winningBonusNumbers = InputView.inputBonusNumbers();
            return new WinningLotto(new Lotto(winningSixNumbers), winningBonusNumbers);
        } catch(IllegalArgumentException e) {
            System.out.println("");
            return selectWinningLottoNumbers();
        }
    }

    public List<Lotto> issueLottoList(PurchaseAmount purchaseAmount) {
        List<Lotto> lottoList = new ArrayList<>();
        int lottoCount = purchaseAmount.getLottoCount();
        OutputView.outputLottoCount(lottoCount);
        for (int i=0; i<lottoCount; i++) {
            Lotto lotto = new Lotto();
            OutputView.outputIssuedLotto(lotto);
            lottoList.add(lotto);
        }
        return lottoList;
    }

}
