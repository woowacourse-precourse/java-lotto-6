package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private static final int LOTTO_NUMBER_SIZE = 6;

    public List<Integer> createRandomNumbersByAscending() {
        List<Integer> numbers =
                Randoms.pickUniqueNumbersInRange(1, 45, LOTTO_NUMBER_SIZE);
        List<Integer> copyNumbers = new ArrayList<>(numbers);
        Collections.sort(copyNumbers);
        return copyNumbers;
    }

    public Lotto createOnlyOneLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public Lottos createLottoBundle(int issueCount) {
        List<Lotto> lottoBundle = new ArrayList<>();
        for (int i = 0; i < issueCount; i++) {
            Lotto lotto = createOnlyOneLotto(createRandomNumbersByAscending());
            lottoBundle.add(lotto);
        }
        return new Lottos(lottoBundle);
    }

}
