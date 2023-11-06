package lotto.service;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

public class RandomLottoNumber {

    private static final int MIN=1;
    private static final int MAX=1;
    private static final int COUNT=1;
    private Lotto generateRandomLottoNumbers() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(MIN, MAX, COUNT));
    }

    private List<Lotto> generateTotalLottoNumbers(int count) {
        List<Lotto> totalLotoNumber = new ArrayList<>();

        while (totalLotoNumber.size() < count) {
            totalLotoNumber.add(generateRandomLottoNumbers());
        }

        return totalLotoNumber;

    }
}
