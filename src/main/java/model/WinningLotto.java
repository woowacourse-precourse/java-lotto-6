package model;

import message.Regex;

import java.util.regex.Pattern;

public class WinningLotto {
    private final Lotto winningLotto;
    private final Integer bonus;

    public WinningLotto(Lotto winningLotto, String bonus) {
        this.winningLotto = winningLotto;
        this.bonus = validateRange(validateMoneyisNumber(bonus));
    }

    private Integer validateMoneyisNumber(String money) {
        if (!Pattern.matches(Regex.ONLYNUMBER.getRegex(), money)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야 합니다.");
        }
        return Integer.parseInt(money);
    }

    private Integer validateRange(Integer bonus) {
        if (!Pattern.matches(Regex.ONETOFOURTYFIVE.getRegex(), bonus.toString())) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        return bonus;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public Integer getBonus() {
        return bonus;
    }
}
