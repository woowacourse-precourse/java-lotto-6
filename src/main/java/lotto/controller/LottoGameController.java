package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoGame;
import lotto.model.LottoGenerator;
import lotto.model.LottoPublisher;
import lotto.model.Money;
import lotto.model.ProfitRate;
import lotto.model.RandomLottoGenerator;
import lotto.model.WinningDetails;
import lotto.model.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    public void run() {
        try {
            process();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
        }
    }

    private void process() {
        final Money money = readPurchaseAmount();
        final List<Lotto> lottoTickets = publishLotto(money);
        OutputView.printLottoTickets(lottoTickets);

        final LottoGame lottoGame = new LottoGame(createWinningNumber(), lottoTickets);
        final WinningDetails winningDetails = lottoGame.play();
        OutputView.printWinningDetails(winningDetails);

        final ProfitRate profitRate = new ProfitRate(money, winningDetails.sumUpWinningAmount());
        OutputView.printProfitRate(profitRate);
    }

    private Money readPurchaseAmount() {
        return InputView.readWithRetry(() -> Money.of(InputView.readPurChaseAmount()));
    }

    private List<Lotto> publishLotto(final Money money) {
        final LottoPublisher publisher = createLottoPublisher();
        return publisher.publish(money);
    }

    private LottoPublisher createLottoPublisher() {
        return new LottoPublisher(createLottoGenerator());
    }

    private LottoGenerator createLottoGenerator() {
        return new RandomLottoGenerator();
    }

    private WinningNumber createWinningNumber() {
        return InputView.readWithRetry(
                () -> new WinningNumber(
                        InputView.readWinningNumbers(),
                        InputView.readBonusNumber()
                ));
    }
}
