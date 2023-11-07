package lotto.validate;

public class Validator {
    public static void validatePurchaseMoney(String money) {
        if (!isNumeric(money)) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자만 입력 가능합니다.");
        }
        int purchaseMoney = Integer.parseInt(money);
        if (!isMultipleOf1000(purchaseMoney)) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위로 입력 가능합니다.");
        }
        if (!isThousandOrMore(purchaseMoney)) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 이상만 입력 가능합니다.");
        }
    }
    public static boolean isNumeric(String str) {
        return str.chars().allMatch(Character::isDigit);
    }

    public static boolean isMultipleOf1000(int money) {
        return money % 1000 == 0;
    }

    public static boolean isThousandOrMore(int number) {
        return number >= 1000;
    }
}
