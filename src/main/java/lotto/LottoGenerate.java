package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LottoGenerate {
    public HashMap<Integer, List<Integer>> getRandomLottoResult(int lottoTicket) {
        HashMap<Integer, List<Integer>> lottoGenerateResult = new HashMap<>();

        for (int i = 0; i < lottoTicket; i++) {
            lottoGenerateResult.put(i, createRandomLotto());
        }

        return lottoGenerateResult;
    }

    private List<Integer> createRandomLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }
}
