package validator;

public class MoneyValidator {
    private MoneyValidator() {
    }

    public static void isNumeric(String money) {
        try {
            int integerMoney = Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void isThousandUnit(String money) {
        int integerMoney = Integer.parseInt(money);
        if (integerMoney % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}
