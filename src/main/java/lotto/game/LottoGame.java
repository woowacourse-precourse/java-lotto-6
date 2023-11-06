package lotto.game;

import java.util.List;
import lotto.collaboration.lottos.Lottos;
import lotto.collaboration.lottos.WinningLotto;
import lotto.io.lottos.LottosRandoms;
import lotto.io.views.LottoGameView;

public class LottoGame {

    private final LottoGameView lottoGameView;
    private final LottosRandoms lottosRandoms;

    public LottoGame(LottoGameView lottoGameView, LottosRandoms lottosRandoms) {
        this.lottoGameView = lottoGameView;
        this.lottosRandoms = lottosRandoms;
    }

    public void run() {
        Lottos lottos = new Lottos();
        // TODO : 리팩토링 필요
        int purchaseAmount;
        while (true) {
            try {
                purchaseAmount = lottoGameView.askPurchaseAmount();
                lottos.purchase(purchaseAmount);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR]" + e.getMessage());
            }
        }

        lottoGameView.showPurchaseLottos(lottos.make(lottosRandoms));

        // TODO : winningNumbers와 bonusNumber는 아무리 봐도 하나의 타입이다.. 두 행동을 하나로 묶는 리팩토링을 수행하면 좋겠다.
        List<Integer> winningNumbers = lottoGameView.askWinningNumbers();
        int bonusNumber = lottoGameView.askBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        
    }

}
