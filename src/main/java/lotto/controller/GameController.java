package lotto.controller;

import lotto.domain.*;
import lotto.domain.dto.input.PurchaseLottoDto;
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
        PurchaseLottoDto purchaseAmount = inputView.getPurchaseAmount();
        Money money = Money.from(purchaseAmount.amount());
        Lottos lottos = lottoStore.purchaseLottoTickets(money);
        LottosDto lottosDto = lottos.toLottosDto();
        outputView.printPurchasedLotto(lottosDto);
        Lotto winningNumbers = inputView.getWinningNumber();
        LottoNumber bonusNumber = inputView.getBonusNumber(winningNumbers);
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(winningNumbers, bonusNumber);
        DrawMachine drawMachine = new DrawMachine(winningLottoNumbers);
        DrawLottoDto drawLottoDto = drawMachine.drawAllTicket(lottos);
        outputView.printDrawResult(drawLottoDto);
    }
}
