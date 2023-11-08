package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private static final int PICK_NUMBER = 6;

    public List<Lotto> generateLottoGroup(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        while (lottos.size() < lottoCount) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    public Lotto generateLotto() {
        List<Integer> generateLottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, PICK_NUMBER);
        return new Lotto(generateLottoNumbers);
    }
}
