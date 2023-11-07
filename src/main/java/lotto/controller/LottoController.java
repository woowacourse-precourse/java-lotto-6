package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.LottoManager;
import lotto.domain.Lottos;
import lotto.domain.Prizes;
import lotto.service.LottoService;
import lotto.util.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private static final String DELIMITER = ",";

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public LottoService initializeLottoService() {
        return new LottoService(new LottoManager(), Prizes.createPrizes());
    }

    public void run() {
        LottoService lottoService = initializeLottoService();

        final int purchaseAmount = processPurchaseAmountInput();
        final Lottos issuedLottos = lottoService.buyLotto(purchaseAmount);
        outputView.showIssuedLottoResult(issuedLottos.getIssuedLottoNumbers());

        final List<Integer> winningNumbers = processWinnigNumbersInput();
        final int bonusNumber = processBonusNumberInput();
        lottoService.drawWinningLotto(winningNumbers, bonusNumber);

        final Prizes prizes = lottoService.statisticsLottoResult(issuedLottos);
        outputView.showLottoResult(prizes);
        double profitRate = lottoService.getProfitRate(purchaseAmount);
        outputView.showProfitRate(profitRate);
    }

    public int processPurchaseAmountInput() {
        while (true){
            try {
                int purchaseAmount = convertStringToInt(inputView.askPurchaseAmount());

                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                outputView.showErrorMessage(e.getMessage());
            }
        }
    }

    public List<Integer> processWinnigNumbersInput() {
        while (true) {
            try {
                List<Integer> winningNumbers = convertToList(inputView.askWinnigNumbers());

                return winningNumbers;
            }catch (IllegalArgumentException e) {
                outputView.showErrorMessage(e.getMessage());
            }
        }
    }

    public int processBonusNumberInput() {
        while (true) {
            try {
                int bonusNumber = convertStringToInt(inputView.askBonusNumber());

                return bonusNumber;
            }catch (IllegalArgumentException e) {
                outputView.showErrorMessage(e.getMessage());
            }
        }
    }

    private int convertStringToInt(String input) {
        InputValidator.validateInput(input);

        return Integer.valueOf(input);
    }

    private List<Integer> convertToList(String input) {
        try {
            return Arrays.stream(input.trim().split(DELIMITER))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 숫자만 가능합니다.");
        }
    }
}
