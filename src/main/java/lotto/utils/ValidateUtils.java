package lotto.utils;

import java.util.List;

import static lotto.utils.Constant.BONUS_NUMBER_MAX_VALUE;
import static lotto.utils.Constant.BONUS_NUMBER_MIN_VALUE;

public class ValidateUtils {

    public static void validateNumberNumeric(String input) {
        try{
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요.");
        }
    }

    public static void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 && bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 1~45사이의 숫자를 입력하세요.");
        }
    }

    public static void validateNumbersNumeric(List<String> numbers) {
        try{
            for(String number : numbers) {
                Integer.parseInt(number);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요.");
        }
    }
}
