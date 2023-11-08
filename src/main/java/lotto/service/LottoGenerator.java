package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Lottos;

public class LottoGenerator {
    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;

    public List<Integer> createRandomNumbersByAscending() {
        List<Integer> numbers =
                Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM, MAX_LOTTO_NUM, LOTTO_NUMBER_SIZE);
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
