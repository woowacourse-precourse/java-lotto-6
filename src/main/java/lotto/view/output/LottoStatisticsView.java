package lotto.view.output;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import lotto.domain.Amount;
import lotto.domain.JudgeCounter;
import lotto.util.constants.OutputConstants;
import lotto.util.constants.Prize;

public class LottoStatisticsView implements Output {

    private final JudgeCounter judgeCounter;
    private final Amount amount;

    public LottoStatisticsView(JudgeCounter judgeCounter, Amount amount) {
        this.judgeCounter = judgeCounter;
        this.amount = amount;
    }

    @Override
    public void getOutput() {
        displayResult();
    }

    public void displayResult() {
        double profitRatio = calculateProfitRatio().doubleValue();
        System.out.println(OutputConstants.LOTTO_STATISTICS_MESSAGE.getMessage());
        System.out.println(OutputConstants.LINE_SEPARATOR.getMessage());
        for (OutputConstants constant : getConstants()) {
            int rank = constant.getNumber();
            int judgeCount = judgeCounter.getCount(rank);
            System.out.println(constant.format(judgeCount));
        }
        System.out.println(OutputConstants.LOTTO_PROFIT_RATIO.format(profitRatio));
    }

    private List<OutputConstants> getConstants() {
        return Arrays.stream(OutputConstants.values())
                .sorted(Comparator.comparingInt(OutputConstants::getNumber).reversed())
                .filter(constants -> constants.getNumber() > 0 && constants.name().contains("RANK"))
                .toList();
    }

    private BigDecimal calculateProfitRatio() {
        long sum = 0L;
        int digit = OutputConstants.ROUNDING_DIGIT.getNumber();
        for (Prize prize : Prize.values()) {
            sum += prize.getReward() * judgeCounter.getCount(prize.getRank());
        }
        double profitRatio = (sum / (double) this.amount.getAmount()) * 100;
        return new BigDecimal(profitRatio).setScale(digit, RoundingMode.HALF_UP);
    }
}
