package validator;

public class MoneyValidator {
    public static void moneyValidate(String money) {
        moneyNotNull(money);
        moneyIsNumber(money);
        int moneyNumber;
        try {
            moneyNumber = Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구매 한도를 벗어났습니다.");
        }
        moneyNotZero(moneyNumber);
        moneyDivideBy1000(moneyNumber);
    }

    private static void moneyNotNull(String money) {
        if (money.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 값을 입력해주세요.");
        }
    }

    private static void moneyIsNumber(String money) {
        if (!money.matches("[0-9]+")) {
            throw new IllegalArgumentException("[ERROR] 양의 정수를 입력해주세요.");
        }
    }

    private static void moneyNotZero(int moneyNumber) {
        if (moneyNumber == 0) {
            throw new IllegalArgumentException("[ERROR] 양의 정수를 입력해주세요.");
        }
    }

    private static void moneyDivideBy1000(int moneyNumber) {
        if (moneyNumber % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위입니다.");
        }
    }
}
