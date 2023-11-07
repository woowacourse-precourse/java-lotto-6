package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.utils.LottoSystemUtils.*;

public class LottoSystem {
    private static int purchaseMoney;
    private static List<Lotto> purchaseLottos;
    private static Lotto winningLotto;

    public LottoSystem(String money) {
        validateMoney(money);

        this.purchaseMoney = stringToInteger(money);
        this.purchaseLottos = createLottos();
    }

    private static List<Lotto> createLottos() {
        List<Lotto> lottos = new ArrayList<>();

        int purchaseLottoCnt = purchaseMoney / moneyUnit;
        while (purchaseLottoCnt --> 1) {
            lottos.add(new Lotto(createRandomNumbers()));
        }

        return lottos;
    }

    private static List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(lottoNumberMinArrange, lottoNumberMaxArrange, lottoCount);
    }

    private boolean validateWinningLotto(String lotto) {
        if (isWrongLottoUnit(lotto)) return false;
        if (isNotAllIntegerType(lotto)) return false;

        // TODO : Lotto의 validate로 추가 유효성 검사 필요

        return true;
    }

    private static boolean isNotAllIntegerType(String lotto) {
        String[] lottoNums = lotto.split(",");

        for (String num : lottoNums) {
            if (isNotIntegerType(num)) return false;
        }

        return true;
    }

    private static boolean isWrongLottoUnit(String lotto) {
        if (lotto.split(",").length != lottoCount) return true;

        return false;
    }

    private static boolean validateMoney(String money) {
        if (isNotIntegerType(money)) return false;
        if (isWrongMoneyUnit(Integer.parseInt(money))) return false;

        return true;
    }

    private static boolean isNotIntegerType(String num) {
        try {
            Integer.parseInt(num);
        } catch (Exception e) {
            return true;
        }

        return false;
    }

    private static boolean isWrongMoneyUnit(int money) {
        if (money % moneyUnit != 0) return true;

        return false;
    }

    private static Integer stringToInteger(String num) {
        return Integer.parseInt(num);
    }

}
