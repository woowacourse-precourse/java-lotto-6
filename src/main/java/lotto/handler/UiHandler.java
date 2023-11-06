package lotto.handler;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Customer;
import lotto.domain.WinningChecker;
import lotto.message.GuideMessage;
import lotto.message.WinningMessage;
import lotto.validator.Validator;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

import static lotto.message.GuideMessage.*;

public class UiHandler {
    private final Validator validator;

    public UiHandler(Validator validator) {
        this.validator = validator;
    }

    public int getAndValidatePayment() {
        System.out.println(GuideMessage.GET_PAYMENT_REQUEST_MESSAGE);

        while (true) {
            try {
                String userInput = Console.readLine();
                return validator.parseAndValidatePayment(userInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> getAndTargetNumbers() {
        System.out.println(GuideMessage.GET_TARGET_NUMBERS_REQUEST_MESSAGE);

        while (true) {
            try {
                String userInput = Console.readLine();
                return validator.parseAndValidateTargetNumbers(userInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getAndValidateBonusNumber(List<Integer> targetNumbers) {
        System.out.println(GuideMessage.GET_BONUS_NUMBER_REQUEST_MESSAGE);

        while (true) {
            try {
                String userInput = Console.readLine();
                int bonusNumber = validator.parseAndValidateBonusNumber(userInput);
                validator.checkDuplicateBonusNumber(targetNumbers, bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void printInfoOfLottos(Customer customer) {
        System.out.println(String.format(SHOW_LOTTOS_INFO_MESSAGE.toString(),
                customer.getCountOfLottos()));

        customer.getInfoOfLottos().stream()
                .forEach(infoOfLotto -> System.out.println(infoOfLotto));

    }

    public void printWinningInfo(WinningChecker winningChecker) {
        System.out.println(WINNING_RESULT_MESSAGE);

        Arrays.stream(WinningMessage.values())
                .map(winningMessage -> createWinningMessage(winningMessage, winningChecker))
                .forEach(message -> System.out.println(message));
    }

    private String createWinningMessage(WinningMessage winningMessage, WinningChecker winningChecker) {
        return String.format(winningMessage.getContent(),
                winningChecker.getRankInfo().getOrDefault(winningMessage.getRank(), 0));
    }

    public void printRateOfProfit(Customer customer, WinningChecker winningChecker) {
        double rateOfProfit = (winningChecker.getTotalWinningAmount() / customer.getPayment()) * 100;
        DecimalFormat df = new DecimalFormat("#.##");
        String roundedNumber = df.format(rateOfProfit);
        System.out.println(String.format(RATE_OF_PROFIT_MESSAGE.toString(), roundedNumber));
    }

}
