package lotto.controller;

import lotto.domain.LottoResult;
import lotto.domain.User;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoService = new LottoService();
    }

    public void run() {
        User user = buyLottoTicket();
        LottoResult lottoResult = calculateLottoResult(user);
        calculateReturnRate(user, lottoResult);
    }

    public User buyLottoTicket() {
        int buyAmount = inputView.inputBuyAmount();
        User user = lottoService.buyLottoTicket(buyAmount);
        outputView.printLottoTicket(user.getLottoTicket());
        return user;
    }

    public LottoResult calculateLottoResult(User user) {
        List<Integer> winningNumbers = inputView.inputWinningNumbers();
        int bonusNumber = inputView.inputBonusNumber();
        LottoResult lottoResult = lottoService.calculateLottoResult(user, winningNumbers, bonusNumber);
        outputView.printLottoResult(lottoResult.getLottoResult());
        return lottoResult;
    }

    public void calculateReturnRate(User user, LottoResult lottoResult) {
        double returnRate = lottoService.calculateReturnRate(user, lottoResult);
        outputView.printReturnRate(returnRate);
    }
}