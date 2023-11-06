package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoRank;
import lotto.exception.LottoException;
import lotto.view.LottoView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LottoService {

    private LottoException lottoException = new LottoException();

    public int getLottoCount(String lottoPurchase) {
        int lottoCount = 0;
        if (lottoException.isValidLottoPurchase(lottoPurchase)) {
            lottoCount = Integer.parseInt(lottoPurchase)/1000;
        }
        return lottoCount;
    }

    public List<Integer> getLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Lotto> getLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i=0; i<lottoCount; i++) {
            Lotto lotto = new Lotto(getLottoNumbers());
            lottos.add(lotto);
        }
        return lottos;
    }

    public LottoMachine createLottoMachine(int lottoCount) {
        List<Lotto> lottos = getLottos(lottoCount);
        HashMap<LottoRank, Integer> lottoRanks = new HashMap<>();
        return new LottoMachine(lottoCount, lottos, lottoRanks);
    }

}
