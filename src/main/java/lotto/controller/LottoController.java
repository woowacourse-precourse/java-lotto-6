package lotto.controller;

import lotto.domain.wrapper.BuyLottos;
import lotto.domain.wrapper.Lotto;
import lotto.domain.wrapper.Money;
import lotto.handler.InputHandler;
import lotto.handler.OutputHandler;
import lotto.service.LottoService;

import java.util.List;

public class LottoController {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final LottoService lottoService;

    public LottoController(InputHandler inputHandler, OutputHandler outputHandler, LottoService lottoService) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.lottoService = lottoService;
    }

    public void run() {
        Money money = loadTicket();

        BuyLottos buyLottos = buyLotto(money);

        Lotto winningLotto = loadWinningLotto();
    }

    private Money loadTicket() {
        outputHandler.printInputMoneyMessage();
        String money = inputHandler.inputValue();

        return Money.create(money);
    }

    private BuyLottos buyLotto(Money money) {
        List<Lotto> buyLottos = lottoService.generateBuyLottos(money);
        outputHandler.printBuyLottoList(buyLottos);

        return BuyLottos.create(buyLottos);
    }

    private Lotto loadWinningLotto() {
        outputHandler.printInputWinningLottoMessage();
        String winningLotto = inputHandler.inputValue();

        return Lotto.from(winningLotto);
    }
}
