package lotto;

import java.util.List;
import java.util.Map;

public class Application {
    private static final InputHandler inputHandler = new InputHandler();
    private static final LottoHandler lottoHandler = new LottoHandler();

    public static void main(String[] args) {
        int numberOfLotto = inputHandler.lottoCountForPurchasePrice();
        List<Lotto> lottos = lottoHandler.issueLottoNumbers(numberOfLotto);
        Lotto winningLotto = inputHandler.winningLotto();
        int bonusNumber = inputHandler.bonusNumber(winningLotto);
        Map<WinningKind, Integer> winningResult = lottoHandler.winningResult(lottos, winningLotto, bonusNumber);
        lottoHandler.rateOfReturnResult(numberOfLotto, winningResult);
    }
}
