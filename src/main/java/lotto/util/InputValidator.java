package lotto.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {

    public static void validatePurchaseAmount(String purchaseAmount) throws IllegalArgumentException{
        validateNotEmpty(purchaseAmount);
        validateIntegerType(purchaseAmount);
    }

    public static void validateLottoNumber(List<String> lottoNumbers) throws IllegalArgumentException{
        validateEachNumberNotEmpty(lottoNumbers);
        validateEachNumberIntegerType(lottoNumbers);
    }

    private static void validateEachNumberIntegerType(List<String> lottoNumbers) throws IllegalArgumentException{
        for (String lottoNumber : lottoNumbers) {
            validateIntegerType(lottoNumber);
        }
    }

    private static void validateEachNumberNotEmpty(List<String> lottoNumbers) throws IllegalArgumentException{
        for (String lottoNumber : lottoNumbers) {
            validateNotEmpty(lottoNumber);
        }
    }

    private static void validateIntegerType(String input) throws IllegalArgumentException{
        Pattern pattern = Pattern.compile("^-?\\d+$");
        Matcher matcher = pattern.matcher(input);

        if(!matcher.matches()){
            throw new IllegalArgumentException("[ERROR] : 입력 값은 정수 타입이어야 합니다");
        }
    }

    private static void validateNotEmpty(String input) throws IllegalArgumentException{
        if(input.isEmpty()){
            throw new IllegalArgumentException("[ERROR] : 입력 값은 공백일 수 없습니다");
        }
    }

    public static void validateBonusNumber(String bonusNumber) throws IllegalArgumentException{
        validateNotEmpty(bonusNumber);
        validateIntegerType(bonusNumber);
    }
}
