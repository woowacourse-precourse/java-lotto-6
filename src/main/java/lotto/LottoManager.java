package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class LottoManager {
    LottoBuyer lottoBuyer;

    public LottoManager(LottoBuyer buyer) {
        lottoBuyer = buyer;
    }

    public void lottoSellingStart() {
        lottoBuyer.inputPurchaseAmount();
        publishLotto();
    }

    public List<Integer> createLottoNumber() {
        List<Integer> sortedLottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(sortedLottoNumber);
        
        return sortedLottoNumber;
    }

    public void publishLotto() {
        int publishCount = lottoBuyer.calculatePublishCount();

        for (int i = 0; i < publishCount; i++) {
            lottoBuyer.addMyLottos(new Lotto(createLottoNumber()));
        }

        lottoBuyer.printMyLottos();
    }
}
