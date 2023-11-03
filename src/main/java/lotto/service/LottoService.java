package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.Player;

public class LottoService {

    private final LottoGenerator lottoGenerator = new LottoGenerator();

    public Lotto generateLotto() {
        return new Lotto(lottoGenerator.generateLottoNumbers());
    }

    public int compareLotto(Lotto lotto, List<Integer> inputNumbers) {
        int count = 0;

        for (int number : inputNumbers) {
            if (lotto.isContainNumber(number)) {
                count++;
            }
        }

        return count;
    }

}
