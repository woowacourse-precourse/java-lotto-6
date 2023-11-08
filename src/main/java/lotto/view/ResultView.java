package lotto.view;

import java.util.List;
import lotto.Lotto;
import lotto.LottoService;

public class ResultView {
    private static final LottoService lottoService = new LottoService();

    public List<Lotto> showPurchasedLottos(int purchaseAmount) {
        System.out.println(purchaseAmount / 1000 + "개를 구매했습니다.");
        List<Lotto> lottos = lottoService.provideLotto(purchaseAmount / 1000);
        lottoService.printLottos(lottos);
        System.out.println();
        return lottos;
    }

}
