package lotto;

import java.util.List;
import lotto.dto.ProfitRateDTO;
import lotto.dto.StatisticDTO;

public class Discriminator {
    private Info info;
    private List<Integer> correctNumbers;
    private int bonus;

    public Discriminator(int bonus) {
        this.bonus = bonus;
        this.info = new Info();
    }

    public void setCorrectNumbers(List<Integer> correctNumbers) {
        this.correctNumbers = correctNumbers;
    }

    public void discriminate(List<Integer> lotto) {
        int cnt = 0;

        for (int n : lotto) {
            if (correctNumbers.contains(cnt)) {
                cnt++;
            }
        }

        info.addStatistic(GradeUtil.gradeMapper(cnt, lotto.contains(bonus)));
    }

    public StatisticDTO getStatistic() {
        return new StatisticDTO(info.getStatistic());
    }

    public ProfitRateDTO getProfitRate(int won) {
        double rate = ((info.getRewards() * 100) / won) / 100.0;

        return new ProfitRateDTO(rate);
    }
}
