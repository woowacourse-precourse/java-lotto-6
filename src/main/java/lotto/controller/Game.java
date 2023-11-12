package lotto.controller;

import static lotto.domain.lotto_prize.FixedLottoPrizeStandard.FIVE_NUMBER_WITH_BONUS;
import static lotto.util.MessageBuilder.buildBonusNumberMessage;
import static lotto.util.MessageBuilder.buildDividerMessage;
import static lotto.util.MessageBuilder.buildGenerateLotteriesResultMessage;
import static lotto.util.MessageBuilder.buildLottoResultMessage;
import static lotto.util.MessageBuilder.buildLottoResultWithBonusMessage;
import static lotto.util.MessageBuilder.buildPurchaseAmountMessage;
import static lotto.util.MessageBuilder.buildPurchaseQuantityMessage;
import static lotto.util.MessageBuilder.buildTotalReturnRateMessage;
import static lotto.util.MessageBuilder.buildWinningNumberMessage;
import static lotto.util.MessageBuilder.buildWinningStatisticsMessage;
import static lotto.util.Parser.parseBonusNumber;
import static lotto.util.Parser.parseLottoPurchaseAmount;
import static lotto.util.Parser.parseWinningNumbers;
import static lotto.validator.InputValidator.validateBonusNumber;
import static lotto.validator.InputValidator.validateDuplicateNumber;
import static lotto.validator.InputValidator.validateEmptyValue;
import static lotto.validator.InputValidator.validateLottoNumberCount;
import static lotto.validator.InputValidator.validateLottoNumberRange;
import static lotto.validator.InputValidator.validateMultipleNumberOfThousand;
import static lotto.validator.InputValidator.validateNumericValue;
import static lotto.validator.InputValidator.validateWinningNumberFormat;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lotto.domain.lotto.LottoManager;
import lotto.domain.lotto_policy.FixedLottoWinningPolicy;
import lotto.domain.lotto_prize.FixedLottoPrizeStandard;
import lotto.validator.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;


public class Game implements Runnable {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoManager lottoManager;

    public Game(InputView inputView, OutputView outputView, LottoManager lottoManager) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoManager = lottoManager;
    }

    private void printNewLine() {
        outputView.newLine();
    }

    private void printEnteringLottoPurchaseAmount() {
        outputView.print(buildPurchaseAmountMessage());
    }

    private void getLottoPurchaseAmount() {
        String value = inputView.getLine();
        validateEmptyValue(value);
        validateNumericValue(value);

        Integer purchaseAmount = parseLottoPurchaseAmount(value);
        validateMultipleNumberOfThousand(purchaseAmount);

        lottoManager.generateLotteries(purchaseAmount);
    }

    private void printPurchaseQuantity() {
        String message = buildPurchaseQuantityMessage(lottoManager.getPurchaseQuantity());
        outputView.print(message);
    }

    private void printGenerateLotteriesResult() {
        String message = buildGenerateLotteriesResultMessage(lottoManager.getLotteriesNumbers());
        outputView.print(message);
    }

    private void printEnteringWinningNumber() {
        outputView.print(buildWinningNumberMessage());
    }

    private void getWinningNumber() {
        String value = inputView.getLine();
        validateEmptyValue(value);
        validateWinningNumberFormat(value);

        List<Integer> winningNumbers = parseWinningNumbers(value);
        validateDuplicateNumber(winningNumbers);
        validateLottoNumberCount(winningNumbers);
        winningNumbers.forEach(InputValidator::validateLottoNumberRange);

        lottoManager.setWinningNumbers(winningNumbers);
    }

    private void printEnteringBonusNumber() {
        outputView.print(buildBonusNumberMessage());
    }

    private void getBonusNumber() {
        String value = inputView.getLine();
        validateEmptyValue(value);
        validateNumericValue(value);

        Integer bonusNumber = parseBonusNumber(value);
        validateLottoNumberRange(bonusNumber);
        validateBonusNumber(lottoManager.getWinningNumbers(), bonusNumber);

        lottoManager.setFixedLottoWinningPolicy(new FixedLottoWinningPolicy(bonusNumber));
    }

    private void printWinningStatisticsMessage() {
        outputView.print(buildWinningStatisticsMessage());
    }

    private void printDivider() {
        outputView.print(buildDividerMessage());
    }

    private void buildWinningResultMessage(StringBuilder sb,
                                           Entry<FixedLottoPrizeStandard, Integer> lottoWinningResult) {
        Long matchCount = lottoWinningResult.getKey().getMatchCount();
        Integer prize = lottoWinningResult.getKey().getPrize();
        Integer winning = lottoWinningResult.getValue();

        if (lottoWinningResult.getKey().equals(FIVE_NUMBER_WITH_BONUS)) {
            sb.append(buildLottoResultWithBonusMessage(matchCount, prize, winning));
            return;
        }

        sb.append(buildLottoResultMessage(matchCount, prize, winning));
    }

    private StringBuilder getWinningResultsMessage(Map<FixedLottoPrizeStandard, Integer> lottoWinningResults) {
        StringBuilder sb = new StringBuilder();
        lottoWinningResults.entrySet()
                .forEach(lottoWinningResult -> buildWinningResultMessage(sb, lottoWinningResult));
        return sb;
    }

    private void printWinningResult() {
        Map<FixedLottoPrizeStandard, Integer> lottoWinningResults =
                lottoManager.getLottoWinningResults();
        StringBuilder sb = getWinningResultsMessage(lottoWinningResults);
        outputView.print(sb.toString());
    }

    private void printReturnRate() {
        Double totalReturnRate = lottoManager.getTotalReturnRate();
        outputView.print(buildTotalReturnRateMessage(totalReturnRate));
    }

    private void end() {
        inputView.close();
    }

    private void lottoPurchaseProcess() {
        printEnteringLottoPurchaseAmount();
        getLottoPurchaseAmount();
        printNewLine();
    }

    private void printWinningResultProcess() {
        printWinningStatisticsMessage();
        printDivider();
        printWinningResult();
    }

    private void bonusNumberGettingProcess() {
        printEnteringBonusNumber();
        getBonusNumber();
        printNewLine();
    }

    private void winningNumberGettingProcess() {
        printEnteringWinningNumber();
        getWinningNumber();
        printNewLine();
    }

    private void lottoGenerateProcess() {
        printPurchaseQuantity();
        printGenerateLotteriesResult();
        printNewLine();
        printNewLine();
    }

    @Override
    public void run() {
        lottoPurchaseProcess();
        lottoGenerateProcess();
        winningNumberGettingProcess();
        bonusNumberGettingProcess();
        printWinningResultProcess();
        printReturnRate();
        end();
    }
}
