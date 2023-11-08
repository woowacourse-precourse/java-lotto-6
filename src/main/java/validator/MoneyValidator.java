package validator;

public class MoneyValidator {
    public static void moneyValidate() {

    }

    private static void moneyNotNull(String money) {
        if (money.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 값을 입력해주세요.");
        }
    }
}
