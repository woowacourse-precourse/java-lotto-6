package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class LottoController {
    private final OutputView outputView;
    private final InputView inputView;


    public LottoController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    public void play() {
        List<Lotto> lottoTicket = attempt(() -> createLottoTicket());
        WinningLotto winningLotto = attempt(() -> createWinningLotto());
        Map<Rank, Integer> winningDetails = Statistics.calculateRank(winningLotto, lottoTicket);
        outputView.printWinningDetails(winningDetails);
        outputView.printProfitRate(Statistics.calculateProfitRate(winningDetails,
                lottoTicket.size() * Price.LOTTO.getAmount()));
    }

    private List<Lotto> createLottoTicket() {
        LottoMachine lottoMachine = new LottoMachine(Price.LOTTO);
        List<Lotto> lottoTicket = lottoMachine.issue(inputView.inputMoney());
        outputView.printLottoTicket(lottoTicket);
        return lottoTicket;
    }

    private WinningLotto createWinningLotto() {
        return new WinningLotto(
                attempt(() -> new Lotto(
                        attempt(() -> inputView.inputWinningNumbers()))
                ),
                attempt(() -> new LottoNumber(
                        attempt(() -> inputView.inputBonusNumber()))
                )
        );
    }


    private <T> T attempt(Supplier<T> inputSupplier) {
        try {
            return inputSupplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printException(e.getMessage());
            return attempt(inputSupplier);
        }
    }
}
