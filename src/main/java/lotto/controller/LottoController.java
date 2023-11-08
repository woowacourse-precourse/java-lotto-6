package lotto.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.constants.RankMessage;
import lotto.domain.Lotto;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.LottoPurchase;
import lotto.domain.LottoResult;
import lotto.domain.Numbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoResult lottoResult;

    public LottoController() {
        inputView = new InputView();
        outputView = new OutputView();
        lottoResult = new LottoResult();
    }
    public void start() {
        LottoPurchase lottoPurchase = inputAmount();
        System.out.println();

        int ticketCount = lottoPurchase.getPurchaseAmount();
        outputView.printTicketCount(ticketCount);

        List<Lotto> lottoTickets = buyTickets(ticketCount);
        outputView.printTickets(lottoTickets);

        Numbers numbers = getNumbers();

        lottoResult.calculateRankingResult(lottoTickets, numbers);

        Map<RankMessage, Integer> winningResult = lottoResult.getWinningResult();
        outputView.printWinningStatistics(winningResult);

        double profitRate = lottoResult.getProfitRate(lottoPurchase);
        outputView.printProfitRate(profitRate);
    }
    private LottoPurchase inputAmount() {
        try {
            return new LottoPurchase(inputView.getPurchaseAmount());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return inputAmount();
        }
    }
    private List<Lotto> buyTickets(int ticketCount) {
        return IntStream.range(0, ticketCount)
                .mapToObj(i -> new Lotto(LottoNumberGenerator.generateLottoNumber()))
                .collect(Collectors.toList());
    }
    private Numbers getNumbers() {
        Lotto winningNumbers = getWinningNumbers();
        System.out.println();
        int bonusNumber = getBonusNumber();
        return createNumbers(winningNumbers, bonusNumber);
    }
    private Lotto getWinningNumbers() {
        try {
            return new Lotto(inputView.getLottoNumbers());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return getWinningNumbers();
        }
    }
    private int getBonusNumber() {
        try {
            return inputView.getBonusNumber();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return getBonusNumber();
        }
    }
    private Numbers createNumbers(Lotto winningNumbers, int bonusNumber) {
        try {
            return new Numbers(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return createNumbers(winningNumbers, getBonusNumber());
        }
    }
}