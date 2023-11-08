package lotto.controller;

import lotto.AppConfig;
import lotto.model.Lotto;
import lotto.service.LottoGenerator;
import lotto.service.LottoMatchChecker;
import lotto.service.LottoProfitCalculator;
import lotto.validator.BonusNumberValidator;
import lotto.validator.Validator;
import lotto.view.View;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constants.ExceptionMessage.BLANK_ERROR;
import static lotto.constants.ExceptionMessage.NOT_NUMERIC_ERROR;
import static lotto.constants.LottoValidationPattern.DELIMITER;

public class LottoController {

    private final View view;
    private final LottoGenerator lottoGenerator;
    private final LottoProfitCalculator lottoProfitCalculator;
    private final Validator payAmountValidator;
    private final Validator winningNumbersValidator;
    private BonusNumberValidator bonusNumberValidator;

    public LottoController(AppConfig appConfig) {
        this.view = appConfig.createView();
        this.lottoGenerator = appConfig.createLottoGenerator();
        this.lottoProfitCalculator = appConfig.createLottoProfitCalculator();
        this.payAmountValidator = appConfig.createPayAmountValidator();
        this.winningNumbersValidator = appConfig.createWinningNumbersValidator();
    }

    public void playLotto() {
        int purchaseAmount = obtainValidatedPurchaseAmount();
        List<Lotto> lottoTickets = lottoGenerator.issueTickets(purchaseAmount);
        view.printPurchasedTickets(lottoTickets.size());
        lottoTickets.forEach(ticket -> view.printMessage(ticket.toString()));

        List<Integer> winningNumbers = obtainValidatedWinningNumbers();
        int bonusNumber = obtainValidatedBonusNumber(winningNumbers);

        LottoMatchChecker matchChecker = new LottoMatchChecker(winningNumbers, bonusNumber);
        int[] matchCounts = matchChecker.checkMatches(lottoTickets);
        double profitRate = lottoProfitCalculator.calculateProfitRate(matchCounts, purchaseAmount);

        view.printMatchStatistics(matchCounts, profitRate);
    }

    private int obtainValidatedPurchaseAmount() {
        while (true) {
            try {
                view.printPurchaseAmountPrompt();
                String input = view.inputValue();
                payAmountValidator.validate(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                view.printMessage(e.getMessage());
            }
        }
    }

    private List<Integer> obtainValidatedWinningNumbers() {
        while (true) {
            try {
                view.printWinningNumberPrompt();
                String input = view.inputValue();
                winningNumbersValidator.validate(input);
                return convertToList(input);
            } catch (IllegalArgumentException e) {
                view.printMessage(e.getMessage());
            }
        }
    }

    private int obtainValidatedBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                view.printBonusNumberPrompt();
                String input = view.inputValue();
                bonusNumberValidator = new BonusNumberValidator(winningNumbers);
                bonusNumberValidator.validate(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                view.printMessage(e.getMessage());
            }
        }
    }

    private List<Integer> convertToList(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(BLANK_ERROR.message());
        }

        return Arrays.stream(input.split(DELIMITER.pattern()))
                .map(String::trim)
                .map(this::parseNumber)
                .collect(Collectors.toList());
    }

    private int parseNumber(String numberStr) {
        try {
            return Integer.parseInt(numberStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC_ERROR.message());
        }
    }
}