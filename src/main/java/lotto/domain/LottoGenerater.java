package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerater {

    private final Integer LOTTOVALUE = 1000;
    private final Integer MIN_RANGE = 1;
    private final Integer MAX_RANGE = 45;
    private final Integer PICK_NUMBER = 6;

    public List<Lotto> generateLottos(Integer money) {
        List<Lotto> lottos = new ArrayList<>();
        Integer lottoCnt = money/LOTTOVALUE;
        while (lottos.size() < lottoCnt) {
            lottos.add(generateLotto());
        }

        return lottos;
    }

    private Lotto generateLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, PICK_NUMBER));
    }
}
