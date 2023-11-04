package lotto.manager;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoPurchase;
import lotto.io.LottoInputView;
import lotto.io.LottoOutputView;

public class LottoManager {
    private final LottoInputView inputView = new LottoInputView();
    private final LottoOutputView outputView = new LottoOutputView();

    public void excute() {
        LottoPurchase lottoPurchase = new LottoPurchase();
        lottoPurchase.setLottoPurchase(inputView.readPurchaseAmount());
        printLottoManager();
    }

    public void printLottoManager() {
        int lottoPurchaseCount = LottoPurchase.getLottoPurchase() / 1000;
        outputView.printLottoPurchaseCount(lottoPurchaseCount);
        while(lottoPurchaseCount != 0) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            outputView.printLottoNumbers(lotto.getNumbers());
            lottoPurchaseCount--;
        }
    }
}
