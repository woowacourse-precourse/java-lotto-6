package lotto.controller;

import lotto.dto.LottoDto;
import lotto.dto.WinningResultDto;
import lotto.service.LottoService;
import lotto.view.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.*;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidator inputValidator;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, InputValidator inputValidator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputValidator = inputValidator;
        this.lottoService = new LottoService();
    }

    public void startLotto() {
        buyLottos();
        announceUserLotto();
        drawLotto();
        calculateWinningResult();
        announceWinningResult();
    }

    private void buyLottos() {
        String input = inputView.getPurchasePrice();
        int purchasePrice = inputValidator.validateNumber(input);
        lottoService.buyLottos(purchasePrice);
    }

    private void announceUserLotto() {
        List<LottoDto> lottoDtos = lottoService.getUserLottoDto();
        outputView.printUserLotto(lottoDtos);
    }

    private void drawLotto() {
        String inputViewWinningNumbers = inputView.getWinningNumbers();
        List<String> splitInput = Arrays.stream(inputViewWinningNumbers.split(",")).toList();
        List<Integer> winningNumbers = inputValidator.validateNumbers(splitInput);

        String inputBonusNumber = inputView.getBonusNumber();
        int bonusNumber = inputValidator.validateNumber(inputBonusNumber);

        lottoService.drawLotto(winningNumbers, bonusNumber);
    }

    private void calculateWinningResult() {
        lottoService.calculateWinningResult();
    }

    private void announceWinningResult() {
        WinningResultDto winningResultDto = lottoService.getWinningResultDto();
        outputView.printWinningResult(winningResultDto);
    }
}
