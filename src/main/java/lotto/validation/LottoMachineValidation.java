package lotto.validation;

import static lotto.constant.ErrorMessage.INVALID_IS_NOT_INPUT;
import static lotto.constant.ErrorMessage.INVALID_NUMBER;
import static lotto.constant.ErrorMessage.INVALID_PURCHASE_AMOUNT;
import static lotto.constant.Message.LOTTO_PRICE;

import java.util.Arrays;
import java.util.List;

public class LottoMachineValidation {

    public static int validate_inputMoney(String inputMoney){
        validate_isInputValue(inputMoney);
        validate_isPositiveNum(inputMoney);
        validate_isExactlyDividedByPrice(Integer.parseInt(inputMoney));
        return Integer.parseInt(inputMoney);
    }

    public static void validate_winningLotto(String winningNums, String bonusNum){
        validate_isWinningNums(winningNums);
        validate_isInputValue(bonusNum);
        validate_isPositiveNum(bonusNum);
    }

    private static void validate_isWinningNums(String input){
        validate_isInputValue(input);
        List<String> strings = Arrays.stream(input.split(",")).toList();
        for (String string : strings) {
            validate_isPositiveNum(string);
        }
    }

    private static void validate_isInputValue(String input){
        if(input == null || input.isBlank()){
            throw new IllegalArgumentException(INVALID_IS_NOT_INPUT);
        }
    }

    private static void validate_isPositiveNum(String input){
        int num;
        try {
            num = Integer.parseInt(input);
        }catch (NumberFormatException numberFormatException){
            throw new IllegalArgumentException(INVALID_NUMBER);
        }

        if(num < 1){
            throw new IllegalArgumentException();
        }
    }

    private static void validate_isExactlyDividedByPrice(int input){
        if(input % LOTTO_PRICE != 0){
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT);
        }
    }

}
