package Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class RandomLottoGenerator {
    static final int SMALLEST_LOTTO_NUMBER = 1;
    static final int BIGGEST_LOTTO_NUMBER = 45;
    static final int LOTTO_NUMBER_COUNT = 6;

    public List<Lotto> generateLottos(int amount) {
        List<Lotto> userIssuedLottos = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            userIssuedLottos.add(generateSingleRandomLotto());
        }
        return userIssuedLottos;
    }

    private Lotto generateSingleRandomLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(SMALLEST_LOTTO_NUMBER, BIGGEST_LOTTO_NUMBER,
                LOTTO_NUMBER_COUNT);
        return new Lotto(lottoNumbers);
    }


}
