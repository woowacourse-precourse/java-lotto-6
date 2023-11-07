package lotto.lottoGame;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.Lotto;

public class LottoRandomGenerator {
    public Lotto generateLottoSortedNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        lottoNumbers.sort((o1, o2) -> o1 - o2);
        return new Lotto(lottoNumbers);
    }
}
