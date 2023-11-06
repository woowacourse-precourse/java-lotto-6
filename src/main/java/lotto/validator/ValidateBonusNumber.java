package lotto.validator;

public class ValidateBonusNumber {
    public static void validateBonusNumber(String buyerInput){
        validateEmpty(buyerInput);
        validateConvertable(buyerInput);
    }

    private static void validateConvertable(String buyerInput) {
        if(!buyerInput.matches("-?\\d+")){
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    private static void validateEmpty(String buyerInput) {
        if(buyerInput.isBlank()){
            throw new IllegalArgumentException("[ERROR] 값을 입력해주세요.");
        }
    }
}
