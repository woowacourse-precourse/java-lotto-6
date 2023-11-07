package lotto.View;

import static lotto.Utils.Utils.splitWithComma;
import static lotto.Utils.Utils.stringToInteger;
import static lotto.Validator.InputValidator.checkInputBlank;
import static lotto.Validator.InputValidator.checkInputDigit;
import static lotto.Validator.InputValidator.checkInputEmpty;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import lotto.Constants.InputConstants;

public class InputView {

    public static void printInsertMoney() {
        System.out.println(InputConstants.ENTER_MONEY.getMessage());
    }

    public int insertMoney() {
        String money = Console.readLine();
        validateMoney(money);
        return Integer.parseInt(money);
    }

    public static void printInsertLottoNumbers() {
        System.out.println(InputConstants.ENTER_LOTTO_NUMBERS.getMessage());
    }

    public ArrayList<Integer> insertLottoNumbers() {
        String input = Console.readLine();
        validateLottoNumber(input);
        ArrayList<String> inputList = splitWithComma(input);
        validateNumber(inputList);
        return stringToInteger(inputList);
    }

    public void printInsertBonusNumber() {
        System.out.println(InputConstants.ENTER_BONUS_NUMBER.getMessage());
    }

    public int insertBonusNumber() {
        String bonusNumber = Console.readLine();
        validateBonusNumber(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }

    private void validateNumber(ArrayList<String> inputList) {
        for (String s : inputList) {
            checkInputDigit(s);
        }
    }

    private void validateMoney(String input) {
        checkInputEmpty(input);
        checkInputBlank(input);
        checkInputDigit(input);
    }

    private void validateLottoNumber(String input) {
        checkInputEmpty(input);
        checkInputBlank(input);
    }

    private void validateBonusNumber(String input) {
        checkInputEmpty(input);
        checkInputBlank(input);
        checkInputDigit(input);
    }
}
