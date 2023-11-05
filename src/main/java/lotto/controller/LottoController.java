package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoChecker;
import lotto.domain.LottoConstant;
import lotto.domain.LottoNumberGenerator;
import lotto.validator.InputBonusNumberValidator;
import lotto.validator.InputPurchaseAmountValidator;
import lotto.validator.InputWinningLotteryNumberValidator;
import lotto.view.InputConverter;
import lotto.view.InputPreprocessor;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputPurchaseAmountValidator purchaseAmountValidator;
    private final InputPreprocessor preprocessor;
    private final InputConverter converter;
    private final LottoNumberGenerator lottoNumberGenerator;
    private final InputWinningLotteryNumberValidator winningLotteryNumberValidator;
    private final InputBonusNumberValidator bonusNumberValidator;

    public LottoController() {
        this.outputView = new OutputView();
        this.inputView = new InputView(this.outputView);
        this.purchaseAmountValidator = new InputPurchaseAmountValidator();
        this.preprocessor = new InputPreprocessor();
        this.converter = new InputConverter();
        this.lottoNumberGenerator = new LottoNumberGenerator();
        this.winningLotteryNumberValidator = new InputWinningLotteryNumberValidator();
        this.bonusNumberValidator = new InputBonusNumberValidator();
    }

    public void play() {
        int purchaseAmount = getValidatedPurchaseAmount();
        int lottosCount = purchaseLottos(purchaseAmount);

        List<Lotto> lottos = generateLottos(lottosCount);
        outputView.printLottoNumbers(lottos);

        List<Integer> winningLotteryNumbers = getValidatedWinningLotteryNumbers();

        int bonusNumber = getValidatedBonusNumber(winningLotteryNumbers);

        LottoChecker lottoChecker = new LottoChecker(lottos, winningLotteryNumbers, bonusNumber);
        lottoChecker.checkResults();
    }

    private int getValidatedPurchaseAmount() {
        while (true) {
            try {
                String input = receivePurchaseAmount();
                input = trimInput(input);
                purchaseAmountValidator.validate(input);
                return converter.convertToInteger(input);
            } catch (IllegalArgumentException e) {
                outputView.printInputErrorMessage(e.getMessage());
            }
        }
    }

    private String receivePurchaseAmount() {
        return inputView.receivePurchaseAmountInput();
    }

    private String trimInput(String input) {
        return preprocessor.trimInput(input);
    }

    private int purchaseLottos(int purchaseAmount) {
        int lottosCount = calculatePurchaseOfLottos(purchaseAmount);
        outputView.printCountPurchaseLottoMessage(lottosCount);
        return lottosCount;
    }

    private int calculatePurchaseOfLottos(int purchaseAmount) {
        return purchaseAmount / LottoConstant.LOTTO_PRICE.getValue();
    }

    private List<Lotto> generateLottos(int lottosCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottosCount; i++) {
            List<Integer> numbers = lottoNumberGenerator.generateLottoNumbers();
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private List<Integer> getValidatedWinningLotteryNumbers() {
        while (true) {
            try {
                String input = receiveWinningLotteryNumbers();
                List<Integer> validatedNumbers = processAndValidateWinningLotteryNumbers(input);
                return validatedNumbers;
            } catch (IllegalArgumentException e) {
                outputView.printInputErrorMessage(e.getMessage());
            }
        }
    }

    private String receiveWinningLotteryNumbers() {
        return inputView.receiveWinningLotteryNumbersInput();
    }

    private List<Integer> processAndValidateWinningLotteryNumbers(String input) {
        String[] winningLotteryNumbers = splitInputByComma(input);
        return validateAndCollectWinningLotteryNumbers(winningLotteryNumbers);
    }

    private String[] splitInputByComma(String input) {
        return preprocessor.splitInputByComma(input);
    }

    private List<Integer> validateAndCollectWinningLotteryNumbers(String[] winningLotteryNumbers) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String winningLotteryNumber : winningLotteryNumbers) {
            winningLotteryNumber = trimInput(winningLotteryNumber);
            winningLotteryNumberValidator.validate(winningLotteryNumber);
            winningNumbers.add(converter.convertToInteger(winningLotteryNumber));
        }
        winningLotteryNumberValidator.validateSizeAndDuplicatedNumbers(winningNumbers);
        return winningNumbers;
    }
  
    private int getValidatedBonusNumber(List<Integer> winningLotteryNumbers) {
        while (true) {
            try {
                String input = receiveBonusNumber();
                input = trimInput(input);
                bonusNumberValidator.validate(input);
                bonusNumberValidator.validateBonusNumberIsDuplicatedWithWinningLotteryNumbers(input, winningLotteryNumbers);
                return converter.convertToInteger(input);
            } catch (IllegalArgumentException e) {
                outputView.printInputErrorMessage(e.getMessage());
            }
        }
    }
    
    private String receiveBonusNumber() {
        return inputView.receiveBonusNumberInput();
    }

}
