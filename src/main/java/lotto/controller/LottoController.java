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
        purchaseLottoes();
        WinNumbersDto winNumbersDto = createWinNumbers();
    }

    private WinNumbersDto createWinNumbers() {
        List<Integer> winNumbers = inputWinNumbers();
        int bonusNumber = inputBonusNumber();
        return new WinNumbersDto(winNumbers, bonusNumber);
    }

    private List<Integer> inputWinNumbers() {
        outputView.beforeInputWinNumbers();
        return inputView.inputNumbers();
    }

    private int inputBonusNumber() {
        outputView.beforeInputBonusNumber();
        return inputView.inputBonusNumber();
    }

    private void purchaseLottoes() {
        MoneyDto moneyDto = getMoneyFromClient();
        createLottoes(moneyDto);
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
