package lotto.controller;

import lotto.domain.Lotto;
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
        validatingLoopTemplate.execute(() -> {
            MoneyDto moneyDto = getMoneyFromClient();
            createLottoes(moneyDto);
            return null;
        });
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
        return validatingLoopTemplate.execute(() -> {
            int bonusNumber = getBonusNumber();
            return new WinNumbersDto(winNumbers, bonusNumber);
        });
    }

    private List<Integer> getWinNumbers() {
        return validatingLoopTemplate.execute(() -> {
            List<Integer> winNumbers;
            outputView.beforeInputWinNumbers();
            winNumbers = inputView.inputNumbers();
            new Lotto(winNumbers);
            return winNumbers;
        });
    }

    private int getBonusNumber() {
        outputView.beforeInputBonusNumber();
        return inputView.inputBonusNumber();
    }
}
