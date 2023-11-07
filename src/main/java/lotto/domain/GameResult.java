package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class GameResult {
    private static final int INITIAL_AMOUNT = 0;
    private static final int DECIMAL_POINT = 2;
    private static final int PERCENTAGE_CONVERSION = 100;
    private final List<Lotto> playerLotto;
    private final List<LottoRank> lottoResult;

    private GameResult(List<Lotto> playerLotto) {
        this.playerLotto = playerLotto;
        lottoResult = new ArrayList<>();
    }

    public GameResult of(List<Lotto> playerLotto) {
        return new GameResult(playerLotto);
    }

    public List<LottoRank> calculateRank() {
        for (Lotto eachLotto : playerLotto) {
            lottoResult.add(WinningLottoNumber.calculateLottoPrize(eachLotto));
        }

        return lottoResult;
    }

    public long calculateWinningMoney() {
        long winningMoney = INITIAL_AMOUNT;

        for (LottoRank eachRank : lottoResult) {
            winningMoney += eachRank.getWinningAmount();
        }

        return winningMoney;
    }

    public String calculateYield(long winningMoney, int purchaseAmount) {
        double profit = (double) winningMoney / purchaseAmount * PERCENTAGE_CONVERSION;

        BigDecimal yield = new BigDecimal(profit)
                .setScale(DECIMAL_POINT, RoundingMode.HALF_UP);

        return yield.toString();
    }
}