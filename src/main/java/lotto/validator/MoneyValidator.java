package lotto.validator;

import lotto.util.Utils;

public class MoneyValidator {
    public static boolean isNumber(String money) {
        try {
            Utils.convertStringToLong(money);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자를 입력해주셔야 합니다.");
            return true;
        }
        return false;
    }

    public static boolean isValid(String stringMoney) {
        Long money = Utils.convertStringToLong(stringMoney);
        if (money % 1000 != 0 || money == 0) {
            System.out.println("[ERROR] 1000원 단위의 금액을 입력해주셔야 합니다.");
            return true;
        }
        return false;
    }
}
