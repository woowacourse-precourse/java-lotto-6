package lotto.controller;

import java.util.List;
import lotto.controller.util.parser.InputParser;
import lotto.controller.util.validator.InputValidator;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.LottoService;
import lotto.model.WinningNumber;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class LottoController {
    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;
    private final InputParser inputParser;
    private final InputValidator inputValidator;

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView,
                           InputParser inputParser, InputValidator inputValidator) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputParser = inputParser;
        this.inputValidator = inputValidator;
    }

    public void startLotto() {
        int money = getMoney();
        List<Lotto> lottos = lottoService.purchaseLotto(money);
        outputView.printLottos(lottos);

        WinningNumber winningNumber = makeWinningNumber();
        LottoResult lottoResult = lottoService.findWinningLottos(lottos, winningNumber);
        outputView.printLottoResult(lottoResult, money);
    }

    private int getMoney() {
        while (true) {
            try {
                int moneyAmount = inputParser.parseMoney(inputView.getMoney());
                inputValidator.validateMoney(moneyAmount);
                return moneyAmount;
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private WinningNumber makeWinningNumber() {
        List<Integer> drawNumbers = getDrawNumbers();

        Integer bonusNumber = getBonusNumber();

        return new WinningNumber(drawNumbers, bonusNumber);
    }

    private List<Integer> getDrawNumbers() {
        while (true) {
            try {
                List<Integer> drawNumbers = inputParser.parseLottoNumbers(inputView.getWinningNumber());
                inputValidator.validateWinningNumbers(drawNumbers);
                return drawNumbers;
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private Integer getBonusNumber() {
        while (true) {
            try {
                Integer bonusNumber = inputParser.parseBonusNumber(inputView.getBonusNumber());
                inputValidator.validateBonusNumber(bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}
