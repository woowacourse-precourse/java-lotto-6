package lotto.controller;

import lotto.domain.LottoPrize;
import lotto.domain.User;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.EnumMap;
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
        EnumMap<LottoPrize, Integer> lottoResult = calculateLottoResult(user);
    }

    public User buyLottoTicket() {
        int buyAmount = inputView.inputBuyAmount();
        User user = lottoService.buyLottoTicket(buyAmount);
        outputView.printLottoTicket(user.getLottoTicket());
        return user;
    }

    public EnumMap<LottoPrize, Integer> calculateLottoResult(User user) {
        List<Integer> winningNumbers = inputView.inputWinningNumbers();
        int bonusNumber = inputView.inputBonusNumber();
        EnumMap<LottoPrize, Integer> lottoResult = lottoService.calculateLottoResult(user, winningNumbers, bonusNumber);
        outputView.printLottoResult(lottoResult);
        return lottoResult;
    }
}