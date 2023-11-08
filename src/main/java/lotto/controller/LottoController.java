package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.Lottos;
import lotto.domain.ResultGenerator;
import lotto.domain.WinningLotto;
import lotto.domain.constants.LottoConstraint;
import lotto.view.InputView;
import lotto.view.OutPutView;

public class LottoController {
    public final InputView inputView;
    public final OutPutView outputView;

    public LottoController(InputView inputView, OutPutView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        int price = inputView.inputBuyingPrice();
        int lottoTicketCount = countLottoTicket(price);
        outputView.printBuyingPriceResult(lottoTicketCount);

        Lottos lottoTickets = new Lottos(LottoGenerator.generateLottos(lottoTicketCount));
        outputView.printLottoTickets(lottoTickets);

        Lotto winningNumbers = inputView.inputWinningLottoNumbers();
        int bonusNumber = inputView.inputBonusNumber(winningNumbers);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        outputView.printResult(createResult(winningLotto, lottoTickets));
    }

    private int countLottoTicket(int price) {
        return price / LottoConstraint.LOTTO_PRICE.getValue();
    }

    private String createResult(WinningLotto winningLotto, Lottos lottotickets){
        ResultGenerator resultGenerator = new ResultGenerator(winningLotto, lottotickets);
        return resultGenerator.generate();
    }
}
