package lotto.controller;

import lotto.dto.LottoesDto;
import lotto.dto.MoneyDto;
import lotto.dto.WinNumbersDto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoService lottoService = new LottoService();

    public void run() {
        MoneyDto moneyDto = getMoneyFromClient();
        createLottoes(moneyDto);

        outputView.beforeInputWinNumbers();
        List<Integer> winNumbers = inputView.inputNumbers();
        int bonusNumber = 0;
        WinNumbersDto winNumbersDto = new WinNumbersDto(winNumbers, bonusNumber);
        System.out.println(winNumbersDto);
    }

    private MoneyDto getMoneyFromClient() {
        outputView.beforeInputMoney();
        return new MoneyDto(inputView.inputMoney());
    }

    private void createLottoes(MoneyDto moneyDto) {
        LottoesDto lottoesDto = lottoService.purchaseLottoes(moneyDto);
        outputView.printPurchasedLottoes(lottoesDto);
    }
}
