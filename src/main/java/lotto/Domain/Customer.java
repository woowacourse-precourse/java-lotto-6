package lotto.Domain;

import java.util.List;
import lotto.Lotto;
import lotto.View.InputView;

public class Customer {
    List<Lotto> purchasedLotto;
    public void buyLotto(LottoStore lottoStore){
        String lottoPurchaseAmount = InputView.inputLottoPurchaseAmount();
        // 로또 입력값을 검증하는 함수
        this.purchasedLotto = lottoStore.generateLotto(Integer.parseInt(lottoPurchaseAmount)/1000);
    }
}
