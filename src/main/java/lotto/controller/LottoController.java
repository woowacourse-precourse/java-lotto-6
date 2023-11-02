package lotto.controller;

import lotto.domain.LottoFactory;
import lotto.domain.RandomNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int money = inputView.enterMoney();
        LottoFactory lottoFactory = LottoFactory.create(new RandomNumberGenerator(), money);

        outputView.printLottoNumbers(lottoFactory.getLottoNumbers());
    }
}
