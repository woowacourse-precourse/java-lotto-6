package lotto.controller;

import lotto.domain.LottoResult;
import lotto.domain.User;
import lotto.domain.WinningLottoNumbers;
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
        WinningLottoNumbers winningLottoNumbers = getWinningLottoNumbers();
        LottoResult lottoResult = calculateLottoResult(user, winningLottoNumbers);
        calculateReturnRate(user, lottoResult);
    }

    public User buyLottoTicket() {
        int buyAmount = inputView.inputBuyAmount();
        User user = lottoService.buyLottoTicket(buyAmount);
        outputView.printLottoTicket(user.getLottoTicket());
        return user;
    }

    public WinningLottoNumbers getWinningLottoNumbers() {
        List<Integer> winningNumbers = inputView.inputWinningNumbers();
        int bonusNumber = inputView.inputBonusNumber();
        return lottoService.getWinningLottoNumbers(winningNumbers, bonusNumber);
    }

    public LottoResult calculateLottoResult(User user, WinningLottoNumbers winningLottoNumbers) {
        LottoResult lottoResult = lottoService.calculateLottoResult(user, winningLottoNumbers);
        outputView.printLottoResult(lottoResult.getLottoResult());
        return lottoResult;
    }

    public void calculateReturnRate(User user, LottoResult lottoResult) {
        double returnRate = lottoService.calculateReturnRate(user, lottoResult);
        outputView.printReturnRate(returnRate);
    }
}