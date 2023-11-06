package lotto.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {

    public static void validatePurchaseAmount(String purchaseAmount) {
        validateNotEmpty(purchaseAmount);
        validateIntegerType(purchaseAmount);
        validateCorrectRange(purchaseAmount);
    }

    private static void validateCorrectRange(String purchaseAmount) {
        try {
            Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] : 가능한 정수 범위를 초과했습니다.");
        }
    }

    public static void validateLottoNumber(List<String> lottoNumbers) {
        validateEachNumberNotEmpty(lottoNumbers);
        validateEachNumberIntegerType(lottoNumbers);
    }

    private static void validateEachNumberIntegerType(List<String> lottoNumbers) {
        for (String lottoNumber : lottoNumbers) {
            validateIntegerType(lottoNumber);
        }
    }

    private static void validateEachNumberNotEmpty(List<String> lottoNumbers) {
        for (String lottoNumber : lottoNumbers) {
            validateNotEmpty(lottoNumber);
        }
    }

    private static void validateIntegerType(String input) {
        Pattern pattern = Pattern.compile("^-?\\d+$");
        Matcher matcher = pattern.matcher(input);

        if(!matcher.matches()){
            throw new IllegalArgumentException("[ERROR] : 입력 값은 정수 타입이어야 합니다");
        }
    }

    private static void validateNotEmpty(String input) {
        if(input.isEmpty()){
            throw new IllegalArgumentException("[ERROR] : 입력 값은 공백일 수 없습니다");
        }
    }

    public static void validateBonusNumber(String bonusNumber) {
        validateNotEmpty(bonusNumber);
        validateIntegerType(bonusNumber);
    }
}
