package lotto.model;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class ProfitCalculator
{

    private final int lottoPrice;
    private final List<Integer> matchCounts;
    private final List<Integer> prizeMoneyList = List.of(5000, 50000, 1500000, 30000000, 2000000000);

    public ProfitCalculator(int lottoPrice, List<Integer> matchCounts)
    {
        this.lottoPrice = lottoPrice;
        this.matchCounts = matchCounts;
    }

    public BigDecimal calculateProfit()
    {
        int totalPrize = 0;
        for (int i = 0; i < matchCounts.size(); i++)
        {
            totalPrize += matchCounts.get(i) * prizeMoneyList.get(i);
        }

        BigDecimal profitRate = new BigDecimal(totalPrize)
                .divide(new BigDecimal(lottoPrice), 2, RoundingMode.HALF_EVEN)
                .multiply(new BigDecimal(100))
                .setScale(1, RoundingMode.DOWN);

        return profitRate;

    }

}
