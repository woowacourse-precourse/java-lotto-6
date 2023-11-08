package lotto.controller;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.LottoBuyer;
import lotto.domain.LottoRank;
import lotto.domain.Payment;
import lotto.domain.WinningLottoNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private static final OutputView OUTPUT_VIEW = OutputView.getInstance();
    private static final InputView INPUT_VIEW = InputView.getInstance();
    private Payment payment;
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
        lottoBuyer = new LottoBuyer(payment);
        OUTPUT_VIEW.printNumberOfPurchased(lottoBuyer.getNumberOfLottoTickets());
        OUTPUT_VIEW.printLottoTickets(lottoBuyer.getLottoTicketsInformation());
        initWinningNumbers();
        initWinningLottoNumbers();
    }

    private void initPayment() {
        try {
            payment = new Payment(INPUT_VIEW.readPaymentInput());
        } catch (IllegalArgumentException e) {
            OUTPUT_VIEW.printErrorMessage(e.getMessage());
            initPayment();
        }
    }

    private void initWinningNumbers() {
        try {
            winningLotto = new Lotto(INPUT_VIEW.readWinningNumber());
        } catch (IllegalArgumentException e) {
            OUTPUT_VIEW.printErrorMessage(e.getMessage());
            initWinningNumbers();
        }
    }

    private void initWinningLottoNumbers() {
        try {
            bonus = new Bonus(INPUT_VIEW.readBonusInput());
            winningLottoNumbers = new WinningLottoNumbers(winningLotto, bonus);
        } catch (IllegalArgumentException e) {
            OUTPUT_VIEW.printErrorMessage(e.getMessage());
            initWinningLottoNumbers();
        }
    }

    private void showResult() {
        List<LottoRank> resultRanks = lottoBuyer.getLottoResult(winningLottoNumbers);
        Map<LottoRank, Integer> countRanks = getCountRanks(resultRanks);
        OUTPUT_VIEW.printWinningResult(convertCountRanks(countRanks));
        showRateOfRevenue(resultRanks);
    }

    private void showRateOfRevenue(List<LottoRank> resultRanks) {
        OUTPUT_VIEW.printRateOfRevenue(lottoBuyer.getRateOfReturn(resultRanks));
    }

    private EnumMap<LottoRank, Integer> initCountRanks() {
        EnumMap<LottoRank, Integer> countRanks = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.getValuesWithoutNone()) {
            countRanks.put(rank, 0);
        }
        return countRanks;
    }

    private Map<LottoRank, Integer> getCountRanks(List<LottoRank> resultRanks) {
        Map<LottoRank, Integer> countRanks = initCountRanks();
        resultRanks.removeIf(lottoRank -> lottoRank == LottoRank.NONE);
        for (LottoRank rank : resultRanks) {
            countRanks.put(rank, countRanks.get(rank) + 1);
        }
        return countRanks;
    }

    private List<String> convertCountRanks(Map<LottoRank, Integer> countRanks) {
        return countRanks.entrySet().stream()
                .map(entry -> String.format(entry.getKey().getMessage(), entry.getValue()))
                .toList();
    }
}
