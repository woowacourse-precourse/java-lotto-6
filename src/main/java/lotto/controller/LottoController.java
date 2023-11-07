package lotto.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.LottoBuyer;
import lotto.domain.LottoRank;
import lotto.domain.LottoTickets;
import lotto.domain.Payment;
import lotto.domain.WinningLottoNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    private Payment payment;
    private LottoTickets lottoTickets;
    private LottoBuyer lottoBuyer;
    private Bonus bonus;
    private Lotto winningLotto;
    private WinningLottoNumbers winningLottoNumbers;

    public void run() {
        init();
        showResult();
    }

    private void init() {
        payment = new Payment(inputView.readPaymentInput());
        lottoTickets = new LottoTickets(payment);
        lottoBuyer = new LottoBuyer(payment, lottoTickets);
        outputView.printNumberOfPurchased(lottoTickets.getNumberOfLottoTickets());
        outputView.printLottoTickets(lottoTickets.toString());
        winningLotto = new Lotto(inputView.readWinningNumber());
        bonus = new Bonus(inputView.readBonusInput());
        winningLottoNumbers = new WinningLottoNumbers(winningLotto, bonus);
    }

    private void showResult() {
        List<LottoRank> ranks = lottoTickets.getWiningRanks(winningLottoNumbers);
        Map<LottoRank, Integer> countRanks = getCountRanks(ranks);
        List<String> results = new ArrayList<>();
        for (Map.Entry<LottoRank, Integer> entry : countRanks.entrySet()) {
            LottoRank key = entry.getKey();
            Integer value = entry.getValue();
            results.add(String.format(key.getMessage(), value.intValue()));
        }
        outputView.printWinningResult(results);
        showRateOfRevenue(ranks);
    }

    private Map<LottoRank, Integer> getCountRanks(List<LottoRank> ranks) {
        Map<LottoRank, Integer> countRanks = new HashMap<>();
        countRanks.put(LottoRank.FIRST, 0);
        countRanks.put(LottoRank.SECOND, 0);
        countRanks.put(LottoRank.THIRD, 0);
        countRanks.put(LottoRank.FOURTH, 0);
        countRanks.put(LottoRank.FIFTH, 0);
        for (int i = 0; i < ranks.size(); i++) {
            if (ranks.get(i) == LottoRank.NONE) {
                continue;
            }
            countRanks.put(ranks.get(i), countRanks.get(ranks.get(i)) + 1);
        }
        return countRanks;
    }

    private void showRateOfRevenue(List<LottoRank> ranks) {
        outputView.printRateOfRevenue(lottoBuyer.getRateOfReturn(ranks));
    }
}
