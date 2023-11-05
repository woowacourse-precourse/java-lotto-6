package lotto.controller;

import static lotto.domain.lotto_prize.FixedLottoPrizeStandard.FIVE_NUMBER_WITH_BONUS;
import static lotto.util.ConstantMessageBuilder.buildBonusNumberMessage;
import static lotto.util.ConstantMessageBuilder.buildDividerMessage;
import static lotto.util.ConstantMessageBuilder.buildGenerateLotteriesResultMessage;
import static lotto.util.ConstantMessageBuilder.buildLottoResultMessage;
import static lotto.util.ConstantMessageBuilder.buildLottoResultWithBonusMessage;
import static lotto.util.ConstantMessageBuilder.buildPurchaseAmountMessage;
import static lotto.util.ConstantMessageBuilder.buildPurchaseQuantityMessage;
import static lotto.util.ConstantMessageBuilder.buildTotalReturnRateMessage;
import static lotto.util.ConstantMessageBuilder.buildWinningNumberMessage;
import static lotto.util.ConstantMessageBuilder.buildWinningStatisticsMessage;
import static lotto.util.Parser.parseBonusNumber;
import static lotto.util.Parser.parseLottoPurchaseAmount;
import static lotto.util.Parser.parseWinningNumbers;
import static lotto.validator.InputValidator.validateEmptyValue;
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

public class Game {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoManager lottoManager;

    public Game(InputView inputView, OutputView outputView, LottoManager lottoManager) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoManager = lottoManager;
    }

    private void printNewLine(){
        outputView.newLine();
    }

    private void printEnteringLottoPurchaseAmount(){
        outputView.print(buildPurchaseAmountMessage());
    }

    private void getLottoPurchaseAmount(){
        String value = inputView.getLine();
        validateEmptyValue(value);
        validateNumericValue(value);

        Integer purchaseAmount = parseLottoPurchaseAmount(value);
        validateMultipleNumberOfThousand(purchaseAmount);

        lottoManager.generateLotteries(purchaseAmount);
    }

    private void printPurchaseQuantity(){
        String message = buildPurchaseQuantityMessage(lottoManager.getPurchaseQuantity());
        outputView.print(message);
    }

    private void printGenerateLotteriesResult(){
        String message = buildGenerateLotteriesResultMessage(lottoManager.getLotteriesNumbers());
        outputView.print(message);
    }

    private void printEnteringWinningNumber(){
        outputView.print(buildWinningNumberMessage());
    }

    private void getWinningNumber(){
        String value = inputView.getLine();
        validateEmptyValue(value);
        validateWinningNumberFormat(value);

        List<Integer> winningNumbers = parseWinningNumbers(value);
        winningNumbers.forEach(InputValidator::validateLottoNumberRange);

        lottoManager.setWinningNumbers(winningNumbers);
    }

    private void printEnteringBonusNumber(){
        outputView.print(buildBonusNumberMessage());
    }

    private void getBonusNumber(){
        String value = inputView.getLine();
        validateEmptyValue(value);
        validateNumericValue(value);

        Integer bonusNumber = parseBonusNumber(value);
        validateLottoNumberRange(bonusNumber);

        lottoManager.setFixedLottoWinningPolicy(new FixedLottoWinningPolicy(bonusNumber));
    }

    private void printWinningStatisticsMessage(){
        outputView.print(buildWinningStatisticsMessage());
    }

    private void printDivider(){
        outputView.print(buildDividerMessage());
    }

    private void printWinningResult(){
        Map<FixedLottoPrizeStandard, Integer> lottoWinningResults =
                lottoManager.getLottoWinningResults();

        StringBuilder sb=new StringBuilder();
        for (Entry<FixedLottoPrizeStandard, Integer> lottoWinningResult : lottoWinningResults.entrySet()) {
            Long matchCount = lottoWinningResult.getKey().getMatchCount();
            Integer prize = lottoWinningResult.getKey().getPrize();
            Integer winning = lottoWinningResult.getValue();

            if(lottoWinningResult.getKey().equals(FIVE_NUMBER_WITH_BONUS)){
                sb.append(buildLottoResultWithBonusMessage(matchCount, prize, winning));
                continue;
            }

            sb.append(buildLottoResultMessage(matchCount, prize, winning));
        }

        outputView.print(sb.toString());
    }

    private void printReturnRate(){
        Double totalReturnRate = lottoManager.getTotalReturnRate();
        outputView.print(buildTotalReturnRateMessage(totalReturnRate));
    }

    private void end(){
        inputView.close();
    }

    public void start(){
        printEnteringLottoPurchaseAmount();
        getLottoPurchaseAmount();
        printNewLine();

        printPurchaseQuantity();
        printGenerateLotteriesResult();
        printNewLine();

        printEnteringWinningNumber();
        getWinningNumber();
        printNewLine();

        printEnteringBonusNumber();
        getBonusNumber();
        printNewLine();

        printWinningStatisticsMessage();
        printDivider();
        printWinningResult();

        printReturnRate();

        end();
    }
}
