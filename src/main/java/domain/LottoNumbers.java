package domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class LottoNumbers {
    private static final int CNT_LOTTO_NUMBER = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    public static List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, CNT_LOTTO_NUMBER);
    }

    public List<Lotto> generateLottoGroup(int createLottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        while (lottos.size() < createLottoCount) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    public Lotto generateLotto() {
        return new Lotto(getRandomNumbers());
    }

}
