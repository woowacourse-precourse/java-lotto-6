package lotto.view;

import static lotto.utils.InputValidator.lottoFormatCheck;
import static lotto.utils.InputValidator.numberTypeCheck;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.InputValidator;

public class InputView {

    public InputView() {
    }

    private static String input() {
        return Console.readLine();
    }

    public static String amountInput() {
        String amount = input();

        validateNullAndBlankCheck(amount);
        numberTypeCheck(amount);

        return amount;
    }

    public static String winLottoNumberInput() {
        String winLottoNumber = input();

        validateNullAndBlankCheck(winLottoNumber);
        lottoFormatCheck(winLottoNumber);
        
        return winLottoNumber;
    }

    private static void validateNullAndBlankCheck(String inputValue) {
        InputValidator.nullCheck(inputValue);
        InputValidator.blankCheck(inputValue);
    }

}
