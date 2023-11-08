package lotto.validation;

import lotto.Model.ErrorMessage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Validation {

    public List<Integer> isChecktLotto(String value){
        value = value.replaceAll(" ", "");
        String[] toLotto = value.split(",", -1);
        for (String lotto : toLotto){
            isCheckEmpty(lotto);
            isOnlyComma(lotto);
            ischeckValueOverflow(lotto);
        }
        return stringToLotto(toLotto);
    }
    public int isCheckNumber(String value){
        value = value.replaceAll(" ", "");
        isCheckEmpty(value);
        isOnlyComma(value);
        ischeckValueOverflow(value);
        return Integer.parseInt(value);
    }

    public void isCheckEmpty(String input){
        if (input.isEmpty()){
            throw new IllegalArgumentException(ErrorMessage.ERROR_EMPTY.getErrorMessage());
        }
    }
    public void isOnlyComma(String input) {
        if (input.matches("^,.*") || input.matches(".*,$")) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_RANGE.getErrorMessage());
        }
    }

    private void ischeckValueOverflow(String amount){
        long max = Long.parseLong(amount);
        if (max > 2147483647L){
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_RANGE.getErrorMessage());
        }
    }

    private List<Integer> stringToLotto(String[] lottoNumber){
        return Arrays.stream(lottoNumber)
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
    }

    public void isStringToInt(String input) {
        try {
            for (String number : input.split(",")) {
                Integer.parseInt(number);
            }
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PURCHASED_DATAFORMAT.getErrorMessage());
        }
    }


    private void isMoneyMatch(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PURCHASED_RANGE.getErrorMessage());
        }
    }

    private static void isMultipleOfThousand(int money){
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PURCHASED_UNIT.getErrorMessage());
        }
    }
    private static void isNumberRangeCheck(List<Integer> numbers){
        for(int number : numbers){
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException((ErrorMessage.ERROR_BONUS_RANGE.getErrorMessage()));
            }
        }
    }


    private static void isDuplicateBonusNumber(List<Integer> winNumber, int bonus) {
        if (winNumber.contains(bonus)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PURCHASED_UNIT.getErrorMessage() + ErrorMessage.ERROR_BONUS_DUPLICATION);
        }
    }



}
