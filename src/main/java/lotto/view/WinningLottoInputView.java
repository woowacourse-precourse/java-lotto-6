package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.exception.WrongBonusNumberInputFormatException;
import lotto.exception.WrongLottoInputFormatException;
import lotto.exception.WrongMoneyInputFormatException;

public class WinningLottoInputView {



    private static final String WINNIG_LOTTO_NUMBERS_REGEX = "^(?:[1-9]|[1-3][0-9]|4[0-5])(,(?:[1-9]|[1-3][0-9]|4[0-5])){5}$";
    private static final String BONUS_NUMBER_REGEX = "(?:[1-9]|[1-3][0-9]|4[0-5])";

    public static List<String> inputWinningLottoNumbers() {
        ConsoleMessageView.printWinningLottoNumbersInputMessage();
        String winningLottoInput = Console.readLine();

        try {
            validateWinningLottoInput(winningLottoInput);
        }
        catch (WrongLottoInputFormatException e) {
            ErrorMessageView.print(e.getMessage());
            inputWinningLottoNumbers();
        }

        return Arrays.stream(winningLottoInput.split(","))
                     .toList();
    }

    public static String inputBonusNumber() {

        ConsoleMessageView.printBonusNumberInputMessage();

        String bonusNumberInput = Console.readLine();

        try {
            validateWinningLottoInput(bonusNumberInput);
        }
        catch (WrongLottoInputFormatException e) {
            ErrorMessageView.print(e.getMessage());
            inputWinningLottoNumbers();
        }

        return bonusNumberInput;
    }

    private static void validateWinningLottoInput(String winningLottoInput) {
        Pattern pattern = Pattern.compile(WINNIG_LOTTO_NUMBERS_REGEX);
        Matcher matcher = pattern.matcher(winningLottoInput);

        if (!matcher.find()) {
            throw new WrongLottoInputFormatException();
        }
    }

    private static void validateBonusNumberInput(String bonusNumberInput) {
        Pattern pattern = Pattern.compile(BONUS_NUMBER_REGEX);
        Matcher matcher = pattern.matcher(bonusNumberInput);

        if (!matcher.find()) {
            throw new WrongBonusNumberInputFormatException();
        }
    }

}
