package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {
    public List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        sortLottoNumbers(lottoNumbers);

        return lottoNumbers;
    }

    private void sortLottoNumbers(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
    }
}
