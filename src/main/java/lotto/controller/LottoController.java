package lotto.controller;

import lotto.domain.AnswerLotto;
import lotto.domain.UserLotto;
import lotto.domain.Ranking;
import lotto.domain.WinningResult;
import lotto.dto.LottoDto;
import lotto.view.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.*;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidator inputValidator;
    private UserLotto userLotto;
    private AnswerLotto answerLotto;
    private WinningResult winningResult;

    public LottoController(InputView inputView, OutputView outputView, InputValidator inputValidator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputValidator = inputValidator;
    }

    public void startLotto() {
        buyLottos();
        announceUserLotto();
        drawLotto();
        calculateWinningResult();
    }

    private void buyLottos() {
        String input = inputView.getPurchasePrice();
        int purchasePrice = inputValidator.validateNumber(input);
        userLotto = new UserLotto(purchasePrice);
    }

    private void announceUserLotto() {
        List<LottoDto> lottoDtos = userLotto.getLottos().stream()
                .map(lotto -> new LottoDto(lotto.getNumbers()))
                .toList();
        outputView.printUserLotto(lottoDtos);
    }

    private void drawLotto() {
        String inputViewWinningNumbers = inputView.getWinningNumbers();
        List<String> splitInput = Arrays.stream(inputViewWinningNumbers.split(",")).toList();
        List<Integer> winningNumbers = inputValidator.validateNumbers(splitInput);

        String inputBonusNumber = inputView.getBonusNumber();
        int bonusNumber = inputValidator.validateNumber(inputBonusNumber);

        answerLotto = new AnswerLotto(winningNumbers, bonusNumber);
    }

    private void calculateWinningResult() {
        winningResult = userLotto.calculateWinningResult(answerLotto);
    }
}
