package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.utils.LottoSystemUtils.*;

public class LottoSystem {
    private static int purchaseMoney;
    private static List<Lotto> purchaseLottos;

    public LottoSystem(int money) {
        this.purchaseMoney = money;
        this.purchaseLottos = createLottos();
    }

    public static List<Lotto> getPurchaseLottos() {
        return purchaseLottos;
    }

    public static int getPurchaseLottoCount() {
        return purchaseLottos.size();
    }

    private static List<Lotto> createLottos() {
        List<Lotto> lottos = new ArrayList<>();

        int purchaseLottoCnt = purchaseMoney / moneyUnit;
        while (purchaseLottoCnt --> 1) {
            List<Integer> lotto = createRandomNumbers();
            Collections.sort(lotto);
            lottos.add(new Lotto(lotto));
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

    private static boolean isNotIntegerType(String num) {
        try {
            Integer.parseInt(num);
        } catch (Exception e) {
            return true;
        }

        return false;
    }
}
