package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Seller;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    InputView inputView;
    OutputView outputView;
    Seller seller;
    public LottoService() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.seller = new Seller();
    }

    public List<Lotto> purchaseLotto() {
        boolean purchased = false;
        List<Lotto> lottos = new ArrayList<>();

        while (!purchased) {
            try {
                int payment = inputView.requestPurchaseOfLotto();
                lottos = seller.sellLotto(payment);
                purchased = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        outputView.printPurchasedLottos(lottos);
        return lottos;
    }

    public WinningLotto createWinningLotto() {
        List<Integer> winningLottoNumbers = inputView.requestWinningLottoNumbers();
        Lotto lotto = new Lotto(winningLottoNumbers);
        Integer bonusNumber = inputView.requestBonusNumber();
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

        return winningLotto;
    }
}
