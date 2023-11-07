package lotto.domain;

import static lotto.view.OutputView.LOTTO_SIZE;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {
    public final static int FIVE = 5;

    public void compareValue(List<Lotto> lottos, User user) {
        int equalCount;
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < lottos.size(); i++) {
            Lotto lotto = lottos.get(i);
            equalCount = compareLine(lotto, user);
            if (result.get(equalCount) == null) {
                result.put(equalCount, 1);
                continue;
            }
            result.put(equalCount, result.get(equalCount) + 1);
        }
    }

    private int compareLine(Lotto lotto, User user) {
        List<Integer> winnerNumbers = user.getNumbers();
        List<Integer> lottoNumbers = lotto.getNumbers();
        int equalCount = 0;

        for (int i = 0; i < LOTTO_SIZE; i++) {
            if (lottoNumbers.contains(winnerNumbers.get(i))) {
                equalCount++;
            }
        }
        equalCount = bonus(equalCount, lottoNumbers, user.getBonusNumber());
        return equalCount;
    }

    private int bonus(int equalCount, List<Integer> lottoNumbers, long bonusNumber) {
        if (equalCount == FIVE) {
            if (lottoNumbers.contains(bonusNumber)) {
                equalCount += 2;
            }
        }
        return equalCount;
    }
}
