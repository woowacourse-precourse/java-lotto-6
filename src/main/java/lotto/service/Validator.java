package lotto.service;

public class Validator {
    public static void validateNumber(final String purchaseAmount){
        if(!purchaseAmount.matches("\\d+"))
            throw new IllegalArgumentException("[ERROR] 올바른 숫자 형식이 아닙니다.");
    }

    public static void validateLess1000Won(final String purchaseAmount){
        if(Integer.parseInt(purchaseAmount) < 1000)
            throw new IllegalArgumentException("[ERROR] 1000원 보다 높은 금액을 입력해주세요.");
    }

    public static void validateDividedBy1000Won(final String purchaseAmount){
        if(Integer.parseInt(purchaseAmount) % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 구매해 주세요.");
    }
}
