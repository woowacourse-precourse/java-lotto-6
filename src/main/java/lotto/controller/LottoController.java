package lotto.controller;

import lotto.dto.LottoesDto;
import lotto.dto.MoneyDto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoService lottoService = new LottoService();

    public void run() {
        MoneyDto moneyDto = getMoneyFromClient();
        createLottoes(moneyDto);
    }

    private MoneyDto getMoneyFromClient() {
        outputView.beforeInputMoney();
        MoneyDto moneyDto = new MoneyDto(inputView.inputMoney());
        return moneyDto;
    }

    private void createLottoes(MoneyDto moneyDto) {
        LottoesDto lottoesDto = lottoService.purchaseLottoes(moneyDto);
        outputView.printPurchasedLottoes(lottoesDto);
    }
}
