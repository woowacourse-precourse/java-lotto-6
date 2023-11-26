package lotto.controller;

import java.util.List;
import lotto.constant.Constant;
import lotto.domain.amount.Amount;
import lotto.domain.analysis.Analysis;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.lotto.strategy.CreateStrategy;
import lotto.domain.rank.Rank;
import lotto.dto.AnalysisDto;
import lotto.dto.LottosDto;
import lotto.mapper.BallMapper;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;
    private final CreateStrategy createStrategy;

    public Controller(final InputView inputView,
                      final OutputView outputView,
                      final CreateStrategy createStrategy) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.createStrategy = createStrategy;
    }

    public void run() {
        final Lottos lottos = purchaseLottos();
        announcePurchasedLottos(lottos);

        final Analysis analysis = calculateAnalysis(lottos);
        announceAnalysis(analysis);
    }

    private Amount initAmount() {
        return ExceptionHandler.handle(() -> {
            final int amount = inputView.readAmount();
            return new Amount(amount);
        });
    }

    private Lottos purchaseLottos() {
        final int count = initAmount().getCount();
        return new Lottos(count, createStrategy);
    }

    private void announcePurchasedLottos(final Lottos lottos) {
        final List<LottosDto> lottosDto = lottos.getLottosStatus();
        outputView.printPurchasedLottosMessage(lottosDto);
        outputView.printLottosStatus(lottosDto);
    }

    private Lotto initWinningNumbers() {
        return ExceptionHandler.handle(() -> {
            final List<Integer> winningNumbers = inputView.readWinningNumbers();
            return new Lotto(winningNumbers);
        });
    }

    private WinningLotto initWinningLotto(final Lotto winningNumbers) {
        return ExceptionHandler.handle(() -> {
            final int bonus = inputView.readBonus();
            return new WinningLotto(winningNumbers, BallMapper.getBall(bonus));
        });
    }

    public Analysis calculateAnalysis(final Lottos lottos) {
        final Lotto winningNumbers = initWinningNumbers();
        final WinningLotto winningLotto = initWinningLotto(winningNumbers);
        final List<Rank> ranks = winningLotto.calculateRanks(lottos);

        final int operand = lottos.getSize() * Constant.OPERAND.getConstant();
        return new Analysis(ranks, operand);
    }

    private void announceAnalysis(final Analysis analysis) {
        final AnalysisDto analysisDto = analysis.toDto();
        outputView.printAnalysis(analysisDto);
    }
}
