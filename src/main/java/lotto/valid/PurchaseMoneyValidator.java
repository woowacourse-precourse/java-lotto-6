package lotto.valid;

public class PurchaseMoneyValidator extends Validator {

    public static boolean validate(String purchaseMoney) {
        try {
            int money = isNumeric(purchaseMoney);
            isPositive(money);
            isMultipleOfThousand(money);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    private static void isMultipleOfThousand(int purchaseMoney) throws IllegalArgumentException {
        if (purchaseMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
        }
    }
}
