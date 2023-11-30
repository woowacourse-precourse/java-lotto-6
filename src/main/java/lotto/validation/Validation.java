package lotto.validation;

import static lotto.constant.ErrorMessage.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import lotto.constant.constant;
import lotto.domain.Lotto;

public class Validation {

    public static boolean validatepurchaseAmount(String number){
        try{
            validateNumberType(number);
            validatedivide(Integer.parseInt(number));
            validateZero(Integer.parseInt(number));
            return false;
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return true;
        }
    }

    public static void validateNumberType(String number) {
        String regex = "[0-9]+";

        if (!Pattern.matches(regex, number)) {
            throw new IllegalArgumentException(NUMBER.getMessage());
        }
    }

    public static void validatedivide(int number){
        if(number%constant.THOUSAND != 0){
            throw new IllegalArgumentException(DIVIDE.getMessage());
        }
    }

    public static void validateZero(int number){
        if(number == 0){
            throw new IllegalArgumentException(ZERO.getMessage());
        }
    }

    public static void validateBonusNumber(Lotto lotto_numbers, String bonus_number){
        validateNumberType(bonus_number);
        validateBonusNumberDuplicate(lotto_numbers, Integer.parseInt(bonus_number));
        validateBonusNumberInRange(Integer.parseInt(bonus_number));
    }



    public static void validateBonusNumberDuplicate(Lotto lotto_numbers, int bonus_number){
        if(lotto_numbers.contains(bonus_number)){
            throw new IllegalArgumentException(BONUSNUMBERDUPLICATE.getMessage());
        }
    }

    private static void validateBonusNumberInRange(int number){
        if(number < constant.MINLOTTONUMBER || number > constant.MAXLOTTONUMBER){
            throw new IllegalArgumentException(NUMBERINRANGE.getMessage());
        }
    }

    public static void validateLottoNumberType(String Numbers) {
        List<String> numbers = Arrays.stream(Numbers.split(",")).toList();
        String regex = "[0-9]+";

        for(String number : numbers){
            if (!Pattern.matches(regex, number)) {
                throw new IllegalArgumentException(NUMBER.getMessage());
            }
        }
    }
}
