package lotto;

import java.util.List;
import lotto.dto.StatisticDTO;

public class Discriminator {
    private Info info;
    private List<Integer> correctNumbers;
    private int bonus;

    public Discriminator(List<Integer> correctNumbers, int bonus) {
        this.correctNumbers = correctNumbers;
        this.bonus = bonus;
        this.info = new Info();
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
        return new StatisticDTO(info.getStatistics());
    }
}
