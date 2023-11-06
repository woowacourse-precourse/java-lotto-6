package lotto.controller;

import lotto.domain.Customer;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoShop;
import lotto.domain.WinningNumber;
import lotto.domain.dto.Result;
import lotto.domain.service.LottoService;
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
        long purchaseAmount = inputView.inputPurchaseAmount();
        Customer customer = new Customer(new LottoShop(), purchaseAmount);
        outputView.printPurchasedLottos(customer.getLottos());

        Lotto winningLotto = new Lotto(inputView.inputWinningNumbers());
        LottoNumber bonusNumber = new LottoNumber(inputView.inputBonusNumber());
        WinningNumber winningNumber = new WinningNumber(winningLotto, bonusNumber);

        Result winningResult = lottoService.getWinningResult(customer.getLottos(), winningNumber, customer.getPurchaseAmount());
        outputView.printWinningResult(winningResult);
    }
}
