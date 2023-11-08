package lotto.domain;

import static lotto.constant.LottoResultIndex.SECOND_RANK_INDEX;
import static lotto.constant.LottoResultIndex.LOTTO_RESULT_SIZE;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class GameResult {
    private static final int INITIAL_AMOUNT = 0;
    private static final int DECIMAL_POINT = 1;
    private static final int PERCENTAGE_CONVERSION = 100;

    private final int[] lottoRankResult;
    private final List<Lotto> playerLotto;
    private final WinningLottoNumber winningLottoNumber;
    private final List<LottoRank> lottoResult;

    private GameResult(List<Lotto> playerLotto, WinningLottoNumber winningLottoNumber) {
        this.playerLotto = playerLotto;
        this.winningLottoNumber = winningLottoNumber;
        lottoRankResult = new int[LOTTO_RESULT_SIZE.getIndex()];
        lottoResult = new ArrayList<>();
    }

    public static GameResult of(List<Lotto> playerLotto, WinningLottoNumber winningLottoNumber) {
        return new GameResult(playerLotto, winningLottoNumber);
    }

    public int[] calculateLottoRankResult() {
        calculateRank();

        for (LottoRank eachRank : lottoResult) {
            if (eachRank.getMatchNumbers() == LottoRank.SECOND_RANK.getMatchNumbers()) {
                lottoRankResult[SECOND_RANK_INDEX.getIndex()]++;
                continue;
            }
            lottoRankResult[eachRank.getMatchNumbers()]++;
        }

        return lottoRankResult;
    }

    private void calculateRank() {
        for (Lotto eachLotto : playerLotto) {
            lottoResult.add(winningLottoNumber.calculateLottoPrize(eachLotto));
        }
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