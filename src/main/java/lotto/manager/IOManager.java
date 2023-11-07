package lotto.manager;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.InputValidator;
import java.util.ArrayList;
import java.util.List;
import static lotto.utility.StringUtil.*;

public class IOManager {

    private static IOManager ioManager;

    private IOManager() {

    }

    public static IOManager getInstance() {
        if (ioManager == null) {
            ioManager = new IOManager();
        }

        return ioManager;
    }

    public void printPayAmountInputGuide() {
        System.out.println(ENTER_PAY_AMOUNT.getMessage());
    }

    public void printWiningNumberInputGuide() {
        System.out.println(ENTER_WINNING_NUMBER.getMessage());
    }

    public void printWinningBonusNumberInputGuide() {
        System.out.println(ENTER_BONUS_NUMBER.getMessage());
    }

    public void printWinningStatisticsGuide() {
        System.out.println(PRINT_WINNING_STATISTICS_PHRASES.getMessage());
    }

    public void printExceptionMessage(String message) {
        System.out.println(message);
    }

    public int readPayAmount() {
        String inputPayAmount = Console.readLine().replaceAll("\\s", "");

        if (InputValidator.isEmpty(inputPayAmount))
            throw new IllegalArgumentException(PRINT_ERR_PAY_AMOUNT_IS_EMPTY.getMessage());
        if (!InputValidator.isDigit(inputPayAmount))
            throw new IllegalArgumentException(PRINT_ERR_PAY_AMOUNT_NOT_DIGIT.getMessage());

        int payAmount = Integer.parseInt(inputPayAmount);

        if ( !InputValidator.isMultipleOfUnit(payAmount) )
            throw new IllegalArgumentException(PRINT_ERR_PAY_AMOUNT_INVALID_UNIT_INTERVER.getMessage());

        return payAmount;
    }

    public List<Integer> readWinningNumber() {
        String[] inputWinningNumber = Console.readLine().replaceAll("\\s", "").split(",");
        List<Integer> winningNumber = new ArrayList<>();

        winningNumberCondition(inputWinningNumber, winningNumber);

        return winningNumber;
    }

    public void winningNumberCondition(String[] inputWinningNumber, List<Integer> winningNumber) {
        if (!InputValidator.isDigit(inputWinningNumber))
            throw new IllegalArgumentException(PRINT_ERR_NUMBER_NOT_DIGIT.getMessage());

        for(String element: inputWinningNumber)
            winningNumber.add(Integer.parseInt(element));

        if (!InputValidator.isValidNumberRange(winningNumber))
            throw new IllegalArgumentException(PRINT_ERR_NUMBER_INVALID_RANGE.getMessage());
        if (!InputValidator.isValidNumberCount(winningNumber))
            throw new IllegalArgumentException(PRINT_ERR_NUMBER_INVALID_COUNT.getMessage());
        if (InputValidator.hasDuplicates(winningNumber)) {
            throw new IllegalArgumentException(PRINT_ERR_WINNING_NUMBER_DUPLICATE.getMessage());
        }
    }

    public int readWinningBonusNumber() {
        String inputBonusNumber = Console.readLine();
        int bonusNumber;

        if (!InputValidator.isDigit(inputBonusNumber)) {
            throw new IllegalArgumentException(PRINT_ERR_NUMBER_NOT_DIGIT.getMessage());
        }

        bonusNumber = Integer.parseInt(inputBonusNumber);

        if (!InputValidator.isValidNumberRange(bonusNumber)) {
            throw new IllegalArgumentException(PRINT_ERR_NUMBER_INVALID_RANGE.getMessage());
        }

        return bonusNumber;
    }
}
