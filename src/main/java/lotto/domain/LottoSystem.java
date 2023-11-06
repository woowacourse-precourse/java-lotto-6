package lotto.domain;

import java.util.List;

import static lotto.utils.LottoSystemUtils.moneyUnit;

public class LottoSystem {
    private int purchaseMoney;
    private List<Lotto> lottos;

    private boolean validateMoney(String money) {
        if (isNotIntegerType(money)) return false;
        if (isWrongMoneyUnit(Integer.parseInt(money))) return false;

        return true;
    }

    private boolean isNotIntegerType(String num) {
        try {
            Integer.parseInt(num);
        } catch (Exception e) {
            return true;
        }
        return false;
    }

    private boolean isWrongMoneyUnit(int money) {
        if (money % moneyUnit != 0) return true;
        return false;
    }

}
