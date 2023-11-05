package lotto.calculator;

import static lotto.enums.AmountEnum.MIN_VALUE;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import lotto.enums.AmountEnum;
import lotto.enums.WinningChartEnum;
import lotto.lotto.ScratchedLottoTicket;
import lotto.lotto.ScratchedLottoTicketList;

public class MoneyCalculator{
    private Integer totalMoney;
    private BigDecimal rateOfReturn;

    public void calculate(ScratchedLottoTicketList scratchedLottoTicketList, Integer investmentMoney){
        this.calculateTotalMoney(scratchedLottoTicketList);
        this.calculateRateOfReturn(investmentMoney);
    }

    private void calculateTotalMoney(ScratchedLottoTicketList scratchedLottoTicketList){
        List<WinningChartEnum> prizes = scratchedLottoTicketList.getScratchedLottoTickets().stream()
                .map(ScratchedLottoTicket::getWinningChartEnum).toList();
        List<Integer> prizeMoney = prizes.stream().map(WinningChartEnum::getPrize).toList();

        totalMoney = prizeMoney.stream().mapToInt(Integer::intValue).sum();
    }

    public void calculateRateOfReturn(Integer amountQuantity){
        int investmentMoney = amountQuantity * MIN_VALUE.getAmount();
        BigDecimal findInvestmentMoney = new BigDecimal(investmentMoney);
        BigDecimal totalMoney = new BigDecimal(this.totalMoney);
        BigDecimal profit = totalMoney.subtract(findInvestmentMoney);
        this.rateOfReturn = profit.divide(findInvestmentMoney, 1, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100));
    }

    public Integer getTotalMoney() {
        return totalMoney;
    }

    public BigDecimal getRateOfReturn() {
        return rateOfReturn;
    }
}
