package lotto.controller;

import lotto.domain.*;
import lotto.domain.dto.input.PurchaseLottoRequest;
import lotto.domain.dto.input.WinningLottoRequest;
import lotto.domain.dto.output.DrawLottosResponse;
import lotto.domain.dto.output.LottosResponse;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoStore lottoStore;

    public GameController(InputView inputView, OutputView outputView, LottoStore lottoStore) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoStore = lottoStore;
    }

    public void start() {
        Lottos lottos = purchaseLottos();
        draw(lottos);
    }

    private Lottos purchaseLottos() {
        PurchaseLottoRequest purchaseLottoRequest = inputView.getPurchaseAmount();
        Money money = Money.from(purchaseLottoRequest.amount());
        Lottos lottos = lottoStore.purchaseLottoTickets(money);
        LottosResponse lottosResponse = LottosResponse.createLottosResponse(lottos);
        outputView.printPurchasedLotto(lottosResponse);
        return lottos;
    }

    private void draw(Lottos lottos) {
        WinningLottoRequest winningLottoRequest = inputView.getWinningLottoNumbers();
        WinningLottoNumbers winningLottoNumbers = WinningLottoNumbers.from(winningLottoRequest);
        DrawMachine drawMachine = DrawMachine.from(winningLottoNumbers);
        DrawLottosResponse drawLottosResponse = drawMachine.drawAll(lottos);
        outputView.printDrawResult(drawLottosResponse);
    }
}
