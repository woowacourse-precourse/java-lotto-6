package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class InputView {

    private final InputValidator inputValidator;

    public InputView(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

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
        ArrayList<String> inputList = new ArrayList<>(Arrays.asList(input.split(",")));
        validateNumber(inputList);
        return inputList.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static void printBonusNumber() {
        System.out.println(InputConstants.ENTER_BONUS_NUMBER.getMessage());
    }

    public int insertBonusNumber() {
        String bonusNumber = Console.readLine();
        validateBonusNumber(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }

    private void validateNumber(ArrayList<String> inputList) {
        for (String s : inputList) {
            inputValidator.checkInputDigit(s);
        }
    }

    private void validateMoney(String input) {
        inputValidator.checkInputEmpty(input);
        inputValidator.checkInputBlank(input);
        inputValidator.checkInputDigit(input);
    }

    private void validateLottoNumber(String input) {
        inputValidator.checkInputEmpty(input);
        inputValidator.checkInputBlank(input);
    }

    private void validateBonusNumber(String input) {
        inputValidator.checkInputEmpty(input);
        inputValidator.checkInputBlank(input);
        inputValidator.checkInputDigit(input);
    }
}
