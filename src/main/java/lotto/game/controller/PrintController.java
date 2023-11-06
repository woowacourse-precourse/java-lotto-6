package lotto.game.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import lotto.adapter.IoAdapter;
import lotto.domain.Statistics;
import lotto.message.LottoMessage;
import lotto.vo.Money;

public class PrintController {

    private final IoAdapter ioAdapter;

    public PrintController(IoAdapter ioAdapter) {
        this.ioAdapter = ioAdapter;
    }

    public void statistics(Statistics statistics) {
        LottoMessage winningStatistics = LottoMessage.WINNING_STATISTICS;
        LottoMessage horizontalRule = LottoMessage.HORIZONTAL_RULE;
        ioAdapter.printMessage(winningStatistics.getMessage());
        ioAdapter.printMessage(horizontalRule.getMessage());
        List<String> rankStatistics = statistics.rankStatistics();
        rankStatistics.forEach(ioAdapter::printMessage);
    }

    public void rateOfReturn(Money money, Statistics statistics) {
        BigDecimal calcRateOfReturn = statistics.calcRateOfReturn(money.getMoney());
        LottoMessage rateOfReturnHead = LottoMessage.RATE_OF_RETURN_HEAD;
        LottoMessage rateOfReturnTail = LottoMessage.RATE_OF_RETURN_TAIL;
        String rateOfReturn = rateOfReturnHead.getMessage() +
                calcRateOfReturn.setScale(1, RoundingMode.HALF_UP) + rateOfReturnTail.getMessage();
        ioAdapter.printMessage(rateOfReturn);
    }

    public void newLine() {
        ioAdapter.printNewLine();
    }
}
