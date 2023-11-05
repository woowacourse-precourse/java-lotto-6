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

    private void calculateRateOfReturn(Integer amountQuantity){
        int investmentMoney = amountQuantity * MIN_VALUE.getAmount();
        BigDecimal findInvestmentMoney = new BigDecimal(investmentMoney);
        BigDecimal findTotalMoney = new BigDecimal(this.totalMoney);
        BigDecimal profitRate = findTotalMoney.divide(findInvestmentMoney,3,RoundingMode.HALF_UP);
        this.rateOfReturn = profitRate.multiply(BigDecimal.valueOf(100)).setScale(1, RoundingMode.HALF_UP);
    }

    public BigDecimal getRateOfReturn() {
        return rateOfReturn;
    }
}
