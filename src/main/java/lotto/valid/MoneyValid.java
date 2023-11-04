package lotto.valid;

import static lotto.consts.LottoConst.LOTTO_PRICE;

public class MoneyValid {

    public static int validMoney(String input) {
        int money = validOnlyNumber(input);
        validDividing(money);
        validMinMoney(money);
        return money;
    }

    private static int validOnlyNumber(String input) {
        String reg = "^[0-9]*$";
        if (!input.matches(reg)) {
            throw new IllegalArgumentException("[ERROR] 돈은 숫자만 입력 가능합니다.");
        }
        return Integer.parseInt(input);
    }

    private static void validDividing(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 돈은 1000원으로 나누어 떨어져야 합니다.");
        }
    }

    private static void validMinMoney(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 돈은 최소 1000원 이상이여야 합니다.");
        }
    }
}
