package lotto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.PlayerLotto;
import lotto.domain.WinningLotto;
import lotto.utils.InputUtil;
import lotto.view.OutputView;

public class LottoService {
        private PlayerLotto playerLotto;
        private WinningLotto winningLotto;
        private final Map<LottoResult, Integer> lottoResult;

    public LottoService() {
        this.lottoResult = createLottoResult();
    }

    private Map<LottoResult, Integer> createLottoResult() {
        Map<LottoResult, Integer> lottoResult = new HashMap<>();

        for (LottoResult result : LottoResult.values()) {
            lottoResult.put(result, 0);
        }

        return lottoResult;
    }

    public void createPlayerLotto(){
        int price = InputUtil.inputLottoPrice();
        this.playerLotto = new PlayerLotto(price);
    }

    public void printPlayerLotto() {
        OutputView.printLottoAmount(playerLotto.getLottoAmount());
        OutputView.printPlayerLotto(playerLotto.getPlayerLottos());
    }

    public void createWinningLotto() {
        this.winningLotto = InputUtil.inputWinningLotto();
    }

    public void matchLotto() {
        List<Lotto> playerLottos = playerLotto.getPlayerLottos();

        for (Lotto lotto: playerLottos) {
            LottoResult result = winningLotto.matchLotto(lotto);
            lottoResult.put(result, lottoResult.get(result) + 1);
        }
    }

    public void printMatchLotto() {
        OutputView.printMatchLotto(lottoResult);
        OutputView.printProfit(computeProfit());
    }

    private double computeProfit() {
        int price = playerLotto.getPurchasesPrice();
        double totalAmount = 0;

        for (LottoResult result : LottoResult.values()) {
            totalAmount += result.getWinningAmount() * lottoResult.get(result);
        }

        return totalAmount / price * 100;
    }
}
