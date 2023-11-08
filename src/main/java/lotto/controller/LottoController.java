package lotto.controller;

import lotto.dto.LottoesDto;
import lotto.dto.MoneyDto;
import lotto.dto.ResultDto;
import lotto.dto.WinNumbersDto;
import lotto.service.LottoService;
import lotto.util.validator.ValidatingLoopTemplate;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoService lottoService = new LottoService();
    private final ValidatingLoopTemplate validatingLoopTemplate = new ValidatingLoopTemplate();

    public void run() {
        purchaseLottoes();
        WinNumbersDto winNumbersDto = createWinNumbers();
        ResultDto resultDto = lottoService.generateResult(winNumbersDto);
        outputView.announceFinalResult(resultDto);
    }

    private void purchaseLottoes() {
        MoneyDto moneyDto = validatingLoopTemplate.execute(this::getMoneyFromClient);
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

    private WinNumbersDto createWinNumbers() {
        List<Integer> winNumbers = validatingLoopTemplate.execute(this::getWinNumbers);
        return validatingLoopTemplate.execute(()
                -> new WinNumbersDto(winNumbers, getBonusNumber()));
    }

    private List<Integer> getWinNumbers() {
        outputView.beforeInputWinNumbers();
        return inputView.inputNumbers();
    }

    private int getBonusNumber() {
        outputView.beforeInputBonusNumber();
        return inputView.inputBonusNumber();
    }
}