package lotto.readUserInput;


import camp.nextstep.edu.missionutils.Console;
import lotto.validation.ErrorMessage;
import lotto.validation.ErrorValidation;

public class BonusNumbers implements UserInput {
    public static int number;

    public void read() {
        number = singleTypeConversion(userInput());
    }

    public String userInput() {
        String readNumber = Console.readLine();
        try {
            ErrorValidation.isNumberVerify(readNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.ERROR_BONUS_IS_NUMBER.getMessage());
            readNumber = userInput();
        }
        return readNumber;
    }

    public int singleTypeConversion(String readSingleNumber) {
        int bonusNumber = Integer.parseInt(readSingleNumber);
        try {
            ErrorValidation.isNumberInRange(bonusNumber);
            ErrorValidation.isAlreadyReadNumber(WinningNumbers.numbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.ERROR_BONUS_IN_RANGE_NOT_DUPLICATION.getMessage());
            bonusNumber = Integer.parseInt(userInput());
        }
        return bonusNumber;
    }
}