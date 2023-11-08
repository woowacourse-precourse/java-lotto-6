package user;

import lotto.LottoCollection;
import lotto.LottoResult;

import static validate.InputValidation.*;

public class User {
    private final LottoCollection lottos;

    public User(int purchaseAmount) {
        validate(purchaseAmount);
        this.lottos = new LottoCollection(purchaseAmount);
    }

    private void validate(int purchaseAmount) {
        validateAmount(purchaseAmount);
    }
    public void printLottoNumbers() {
        lottos.printLottoNumbers();
    }

    public void matchLottoNumbers(LottoResult result) {
        lottos.matchLottoNumbers(result);
    }

    public void printWinningStatistics() {
        lottos.printWinningStatistics();
    }

    public void printProfitRate() {
        lottos.printProfitRate();
    }
}
