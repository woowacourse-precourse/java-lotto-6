package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.utils.RandomUtil;

public class LottoMachine {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;
    private static final int UNIQUE_NUMBERS = 6;

    public static List<Lotto> createLotto(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < lottoCount; count++) {
            List<Integer> randomNumber = RandomUtil.createLottoNumber(MIN_VALUE, MAX_VALUE, UNIQUE_NUMBERS);
            lottos.add(new Lotto(randomNumber));
        }
        return lottos;
    }
}
