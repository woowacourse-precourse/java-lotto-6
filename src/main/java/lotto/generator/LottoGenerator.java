package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private static final Integer MIN_NUM = 1;
    private static final Integer MAX_NUM = 45;
    private static final Integer PICK_NUM = 6;

    public List<Lotto> generateLottoSet(int lottoCount) {
        List<Lotto> lottoSet = new ArrayList<>();

        while(lottoSet.size() < lottoCount) {
            lottoSet.add(generateLotto());
        }
        return lottoSet;
    }

    public Lotto generateLotto() {
        return new Lotto(generateLottoNum());
    }

    public List<Integer> generateLottoNum() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, PICK_NUM);
    }
}
