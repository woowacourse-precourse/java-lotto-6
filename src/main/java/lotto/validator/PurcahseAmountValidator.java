package lotto.validator;

public class PurcahseAmountValidator
{
    public static boolean validate(String purchaseAmount) {
        if(isNumber(purchaseAmount));
        if(isPositive(purchaseAmount));
        if(isThousands(purchaseAmount));
        return true;
    }

    private static boolean isNumber(String purchaseAmount) {
        try {
            Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 구입금액은 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
        return true;
    }
    private static boolean isPositive(String purchaseAmount) {
        int money = Integer.parseInt(purchaseAmount);
        if(money<0) {
            System.out.println("[ERROR] 구입금액은 0이상의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
        return true;
    }
    private static boolean isThousands(String purchaseAmount) {
        int money = Integer.parseInt(purchaseAmount);
        if(!(money%1000==0)) {
            System.out.println("[ERROR] 구입금액은 1000의 배수여야 합니다.");
            throw new IllegalArgumentException();
        }
        return true;
    }
}
