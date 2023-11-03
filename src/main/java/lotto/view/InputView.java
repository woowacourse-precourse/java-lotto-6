package lotto.view;

import static lotto.utils.InputValidator.blankCheck;
import static lotto.utils.InputValidator.lottoFormatCheck;
import static lotto.utils.InputValidator.lottoNumberRangeCheck;
import static lotto.utils.InputValidator.nullCheck;
import static lotto.utils.InputValidator.numberTypeCheck;

import camp.nextstep.edu.missionutils.Console;

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

    public static String bonusNumberInput() {
        String bonus = input();

        validateNullAndBlankCheck(bonus);
        numberTypeCheck(bonus);
        lottoNumberRangeCheck(bonus);

        return bonus;
    }


    private static void validateNullAndBlankCheck(String inputValue) {
        nullCheck(inputValue);
        blankCheck(inputValue);
    }

}
