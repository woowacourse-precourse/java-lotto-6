package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoComputer;
import lotto.domain.LottoGenerator;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoService {

    InputView inputView;
    OutputView outputView;

    private Lottos myLottos;
    private Lotto luckyLotto;
    private int myBonusNumber;

    public LottoService(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.askMoney();
        LottoGenerator lottoGenerator = new LottoGenerator(inputView.readMoney());

        myLottos = lottoGenerator.wishMeLuck();
        outputView.showLottoTickets();

        handleUserNumber();

        LottoComputer lottoComputer = new LottoComputer(luckyLotto, myBonusNumber);
        outputView.showResult(lottoComputer.simulate());
    }

    private void handleUserNumber() {
        outputView.askLuckyNumber();
        luckyLotto = inputView.readLuckyNumber();

        outputView.askBonusNumber();
        myBonusNumber = inputView.readBonusNumber();
    }


}