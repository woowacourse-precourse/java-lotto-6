package lotto.controller;

import lotto.domain.*;
import lotto.domain.enums.LottoConstraint;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public final InputView inputView;
    public final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        int price = inputView.purchaseLotto();
        int lottoTicketCount = countLottoTicket(price);
        outputView.printBuyingPriceResult(lottoTicketCount);

        Lottos lottoTickets = new Lottos(LottoMachine.generateLottos(lottoTicketCount));
        outputView.printLottoTickets(lottoTickets);

        Lotto winningNumbers = inputView.inputLottoNumbers();
        int bonusNumber = inputView.inputBonusNumber(winningNumbers);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        outputView.printResult(createResult(winningLotto, lottoTickets));
    }

    private int countLottoTicket(int price) {
        return price / LottoConstraint.LOTTO_UNIT_PRICE.getValue();
    }

    private String createResult(WinningLotto winningLotto, Lottos lottotickets){
        LottoResult lottoResult = new LottoResult(winningLotto, lottotickets);
        return lottoResult.generate();
    }
}