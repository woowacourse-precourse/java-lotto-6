package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

public class LottoEnvelope {
    List<Lotto> lottos;

    public LottoEnvelope(Integer lottoCount) {
        lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }
    }

    public HashMap<Integer, Integer> getStatistics(List<Integer> winningNumbers, Integer bonusNumber) {
        return null;
    }

    public Float getEarningRate(List<Integer> winningNumbers, Integer bonusNumber) {
        return null;
    }
}
