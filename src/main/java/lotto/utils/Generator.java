package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoConstant;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Generator {
    public static List<Lotto> generateLottoByAmount(int amount) {
        List<Lotto> list = new ArrayList<>();
        for (int cnt = 0; cnt < amount; cnt++) {
            list.add(new Lotto(Generator.generateRandomNumber()));
        }
        return list;
    }

    private static List<Integer> generateRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(
                LottoConstant.MIN_NUMBER,
                LottoConstant.MAX_NUMBER,
                LottoConstant.NUMBER_SIZE);
    }
}
