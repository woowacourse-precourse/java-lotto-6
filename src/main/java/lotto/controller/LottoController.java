package lotto.controller;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.BuyerLotto;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoShop;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoShop lottoShop;

    public LottoController(LottoShop lottoShop) {
        this.lottoShop = lottoShop;
    }

    public void run() {
        BuyerLotto buyerLotto = createBuyerLotto();
        Lotto winningLottoNumber = createWinningNumber();
        BonusNumber bonusNumber = createBonusNumber();
        WinningLotto winningLotto = createWinningLotto(winningLottoNumber, bonusNumber);
        LottoResult lottoResult = winningLotto.calculateStatistics(buyerLotto);
        OutputView.printResult(lottoResult.getSortedStatistics());
        OutputView.printProfitPercent(lottoResult.calculateProfitPercent());
    }

    private BuyerLotto createBuyerLotto() {
        while (true) {
            try {
                OutputView.requestPurchaseAmount();
                int amount = InputView.readPurchaseAmount();
                List<Lotto> createBuyerLotto = lottoShop.createByBuyerLotto(amount);
                OutputView.printBuyerLotto(createBuyerLotto.size(), createBuyerLotto);
                return new BuyerLotto(createBuyerLotto);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lotto createWinningNumber() {
        while (true) {
            try {
                OutputView.requestWinnerLottoNumber();
                List<Integer> winningLotto = InputView.readWinnerLottoNumber();
                return lottoShop.createByWinningNumber(winningLotto);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private BonusNumber createBonusNumber() {
        while (true) {
            try {
                OutputView.requestBonusNumber();
                int bonusNumber = InputView.readBonusNumber();
                return lottoShop.createByBonusNumber(bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private WinningLotto createWinningLotto(Lotto winningLottoNumber, BonusNumber bonusNumber) {
        while (true) {
            try {
                winningLottoNumber.validateDuplicateWinningLottoNumberAndBonusNumber(bonusNumber);
                return lottoShop.createByWinningLotto(winningLottoNumber, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                bonusNumber = createBonusNumber();
            }
        }
    }
}
