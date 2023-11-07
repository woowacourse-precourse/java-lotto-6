package lotto.validator;

public class ValidatePurchaseAmount {

    static final int LOTTO_PRICE=1000;

    public static void validatePurchaseAmount(String buyerInput){
        validateEmpty(buyerInput);
        validateConvertable(buyerInput);
        validateSmallThanThousand(buyerInput);
        validateDividableThousand(buyerInput);

    }

    private static void validateDividableThousand(String buyerInput) {
        if(!canDivide(buyerInput)){
            throw new IllegalArgumentException("[ERROR] 로또의 한장 가격은 1000원 입니다. 1000원 단위로 입력하십시오.");
        }
    }

    private static boolean canDivide(String buyerInput){
        return Integer.parseInt(buyerInput) % LOTTO_PRICE ==0;
    }

    private static void validateSmallThanThousand(String buyerInput) {
        int purchaseAmount = Integer.parseInt(buyerInput);
        if(purchaseAmount<LOTTO_PRICE){
            throw new IllegalArgumentException("[ERROR] 로또의 한장 가격은 1000원 입니다.");
        }
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
