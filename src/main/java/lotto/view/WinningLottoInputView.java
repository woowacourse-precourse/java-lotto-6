package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.exception.WrongBonusNumberInputFormatException;
import lotto.exception.WrongLottoInputFormatException;
import lotto.validator.InputValidator;

public class WinningLottoInputView extends InputValidator {


    private static final String WINNIG_LOTTO_NUMBERS_REGEX = "^(?:[1-9]|[1-3][0-9]|4[0-5])(,(?:[1-9]|[1-3][0-9]|4[0-5])){5}$";
    private static final String BONUS_NUMBER_REGEX = "(?:[1-9]|[1-3][0-9]|4[0-5])";

    public static List<String> inputWinningLottoNumbers() {
        ConsoleMessageView.printWinningLottoNumbersInputMessage();
        String winningLottoInput = Console.readLine();

        try {
            validate(winningLottoInput, WINNIG_LOTTO_NUMBERS_REGEX, new WrongLottoInputFormatException());
        } catch (WrongLottoInputFormatException e) {
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

            validate(bonusNumberInput, BONUS_NUMBER_REGEX, new WrongBonusNumberInputFormatException());

        } catch (WrongLottoInputFormatException e) {

            ErrorMessageView.print(e.getMessage());

            inputWinningLottoNumbers();

        }

        return bonusNumberInput;
    }


}
