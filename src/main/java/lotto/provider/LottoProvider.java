package lotto.provider;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.data.Lotto;
import lotto.error.Error;

import java.util.ArrayList;
import java.util.List;

public class LottoProvider {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int LOTTO_NUMBER_CNT = 6;

    public List<Lotto> buyLottos(String purchaseAmount) {
        int purchasableCount = Integer.parseInt(purchaseAmount) / LOTTO_PRICE;

        List<Lotto> lottos = new ArrayList<>();
        for (int i=0; i<purchasableCount; i++) {
            List<Integer> lottoNumbers = generateLottoNumbers();
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }

        return lottos;
    }

    private List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_NUMBER_CNT);
    }
}
