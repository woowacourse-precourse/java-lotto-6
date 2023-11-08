package lotto.controller;

import static lotto.util.Introduction.INPUT_AMOUNT_OF_LOTTO;
import static lotto.util.Introduction.INPUT_BONUS_NUMBER;
import static lotto.util.Introduction.INPUT_WINNING_NUMBERS;

import java.util.Comparator;
import java.util.List;
import lotto.model.data.Lotto;
import lotto.model.data.WinningPortfolio;
import lotto.model.generator.LottoNumberGenerator;
import lotto.model.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private LottoService lottoService;

    private LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        lottoService = new LottoService();
    }

    public static LottoController of(InputView inputView, OutputView outputView) {
        return new LottoController(inputView, outputView);
    }

    public void runLottoStore(LottoNumberGenerator lottoNumberGenerator, Comparator<Integer> order) {
        payMoney(lottoNumberGenerator, order);
        drawNumber();
        printWinning();
    }

    private void payMoney(LottoNumberGenerator lottoNumberGenerator, Comparator<Integer> order) {
        while (true) {
            try {
                Integer numberOfLotto = getNumberOfLotto();
                createLottos(numberOfLotto, lottoNumberGenerator, order);

                break;
            } catch (IllegalArgumentException e) {
                outputView.printException(e.getMessage());
            }
        }
    }

    private void drawNumber() {
        List<Integer> winningNumbers = getWinningNumbers();
        Integer bonusNumber = getBonusNumber(winningNumbers);

        lottoService.createWinningNumbers(winningNumbers, bonusNumber);
    }

    private void printWinning() {
        WinningPortfolio winningPortfolio = lottoService.evaluateWinnings();
        outputView.printWinningStatistics(winningPortfolio);
    }

    private Integer getNumberOfLotto() {
        outputView.printIntroduction(INPUT_AMOUNT_OF_LOTTO.getIntroduction());
        int amountOfInvestment = lottoService.validateAndConvertInvestmentAmount(inputView.inputConstant());

        return lottoService.calculateNumberOfLottos(amountOfInvestment);
    }

    private void createLottos(Integer numberOfLotto, LottoNumberGenerator lottoNumberGenerator,
                              Comparator<Integer> order) {
        List<Lotto> purchasedLottos = lottoService.purchaseLottos(numberOfLotto, lottoNumberGenerator, order);
        outputView.printLottos(purchasedLottos);
    }

    private List<Integer> getWinningNumbers() {
        while (true) {
            try {
                outputView.printIntroduction(INPUT_WINNING_NUMBERS.getIntroduction());

                return lottoService.validateAndConvertWinningNumbers(inputView.inputList());
            } catch (IllegalArgumentException e) {
                outputView.printException(e.getMessage());
            }
        }
    }

    private Integer getBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                outputView.printIntroduction(INPUT_BONUS_NUMBER.getIntroduction());

                return lottoService.validateAndConvertBonusNumber(inputView.inputConstant(), winningNumbers);
            } catch (IllegalArgumentException e) {
                outputView.printException(e.getMessage());
            }
        }
    }
}
