package lotto.controller;

import java.util.List;
import lotto.domain.amount.Amount;
import lotto.domain.lotto.Lottos;
import lotto.domain.rank.Rank;
import lotto.domain.winning.WinningNumbers;
import lotto.domain.winning.WinningStatistics;
import lotto.dto.LottoDto;
import lotto.dto.WinningStatisticsDto;
import lotto.utils.generator.RandomNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;

    public GameController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        final Amount amount = initAmount();
        final Lottos lottos = purchaseLottos(amount);
        announceLottos(lottos.getLottoStatus());

        final WinningStatistics winningStatistics = calculateStatistics(lottos, amount);
        announceStatistics(winningStatistics);
    }

    public Amount initAmount() {
        return new Amount(inputView.readAmount());
    }

    public WinningNumbers initWinningNumbers() {
        return new WinningNumbers(inputView.readWinningNumbers(), inputView.readBonusNumber())
                .getWinningNumbersStatus()
                .toWinningTicket();
    }

    public void announceLottos(final List<LottoDto> lottosDto) {
        outputView.printLottoCount(lottosDto);
        outputView.printLottoStatus(lottosDto);
    }

    public Lottos purchaseLottos(final Amount amount) {
        final int lottoCount = amount.getPurchasedCount();
        return new Lottos(lottoCount, new RandomNumberGenerator());
    }

    public void announceStatistics(final WinningStatistics winningStatistics) {
        final WinningStatisticsDto winningStatisticsDto =  winningStatistics.convertToDto();
        outputView.printStatistics(winningStatisticsDto);
    }

    public WinningStatistics calculateStatistics(final Lottos lottos, final Amount amount) {
        final List<Rank> ranks = initWinningNumbers().calculateRanks(lottos);
        return new WinningStatistics(ranks, amount);
    }
}
