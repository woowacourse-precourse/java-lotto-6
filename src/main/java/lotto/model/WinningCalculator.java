package lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.IntStream;
import lotto.constant.LottoConstant;
import lotto.constant.LottoResult;

public final class WinningCalculator {
    private BigDecimal totalWinningMoney;
    private static final int LOTTO_COST = LottoConstant.LOTTO_PRICE.getValue();
    private static final int PERCENT = 100;

    private int lottoSales;

    public void setSales(int sales) {
        this.lottoSales = sales;
    }

    public void setTotalWinningMoney(List<Integer> lottoRankings) {
        this.totalWinningMoney = IntStream.range(LottoResult.FIFTH_RANK.getIndex(), LottoResult.FIRST_RANK.getIndex())
                .mapToObj(i -> BigDecimal.valueOf(lottoRankings.get(i))
                        .multiply(BigDecimal.valueOf(LottoResult.fromIndex(i).getMoney())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void setTotalWinningMoney(BigDecimal totalWinningMoney) {
        this.totalWinningMoney = totalWinningMoney;
        System.out.println(this.totalWinningMoney);
    }


    public BigDecimal getTotalWinningMoney() {
        return totalWinningMoney;
    }

    public BigDecimal calculateRateOfReturn() {
        BigDecimal totalSalesAmount = BigDecimal.valueOf((long) this.lottoSales * LOTTO_COST);

        return totalWinningMoney
                .divide(totalSalesAmount, 3, RoundingMode.DOWN)
                .multiply(BigDecimal.valueOf(PERCENT))
                .stripTrailingZeros();
    }

//    public BigDecimal calculateRateOfReturn() {
//        BigDecimal totalSalesAmount = BigDecimal.valueOf((long) this.lottoSales * LOTTO_COST);
//        return totalWinningMoney.subtract(totalSalesAmount)
//                .divide(totalWinningMoney, 3, RoundingMode.DOWN)
//                .multiply(BigDecimal.valueOf(PERCENT))
//                .stripTrailingZeros();
//    }

}
