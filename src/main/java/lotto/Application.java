package lotto;

import java.util.List;
import java.util.Map;

public class Application {
    private static final LottoHandler lottoHandler = new LottoHandler();

    public static void main(String[] args) {
        int numberOfLotto = lottoHandler.lottoCountForPurchasePrice();
        List<Lotto> lottos = lottoHandler.issueLottoNumbers(numberOfLotto);
        Lotto winningLotto = lottoHandler.winningLotto();
        int bonusNumber = lottoHandler.bonusNumber();
        Map<WinningKind, Integer> winningResult = lottoHandler.winningResult(lottos, winningLotto, bonusNumber);
        lottoHandler.rateOfReturnResult(numberOfLotto, winningResult);
    }
}
