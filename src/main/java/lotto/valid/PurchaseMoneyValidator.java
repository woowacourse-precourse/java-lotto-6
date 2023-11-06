package lotto.valid;

public class PurchaseMoneyValidator {

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

    private static int isNumeric(String purchaseMoney) throws IllegalArgumentException {
        try {
            return Integer.parseInt(purchaseMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    private static void isPositive(int purchaseMoney) throws IllegalArgumentException {
        if (purchaseMoney <= 0) {
            throw new IllegalArgumentException("[ERROR] 0보다 큰 숫자를 입력해주세요.");
        }
    }

    private static void isMultipleOfThousand(int purchaseMoney) throws IllegalArgumentException {
        if (purchaseMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
        }
    }
}
