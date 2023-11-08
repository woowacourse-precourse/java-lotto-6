package lotto;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.WinningStatus;
import lotto.service.LottoService;
import lotto.service.RateOfReturnCalculationService;
import lotto.service.WinningCalculationService;
import lotto.util.CommaSeparatedStringParser;
import lotto.util.RandomSortedLottoNumberGenerator;
import lotto.validation.BonusNumberInputValidator;
import lotto.validation.PriceInputValidator;
import lotto.validation.WinningNumbersInputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameManager {
    private static final int PRICE_PER_TICKET = 1000;
    private long totalPrice;
    private int lottoQuantity;
    private List<Lotto> lottos;
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private Map<WinningStatus, Integer> statistics;
    private double rateOfReturn;

    private final LottoService lottoService;
    private final WinningCalculationService winningCalculationService;
    private final RateOfReturnCalculationService rateOfReturnCalculationService;

    public LottoGameManager(LottoService lottoService, WinningCalculationService winningCalculationService,
                            RateOfReturnCalculationService rateOfReturnCalculationService) {
        this.lottoService = lottoService;
        this.winningCalculationService = winningCalculationService;
        this.rateOfReturnCalculationService = rateOfReturnCalculationService;
    }

    public void run() {
        inputPrice();
        generateLottos();
        inputWinningNumber();
        inputBonusLottoNumber();
        calculatePrizes();
        calculateRateOfReturn();
    }

    private void inputPrice() {
        boolean validInput = false;
        while (!validInput) {
            try {
                String totalPriceInput = InputView.inputPurchasePrice();
                PriceInputValidator.validate(totalPriceInput);
                totalPrice = Integer.parseInt(totalPriceInput);
                lottoQuantity = (int) (totalPrice / PRICE_PER_TICKET);
                validInput = true;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void generateLottos() {
        for (int i = 0; i < lottoQuantity; i++) {
            Lotto lotto = new Lotto(RandomSortedLottoNumberGenerator.generateSortedLotto());
            lottoService.recordLotto(lotto);
        }
        lottos = lottoService.getAllLottoRecord();
        OutputView.printGeneratedLotto(lottos);
    }

    private void inputWinningNumber() {
        boolean validInput = false;
        while (!validInput) {
            try {
                String winningNumbersInput = InputView.inputWinningNumbers();
                WinningNumbersInputValidator.validate(winningNumbersInput);
                winningNumbers = CommaSeparatedStringParser.parse(winningNumbersInput);
                validInput = true;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void inputBonusLottoNumber() {
        boolean validInput = false;
        while (!validInput) {
            try {
                String bonusNumberInput = InputView.inputBonusNumber();
                BonusNumberInputValidator.validate(bonusNumberInput, winningNumbers);
                bonusNumber = Integer.parseInt(bonusNumberInput);
                validInput = true;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void calculatePrizes() {
        statistics = winningCalculationService.calculateWinningStatistics(winningNumbers, bonusNumber);
        OutputView.printWinningStatistics(statistics);
    }

    private void calculateRateOfReturn() {
        rateOfReturn = rateOfReturnCalculationService.calculateRateOfReturn(totalPrice, statistics);
        OutputView.printRateOfReturn(rateOfReturn);
    }
}
