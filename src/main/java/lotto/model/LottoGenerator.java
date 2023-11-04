package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.utils.Constants;

public class LottoGenerator {


    public List<Lotto> generateRandomLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(generateRandomLotto());
        }
        return lottos;
    }

    private Lotto generateRandomLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Constants.MIN_RANGE,
            Constants.MAX_RANGE, Constants.LOTTO_NUMBERS_SIZE);
        return new Lotto(numbers);
    }

}
