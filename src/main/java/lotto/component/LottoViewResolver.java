package lotto.component;

import java.util.List;
import lotto.domain.grade.Grade;
import lotto.domain.grade.GradeCount;
import lotto.domain.result.Profit;
import lotto.domain.result.Result;
import lotto.domain.result.Statistics;
import lotto.service.LottoMessagePrinter;

public class LottoViewResolver {

    private final LottoMessagePrinter writer;

    public static LottoViewResolver of(LottoMessagePrinter writer) {
        return new LottoViewResolver(writer);
    }

    private LottoViewResolver(LottoMessagePrinter writer) {
        this.writer = writer;
    }

    public void showResult(Result result) {
        writer.printResult();

        showStatistics(result.getStatistics());
        showProfit(result.getProfit());
    }

    private void showStatistics(Statistics statistics) {
        List<GradeCount> gradeCounts = statistics.getGradeCounts();

        for (GradeCount gradeCount : gradeCounts) {
            if (gradeCount.getGrade() == Grade.NONE) {
                continue;
            }
            writer.printStatistics(gradeCount.getGrade(), gradeCount.getCount());
        }
    }

    public void showProfit(Profit profit) {
        writer.printProfit(profit.getPercentage());
    }
}
