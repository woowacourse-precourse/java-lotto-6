package lotto.controller;

import lotto.model.*;
import lotto.view.LottoView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private final LottoView view;

    public LottoController(LottoView view) {
        this.view = view;
    }

    public void run() {
        int purchaseAmount = view.getPurchaseAmount();
        int numberOfTickets = purchaseAmount / Lotto.TICKET_PRICE;
        List<Lotto> purchasedLottos = generatePurchasedLottos(numberOfTickets);

        view.printNumberOfPurchasedTickets(numberOfTickets, purchasedLottos);

        List<Integer> winningNumbers = view.getWinningNumbers();
        int bonusNumber = view.getBonusNumber();

        WinningNumbers winningNumbersObject = new WinningNumbers(winningNumbers, bonusNumber);

        List<WinningResult> winningResults = new ArrayList<>();
        for (Lotto lottoNumber : purchasedLottos) {
            int matchingCount = lottoNumber.calculateMatchingCount(winningNumbers);
            boolean hasBonusNumber = lottoNumber.hasBonusNumber(bonusNumber);
            WinningResult winningResult = new WinningResult(matchingCount, hasBonusNumber);
            winningResults.add(winningResult);
        }

        ProfitRateCalculator profitRateCalculator = new ProfitRateCalculator(purchaseAmount, winningResults);
        double profitRate = profitRateCalculator.calculateProfitRate();

        view.printWinningResults(winningResults);
        view.printProfitRate(profitRate);
    }

    private List<Lotto> generatePurchasedLottos(int count) {
        List<Lotto> purchasedLottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> lottoNumbers = LottoNumberGenerator.generateRandomLottoNumbers();
            purchasedLottos.add(new Lotto(lottoNumbers));
        }
        return purchasedLottos;
    }
}