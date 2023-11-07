package lotto.controller;

import java.util.EnumMap;
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
        initPayment();
        lottoTickets = new LottoTickets(payment);
        lottoBuyer = new LottoBuyer(payment, lottoTickets);
        outputView.printNumberOfPurchased(lottoTickets.getNumberOfLottoTickets());
        outputView.printLottoTickets(lottoTickets.toString());
        initWinningLotto();
        initBonus();
        winningLottoNumbers = new WinningLottoNumbers(winningLotto, bonus);
    }

    private void initPayment() {
        try {
            payment = new Payment(inputView.readPaymentInput());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            initPayment();
        }
    }

    private void initWinningLotto() {
        try {
            winningLotto = new Lotto(inputView.readWinningNumber());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            initWinningLotto();
        }
    }

    private void initBonus() {
        try {
            bonus = new Bonus(inputView.readBonusInput());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            initBonus();
        }
    }

    private void showResult() {
        List<LottoRank> ranks = lottoTickets.getWinningRanks(winningLottoNumbers);
        Map<LottoRank, Integer> countRanks = getCountRanks(ranks);

        List<String> results = countRanks.entrySet().stream()
                .map(entry -> String.format(entry.getKey().getMessage(), entry.getValue()))
                .toList();

        outputView.printWinningResult(results);
        showRateOfRevenue(ranks);
    }

    private Map<LottoRank, Integer> getCountRanks(List<LottoRank> ranks) {
        Map<LottoRank, Integer> countRanks = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            countRanks.put(rank, 0);
        }
        countRanks.remove(LottoRank.NONE);
        ranks.removeIf(lottoRank -> lottoRank == LottoRank.NONE);

        for (LottoRank rank : ranks) {
            countRanks.put(rank, countRanks.get(rank) + 1);
        }
        return countRanks;
    }

    private void showRateOfRevenue(List<LottoRank> ranks) {
        outputView.printRateOfRevenue(lottoBuyer.getRateOfReturn(ranks));
    }
}
