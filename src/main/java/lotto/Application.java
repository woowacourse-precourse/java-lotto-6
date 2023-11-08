package lotto;

import user.User;
import util.InputUtil;

import java.util.ArrayList;
import java.util.List;

import static constants.LottoInputConstants.*;
import static validate.InputValidation.*;
import static validate.InputValidation.validateLottoNumberRange;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseAmount = getInputToPurchaseAmount();
        User user = new User(purchaseAmount);
        user.printLottoNumbers();

        List<Integer> resultNumbers = getInputToResultNumbers();
        int bonusNumber = getInputToBonusNumber(resultNumbers);
        LottoResult result = new LottoResult(resultNumbers, bonusNumber);

        user.matchLottoNumbers(result);
        user.printWinningStatistics();
        user.printProfitRate();
    }

    private static int getInputToPurchaseAmount() {
        int purchaseAmount = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                String input = InputUtil.getUserInput(PURCHASE_AMOUNT_PROMPT);
                purchaseAmount = validateAndGetPurchaseAmount(input);
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return purchaseAmount;
    }

    private static int validateAndGetPurchaseAmount(String input) {
        validateNumericInput(input);
        return Integer.parseInt(input);
    }

    private static int getInputToBonusNumber(List<Integer> resultNumbers) {
        int bonusNumber = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                String input = InputUtil.getUserInput(BONUS_NUMBER_PROMPT);
                bonusNumber = validateAndGetBonusNumber(resultNumbers, input);
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNumber;
    }

    public static int validateAndGetBonusNumber(List<Integer> resultNumbers, String input) {
        validateNumericInput(input);
        int number = Integer.parseInt(input);
        validateNoDuplicateNumbers(resultNumbers, number);
        validateLottoNumberRange(number);
        return number;
    }

    private static List<Integer> getInputToResultNumbers() {
        List<Integer> list = new ArrayList<>();
        boolean validInput = false;

        while (!validInput) {
            try {
                String input = InputUtil.getUserInput(WINNING_NUMBER_PROMPT);
                list = validateAndGetResultNumbers(input);
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return list;
    }

    private static List<Integer> validateAndGetResultNumbers(String input) {
        List<Integer> list = new ArrayList<>();
        String[] numbers = input.split(",");
        for (String number : numbers) {
            validateNumericInput(number);
            int lottoNumber = Integer.parseInt(number.trim());
            validateLottoNumberRange(lottoNumber);
            list.add(lottoNumber);
        }
        return list;
    }

}
