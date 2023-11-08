package model;

import message.Regex;

import java.util.regex.Pattern;

public class Amount {
    private final Integer count;
    private final Long amount;
    private final int MINAMOUNT = 1000;
    public Amount(String money) {
        this.amount = validateMoney(validateMoneyisNumber(money));
        this.count = (int) (this.amount / MINAMOUNT);
    }

    private Long validateMoney(Long money) {
        if (money % MINAMOUNT != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 "+MINAMOUNT+"의 배수여야 합니다.");
        }
        return money;
    }

    private Long validateMoneyisNumber(String money) {
        if (!Pattern.matches(Regex.ONLYNUMBER.getRegex(), money)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야 합니다.");
        }
        return Long.parseLong(money);
    }

    public Integer getCount() {
        return count;
    }

    public Long getAmount() {
        return amount;
    }
}
