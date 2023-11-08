package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_UNIT_AMOUNT = 1000;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    public static List<Lotto> buy(int inputMoney) {
        List<Lotto> lottos = new ArrayList<>();
        int count = getLottoCount(inputMoney);
        for (int index = 0; index < count; index++) {
            lottos.add(makeLotto());
        }
        return lottos;
    }

    public static int getLottoCount(int inputMoney) {
        return inputMoney / LOTTO_UNIT_AMOUNT;
    }


    private static Lotto makeLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE);
        Collections.sort(randomNumbers);
        return new Lotto(randomNumbers);
    }
}
