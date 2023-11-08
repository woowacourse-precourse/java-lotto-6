package lotto.util;

import lotto.domain.EnumLotto;

import java.util.List;

public class Validator {
    public static void validateParserNumbers(List<String> splitStrings) {
        validateNumbersFormat(splitStrings);
    }

    public static void validateRemainderNumber(String input) {
        validateNumberFormat(input);
        validateRemainderNotZero(input);
    }

    public static void validateBonusNumber(String input) {
        validateNumberFormat(input);
        validateSpaceNumber(input);
    }

    private static void validateNumbersFormat(List<String> splitStrings) {
        for(String input : splitStrings){
            validateNumberFormat(input);
            validateSpaceNumber(input);
        }
    }

    private static void validateNumberFormat(String input) {
        try{
            Integer.parseInt(input);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자만 입력하세요.");
        }
    }

    private static void validateSpaceNumber(String input) {
        if(input.contains(" ")){
            throw new IllegalArgumentException("[ERROR] 공백을 제외하고 입력하세요.");
        }
    }

    private static void validateRemainderNotZero(String input) {
        int buyMoney = Integer.parseInt(input);

        if(buyMoney % EnumLotto.LOTTO_PRICE.getNumber() != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1,000원 단위만 가능합니다.");
        }
    }
}
