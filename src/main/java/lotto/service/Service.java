package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.data.Lotto;
import lotto.data.LottoRepository;
import lotto.data.PurchaseAmount;

public class Service {
    public static LottoRepository creatLottoRepository(PurchaseAmount purchaseAmount) {
        int lottoCount = purchaseAmount.getPurchasedLottoCount();

        LottoRepository lottoRepository = new LottoRepository();
        for(int i=0;i<lottoCount;i++){
            lottoRepository.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }

        return lottoRepository;
    }
}
