package lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import lotto.constant.Ranking;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.WinningMoney;

public class LottoStore {
    private static final int LOTTO_COST = 1000;
    private int lottoSales;
    private BigDecimal totalWinningMoney;

    public void setLottoSales(int lottoSales) {
        this.lottoSales = lottoSales;
    }

    public void setTotalWinningMoney(List<Integer> lottoRankings) {
        Stream<BigDecimal> winningAmounts = IntStream.range(1, lottoRankings.size())
                .mapToObj(i -> BigDecimal.valueOf(lottoRankings.get(i))
                        .multiply(BigDecimal.valueOf(WinningMoney.values()[i-1].getMoney())));

        this.setTotalWinningMoney(winningAmounts.reduce(BigDecimal.ZERO, BigDecimal::add));
    }

    public List<Integer> rankLottos(List<Lotto> customerLotto, Lotto winningLotto, int bonusNumber) {
        List<Integer> lottoRank = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0));
        for (Lotto customer : customerLotto) {
            int matchNumber = compareLotto(customer.getNumbers(), winningLotto.getNumbers(), bonusNumber);
            lottoRank.set(
                    setRanking(matchNumber),
                    lottoRank.get(setRanking(matchNumber)) + 1
            );
        }
        return lottoRank;
    }

    private int compareLotto(List<Integer> customerLotto, List<Integer> winningLotto, int bonusNumber) {
        int matchCount = 0;
        for (Integer lotto : customerLotto) {
            if (winningLotto.contains(lotto)) {
                matchCount++;
            }
        }
        if (matchCount == 5 && isBonusInNumbers(customerLotto, bonusNumber)) {
            matchCount = 7;
        }

        return matchCount;
    }

    private int setRanking(int matchNumber) {
        int flag = 0;
        if (matchNumber == 3) {
            flag = Ranking.MATCH_THREE.getValue();
        } else if (matchNumber == 4) {
            flag = Ranking.MATCH_FOUR.getValue();
        } else if (matchNumber == 5) {
            flag = Ranking.MATCH_FIVE.getValue();
        } else if (matchNumber == 6) {
            flag = Ranking.MATCH_SIX.getValue();
        } else if (matchNumber == 7) {
            flag = Ranking.MATCH_BONUS.getValue();
        }
        return flag;
    }

    public BigDecimal calculateRateOfReturn() {
        BigDecimal intDivisor = BigDecimal.valueOf((long) this.lottoSales * LOTTO_COST);
        return this.totalWinningMoney.divide(intDivisor, 3, RoundingMode.DOWN)
                .multiply(BigDecimal.valueOf(100)).stripTrailingZeros();
    }


    private boolean isBonusInNumbers(List<Integer> numbers, int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public BigDecimal getTotalWinningMoney() {
        return totalWinningMoney;
    }

    public void setTotalWinningMoney(BigDecimal totalWinningMoney) {
        this.totalWinningMoney = totalWinningMoney;
    }
}
