package service;

import static consts.NumericConfig.LOTTO_PRICE;

import java.util.List;
import model.FinanceManager;
import model.GameManager;
import model.LottoTotalResult;
import model.dto.LottoResponse;

public class LottoService {

    private final FinanceManager financeManager;
    private final GameManager gameManager;

    private LottoService(final FinanceManager financeManager, final GameManager gameManager) {
        this.financeManager = financeManager;
        this.gameManager = gameManager;
    }

    public static LottoService from(final int purchase) {
        return new LottoService(FinanceManager.from(purchase),
            GameManager.from(purchase / LOTTO_PRICE.number()));
    }

    public int getLottoCount() {
        return financeManager.calculateLottoCount();
    }

    public List<LottoResponse> getGeneratedLottos() {
        return gameManager.generateLottos();
    }

    public void generateAnswerLotto(final List<Integer> answerLottoNumbers,
        final int answerBonusNumber) {
        gameManager.generateAnswerLotto(answerLottoNumbers, answerBonusNumber);
    }

    public LottoTotalResult calculateResult() {
        return gameManager.calculateResult();
    }

    public double calculateRateOfReturn(final LottoTotalResult totalResult) {
        return financeManager.calculateRateOfReturn(totalResult);
    }
}
