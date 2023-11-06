package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GenerateLotto {
    private static final Integer START_LOTTO_NUMBER = 1;
    private static final Integer END_LOTTO_NUMBER = 45;
    private static final Integer PICK_NUMBERS = 6;

    public List<Lotto> getLottoNumbers(int count) {
        List<Lotto> lottos = new ArrayList<>();

        while (lottos.size() < count) {
            lottos.add(generateLotto());
        }

        return lottos;

    }
    private List<Integer> generateLottoNumbers() {
         return Randoms.pickUniqueNumbersInRange(START_LOTTO_NUMBER, END_LOTTO_NUMBER, PICK_NUMBERS);
    }

    private Lotto generateLotto() {
        return new Lotto(generateLottoNumbers());
    }
}
