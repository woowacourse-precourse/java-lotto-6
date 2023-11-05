package lotto.domain;

import java.util.List;

public class LottoResult {
    private final int[] counter = new int[Prize.values().length];
    private int totalCost = 0;
    private long totalReward = 0;

    public void aggregate(Prize prize) {
        counter[prize.ordinal()]++;
        totalCost += LottoMachine.lottoCost;
        totalReward += prize.getReward();
    }

    public String getReport() {
        List<Prize> prizes = List.of(Prize.FIFTH, Prize.FOURTH, Prize.THIRD, Prize.SECOND, Prize.FIRST);
        StringBuilder sb = new StringBuilder();
        for (Prize prize : prizes) {
            sb.append(getPrizeReport(prize)).append('\n');
        }
        sb.append(getROIReport());
        return sb.toString();
    }

    public String getPrizeReport(Prize prize) {
        StringBuilder sb = new StringBuilder();
        sb.append(prize.getCorrectNumber()).append("개 일치");
        if (prize.isNeedCorrectBonus()) {
            sb.append(", 보너스 볼 일치");
        }

        String thousandSeparated = String.format("%,d", prize.getReward());
        sb.append(" (").append(thousandSeparated).append("원)");

        sb.append(" - ").append(counter[prize.ordinal()]).append("개");
        return sb.toString();
    }

    public String getROIReport() {
        double roi = (double) totalReward / totalCost * 100;
        double rounded = Math.round(roi * 10) / 10.0;
        return "총 수익률은 " + String.format("%.1f", rounded) + "%입니다.";
    }
}
