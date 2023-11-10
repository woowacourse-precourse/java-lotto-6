package lotto.controller;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoPurchase;
import lotto.domain.LottoRanking;
import lotto.domain.LottoWinning;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public LottoController() {
    }

    public void run() {
        try {
            start();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        List<Lotto> purchaseLottos = purchaseLottoByUserAmount();
        List<Integer> winningNumbers = setwinningNumbers();
        int winningBonusNumber = setwinningBonusNumber(winningNumbers);
        setwinningDetails(purchaseLottos, winningNumbers, winningBonusNumber);

    }

    public List<Lotto> purchaseLottoByUserAmount() {
        long purchaseAmount = InputView.inputPurchaseAmount();
        int ticketAmount = Long.valueOf(purchaseAmount / 1000).intValue();
        List<Lotto> purchaselottos = LottoPurchase.purchasedLottos(ticketAmount);
        OutputView.outputPurchaseLottos(purchaselottos);

        return purchaselottos;
    }

    public List<Integer> setwinningNumbers() {
        return InputView.inputWinningNumbers();
    }

    public int setwinningBonusNumber(List<Integer> winningNumbers) {
        return InputView.inputWinningBonusNumber(winningNumbers);
    }

    public void setwinningDetails(List<Lotto> purchaseLottos, List<Integer> winningNumbers, int winningBonusNumber) {
        // 구매한 로또랑 당청 금액 비교
        List<LottoRanking> winnings = LottoWinning.winningCheck(purchaseLottos, winningNumbers, winningBonusNumber);
        // 비교한 결과 print
        OutputView.checkWinningList(winnings);
    }
}
