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
        WinningLotto winningLotto = createWinningLotto();
        LottoResult lottoResult = winningLotto.calculateStatistics(buyerLotto);
        OutputView.printResult(lottoResult.getSortedStatistics());
        OutputView.printProfitPercent(lottoResult.calculatePercent());
    }

    private BuyerLotto createBuyerLotto() {
        int amount = generateAmount();
        List<Lotto> createBuyerLotto = lottoShop.createByBuyerLotto(amount);

        OutputView.printBuyerLotto(createBuyerLotto.size(), createBuyerLotto);

        return new BuyerLotto(createBuyerLotto);
    }

    private WinningLotto createWinningLotto() {
        List<Integer> winningLotto = generateWinningLotto();
        Lotto createWinningLotto = lottoShop.createByWinningLotto(winningLotto);

        int bonusNumber = generateBonusNumber();
        BonusNumber createBonusNumber = lottoShop.createByBonusNumber(bonusNumber);

        return new WinningLotto(createWinningLotto, createBonusNumber);
    }

    private int generateAmount() {
        while (true) {
            try {
                return InputView.readPurchaseAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> generateWinningLotto() {
        while (true) {
            try {
                return InputView.readWinnerLottoNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int generateBonusNumber() {
        while (true) {
            try {
                return InputView.readBonusNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
