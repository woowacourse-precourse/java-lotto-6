package lotto.controller;

import java.util.List;
import lotto.domain.WinLotto;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        Money money = getMoney();
        List<Lotto> lottos = lottoService.generateWith(money);
        outputView.print(lottos);

        WinLotto winLotto = getWinLotto();
    }

    private Money getMoney() {
        return Money.from(inputView.getMoneyInput());
    }

    private WinLotto getWinLotto() {
        return lottoService.createWinLottoWith(inputView.getWinLottoNumber(), inputView.getBonusBall());
    }
}
