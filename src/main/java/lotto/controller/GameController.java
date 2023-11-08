package lotto.controller;

import lotto.domain.*;
import lotto.domain.dto.input.PurchaseLottoDto;
import lotto.domain.dto.input.WinningLottoNumbersDto;
import lotto.domain.dto.output.DrawLottoDto;
import lotto.domain.dto.output.LottosDto;
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
        PurchaseLottoDto purchaseAmount = inputView.getPurchaseAmount();
        Money money = Money.from(purchaseAmount.amount());
        Lottos lottos = lottoStore.purchaseLottoTickets(money);
        LottosDto lottosDto = LottosDto.createLottosDto(lottos);
        outputView.printPurchasedLotto(lottosDto);
        return lottos;
    }

    private void draw(Lottos lottos) {
        WinningLottoNumbersDto winningLottoNumbersDto = inputView.getWinningLottoNumbers();
        WinningLottoNumbers winningLottoNumbers = WinningLottoNumbers.from(winningLottoNumbersDto);
        DrawMachine drawMachine = DrawMachine.from(winningLottoNumbers);
        DrawLottoDto drawLottoDto = drawMachine.drawAllTicket(lottos);
        outputView.printDrawResult(drawLottoDto);
    }
}
