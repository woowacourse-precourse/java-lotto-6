package lotto;

import static lotto.InputValidator.checkInputBlank;
import static lotto.InputValidator.checkInputDigit;
import static lotto.InputValidator.checkInputEmpty;
import static lotto.Utils.splitWithComma;
import static lotto.Utils.stringToInteger;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import lotto.Constants.InputConstants;

public class InputView {

    public static void printInsertMoney() {
        System.out.println(InputConstants.ENTER_MONEY.getMessage());
    }

    private InputView() {

    }

    public static int insertMoney() {
        String money = Console.readLine();
        validateMoney(money);
        return Integer.parseInt(money);
    }

    public static void printInsertLottoNumbers() {
        System.out.println(InputConstants.ENTER_LOTTO_NUMBERS.getMessage());
    }

    public static ArrayList<Integer> insertLottoNumbers() {
        String input = Console.readLine();
        validateLottoNumber(input);
        ArrayList<String> inputList = splitWithComma(input);
        validateNumber(inputList);
        return stringToInteger(inputList);
    }

    public static void printBonusNumber() {
        System.out.println(InputConstants.ENTER_BONUS_NUMBER.getMessage());
    }

    public static int insertBonusNumber() {
        String bonusNumber = Console.readLine();
        validateBonusNumber(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }

    private static void validateNumber(ArrayList<String> inputList) {
        for (String s : inputList) {
            checkInputDigit(s);
        }
    }

    private static void validateMoney(String input) {
        checkInputEmpty(input);
        checkInputBlank(input);
        checkInputDigit(input);
    }

    private static void validateLottoNumber(String input) {
        checkInputEmpty(input);
        checkInputBlank(input);
    }

    private static void validateBonusNumber(String input) {
        checkInputEmpty(input);
        checkInputBlank(input);
        checkInputDigit(input);
    }
}
