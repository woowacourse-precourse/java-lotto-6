package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoPurchase;
import lotto.domain.LottoResult;
import lotto.domain.Money;
import lotto.domain.WinningNumber;
import lotto.domain.enums.LottoRank;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private Money money;
    private WinningNumber winningNumber;
    private List<Lotto> lottos;

    public void start() {
        initialize();
        List<LottoRank> ranks = getRanks(lottos, winningNumber);
        LottoResult lottoResult = new LottoResult(ranks);
        showResult(lottoResult, money.getMoney());
    }

    private void initialize() {
        money = putMoney(inputMoney());
        int purchaseCount = money.getPurchaseCount();
        OutputView.showPurchaseCount(purchaseCount);

        lottos = buyLotto(purchaseCount);
        OutputView.showPurchaseLotto(lottos);

        winningNumber = makeWinningNumber();
    }

    private Money putMoney(long money) {
        try {
            return new Money(money);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return putMoney(inputMoney());
        }
    }

    private long inputMoney() {
        try {
            return InputView.inputMoney();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputMoney();
        }
    }

    private List<Lotto> buyLotto(int purchaseCount) {
        return LottoPurchase.buyLotto(purchaseCount);
    }

    private WinningNumber makeWinningNumber() {
        Lotto winningLotto = inputWinningNumber();
        int bonusNumber = inputBonusNumber();

        return getWinningNumber(winningLotto, bonusNumber);
    }

    private Lotto inputWinningNumber() {
        try {
            return new Lotto(InputView.inputWinningNumber());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningNumber();
        }
    }

    private int inputBonusNumber() {
        try {
            return InputView.inputBonusNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber();
        }
    }

    private WinningNumber getWinningNumber(Lotto winningLotto, int bonusNumber) {
        try {
            return new WinningNumber(winningLotto, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningNumber(winningLotto, inputBonusNumber());
        }
    }

    private List<LottoRank> getRanks(List<Lotto> lottos, WinningNumber winningNumber) {
        List<LottoRank> ranks = new ArrayList<>();

        for (Lotto lotto : lottos) {
            LottoRank rank = LottoRank.getResult(lotto, winningNumber);
            ranks.add(rank);
        }

        return ranks;
    }

    private void showResult(LottoResult lottoResult, long money) {
        OutputView.showResult(lottoResult, money);
    }
}
