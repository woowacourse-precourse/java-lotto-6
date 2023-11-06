package lotto.domain;

import java.util.List;

import static lotto.utils.LottoSystemUtils.lottoCount;
import static lotto.utils.LottoSystemUtils.moneyUnit;

public class LottoSystem {
    private int purchaseMoney;
    private List<Lotto> lottos;
    private Lotto winningLotto;

    private boolean validateWinningLotto(String lotto) {
        if (isWrongLottoUnit(lotto)) return false;
        if (isNotAllIntegerType(lotto)) return false;

        // TODO : Lotto의 validate로 추가 유효성 검사 필요

        return true;
    }

    private boolean isNotAllIntegerType(String lotto) {
        String[] lottoNums = lotto.split(",");

        for (String num : lottoNums) {
            if (isNotIntegerType(num)) return false;
        }

        return true;
    }

    private boolean isWrongLottoUnit(String lotto) {
        if (lotto.split(",").length != lottoCount) return true;

        return false;
    }

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
