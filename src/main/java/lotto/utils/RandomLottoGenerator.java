package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class RandomLottoGenerator {

    private static final int MIN_NUMBER_RANGE = 1;
    private static final int MAX_NUMBER_RANGE = 45;
    private static final int LOTTO_SIZE = 6;

    public List<Lotto> generateMultipleLotto(final Integer count) {
        List<Lotto> randomLottos = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            randomLottos.add(generateLotto());
        }
        return randomLottos;
    }

    public Lotto generateLotto() {
        List<Integer> randomLotto = Randoms.pickUniqueNumbersInRange(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE,LOTTO_SIZE)
                .stream().sorted().toList();
        return new Lotto(randomLotto);
    }
}
