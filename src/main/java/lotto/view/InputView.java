package lotto.view;

import static lotto.constant.InputViewConstant.BONUS_NUMBER_MESSAGE;
import static lotto.constant.InputViewConstant.START_MESSAGE;
import static lotto.constant.InputViewConstant.WINNING_NUMBER_MESSAGE;
import static lotto.util.InputValidation.validateCommaSeparatedInput;
import static lotto.util.InputValidation.validateDuplicateBonusNumber;
import static lotto.util.InputValidation.validateDuplicateValues;
import static lotto.util.InputValidation.validateEmptyInput;
import static lotto.util.InputValidation.validateInputRange;
import static lotto.util.InputValidation.validateInputSize;
import static lotto.util.InputValidation.validateMoneyInput;
import static lotto.util.InputValidation.validationStringInput;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static int inputMoney;
    public static String winningNumber;
    public static int bonusNumber;

    public static void setStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static int setInputMoney() {
        boolean validInput = false;

        while (!validInput) {
            try {
                String input = Console.readLine();
                validateEmptyInput(input);
                validationStringInput(input);

                inputMoney = Integer.parseInt(input);
                validateMoneyInput(inputMoney);

                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return inputMoney;
    }

    public static void setWinningNumberMessage() {
        System.out.println("\n" + WINNING_NUMBER_MESSAGE);
    }

    public static String setWinningNumber() {
        boolean validInput = false;

        while (!validInput) {
            try {
                winningNumber = Console.readLine();
                validateEmptyInput(winningNumber);
                validateCommaSeparatedInput(winningNumber);
                validateInputSize(winningNumber);
                validateInputRange(winningNumber);
                validateDuplicateValues(winningNumber);

                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return winningNumber;
    }

    public static void setBonusNumberMessage() {
        System.out.println("\n" + BONUS_NUMBER_MESSAGE);
    }

    public static int setBonusNumber() {
        boolean validInput = false;

        while (!validInput) {
            try {
                String bonusInput = Console.readLine();
                validateEmptyInput(bonusInput);
                validationStringInput(bonusInput);
                validateInputRange(bonusInput);
                validateDuplicateBonusNumber(winningNumber, bonusInput);

                bonusNumber = Integer.parseInt(bonusInput);

                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return bonusNumber;
    }
}
