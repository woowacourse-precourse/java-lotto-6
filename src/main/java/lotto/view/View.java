package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.IO.Input;
import lotto.IO.Output;
import lotto.rule.LottoWinningRule;
import lotto.util.validator.InputValidator;

public class View {
    private final Input input;

    public View(Input input) {
        this.input = input;
    }

    public String inputLottoCost() {
        Output.writeLine(OutputMessage.REQUEST_LOTTO_COST.getMessage());
        String userInputLottoCost = input.readLine();
        InputValidator.validateBlank(userInputLottoCost);
        InputValidator.validateNumeric(userInputLottoCost);
        return userInputLottoCost;
    }

    public String inputWinningNumbers() {
        Output.writeLine(OutputMessage.REQUEST_WINNING_NUMBERS.getMessage());
        String userInputWinningNumbers = input.readLine();
        InputValidator.validateBlank(userInputWinningNumbers);
        return userInputWinningNumbers;
    }

    public String inputBonusNumber() {
        Output.writeLine(OutputMessage.REQUEST_BONUS_NUMBER.getMessage());
        String userInputBonusNumber = input.readLine();
        InputValidator.validateBlank(userInputBonusNumber);
        InputValidator.validateNumeric(userInputBonusNumber);
        return userInputBonusNumber;
    }

    public void outputPublishedLotto(List<String> publishedLotto) {
        Output.writeLine(publishedLotto.size() + OutputMessage.RESPONSE_PURCHASED_LOTTO_AMOUNT.getMessage());
        Output.writeLine(convertPublishedLotto(publishedLotto));
    }

    private String convertPublishedLotto(List<String> publishedLotto) {
        StringBuilder shownPublishedLotto = new StringBuilder(publishedLotto.size());
        for (String lottoNumbers : publishedLotto) {
            shownPublishedLotto.append(lottoNumbers).append(OutputMessage.LINE_BREAKING.getMessage());
        }
        return shownPublishedLotto.toString();
    }

    public void outputWinningDetails(Map<LottoWinningRule, Integer> winningDetails) {
        Output.writeLine(OutputMessage.WINNING_DETAILS_TITLE.getMessage());
        Output.writeLine(convertWinningDetails(winningDetails));
    }

    private String convertWinningDetails(Map<LottoWinningRule, Integer> winningDetails) {
        StringBuilder shownWinningDetails = new StringBuilder(winningDetails.size());
        for (LottoWinningRule rule : winningDetails.keySet()) {
            shownWinningDetails
                    .append(String.format(rule.getInformation(), winningDetails.get(rule)))
                    .append(OutputMessage.LINE_BREAKING.getMessage());
        }
        return shownWinningDetails.toString().trim();
    }

    public void outputEarningsRate(String earningsRate) {
        Output.writeLine(String.format(OutputMessage.RESPONSE_EARNINGS_RATE.getMessage(), earningsRate));
    }

    public void outputErrorMessage(IllegalArgumentException e) {
        Output.writeLine(e.getMessage());
    }
}
