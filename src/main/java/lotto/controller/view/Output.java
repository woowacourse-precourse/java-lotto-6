package lotto.controller.view;

import lotto.contants.LottoEnum;
import lotto.contants.OutputEnum;
import lotto.util.Printer;

import java.util.Map;

public class Output {
    private final Printer printer;

    public Output(Printer printer) {
        this.printer = printer;
    }

    public void printView(Map<LottoEnum.grade, Integer> gradeMap){
        printer.println(OutputEnum.output.WINNING_STATISTICS.getDescription());
        printer.println(OutputEnum.output.___.getDescription());
        printer.println(OutputEnum.output.THREE_MATCH.getDescription()
                +gradeMap.get(LottoEnum.grade.FIFTH)
                +OutputEnum.output.COUNT.getDescription());
        printer.println(OutputEnum.output.FOUR_MATCH.getDescription()
                +gradeMap.get(LottoEnum.grade.FOURTH)
                +OutputEnum.output.COUNT.getDescription());
        printer.println(OutputEnum.output.FIVE_MATCH.getDescription()
                +gradeMap.get(LottoEnum.grade.THIRD)
                +OutputEnum.output.COUNT.getDescription());
        printer.println(OutputEnum.output.FIVE_MATCH_AND_BONUS.getDescription()
                +gradeMap.get(LottoEnum.grade.SECOND)
                +OutputEnum.output.COUNT.getDescription());
        printer.println(OutputEnum.output.SIX_MATCH.getDescription()
                +gradeMap.get(LottoEnum.grade.FIRST)
                +OutputEnum.output.COUNT.getDescription());
    }

    public void printProfitRate(double profitRate){
        printer.println(OutputEnum.output.PROFIT_RATE_IS.getDescription()
        +profitRate
        +OutputEnum.output.PERCENTAGE.getDescription());
    }
}
