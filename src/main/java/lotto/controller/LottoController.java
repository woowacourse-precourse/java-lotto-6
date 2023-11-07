package lotto.controller;

import lotto.domain.Lotto;
import lotto.dto.LottoesDto;
import lotto.dto.MoneyDto;
import lotto.dto.ResultDto;
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
        ResultDto resultDto = lottoService.generateResult(winNumbersDto);
        outputView.announceFinalResult(resultDto);
    }

    private void purchaseLottoes() {
        while (true) {
            try {
                MoneyDto moneyDto = getMoneyFromClient();
                createLottoes(moneyDto);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
    }

    private MoneyDto getMoneyFromClient() {
        outputView.beforeInputMoney();
        return new MoneyDto(inputView.inputMoney());
    }

    private void createLottoes(MoneyDto moneyDto) {
        LottoesDto lottoesDto = lottoService.purchaseLottoes(moneyDto);
        outputView.printPurchasedLottoes(lottoesDto);
    }

    private WinNumbersDto createWinNumbers() {
        List<Integer> winNumbers = getWinNumbers();
        WinNumbersDto winNumbersDto;
        while (true) {
            try {
                int bonusNumber = getBonusNumber();
                winNumbersDto = new WinNumbersDto(winNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
        return winNumbersDto;
    }

    private List<Integer> getWinNumbers() {
        List<Integer> winNumbers;
        while (true) {
            try {
                outputView.beforeInputWinNumbers();
                winNumbers = inputView.inputNumbers();
                new Lotto(winNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
        return winNumbers;
    }

    private int getBonusNumber() {
        outputView.beforeInputBonusNumber();
        return inputView.inputBonusNumber();
    }
}
