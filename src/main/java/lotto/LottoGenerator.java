package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public List<Lotto> createLottos(int lottoCount) {
        List<Lotto> Lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lottos.add(createLotto());
        }
        return Lottos;
    }

    private Lotto createLotto() {
        return new Lotto(createLottoNumbers());
    }

    private List<Integer> createLottoNumbers() {
        List<Integer> temp = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_NUMBER_COUNT);
        List<Integer> lottoNumbers = new ArrayList<>(temp);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
