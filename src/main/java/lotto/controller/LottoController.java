package lotto.controller;

import lotto.model.Lotto;
import lotto.model.*;
import lotto.view.LottoView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private final LottoView view;
    private final LottoTicket lottoTicket;

    public LottoController(LottoView view) {
        this.view = view;
        this.lottoTicket = new LottoTicket(0);
    }

    public void run() {
        int purchaseAmount = view.getPurchaseAmount();
        int numberOfTickets = purchaseAmount / Lotto.TICKET_PRICE;
        view.printNumberOfPurchasedTickets(numberOfTickets);

        List<LottoNumber> purchasedLotto = new ArrayList<>();
        for (int i = 0; i < numberOfTickets; i++) {
            List<Integer> lottoNumbers = LottoNumberGenerator.generateRandomLottoNumbers();
            purchasedLotto.add(new LottoNumber(lottoNumbers));
        }

        List<Integer> winningNumbers = view.getWinningNumbers();
        int bonusNumber = view.getBonusNumber();
        WinningNumbers winningNumbersObject = new WinningNumbers(winningNumbers, bonusNumber);

        List<WinningResult> winningResults = new ArrayList<>();
        for (LottoNumber lottoNumber : purchasedLotto) {
            int matchingCount = lottoNumber.calculateMatchingCount(winningNumbers);
            boolean hasBonusNumber = lottoNumber.hasBonusNumber(bonusNumber);
            WinningResult winningResult = new WinningResult(matchingCount, hasBonusNumber);
            winningResults.add(winningResult);
        }

        ProfitRateCalculator profitRateCalculator = new ProfitRateCalculator(purchaseAmount, winningResults);
        double profitRate = profitRateCalculator.calculateProfitRate();

        view.printWinningResults(winningResults);
    }
}
