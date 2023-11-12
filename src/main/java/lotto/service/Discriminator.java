package lotto.service;

import java.util.List;
import lotto.dto.ProfitRateDTO;
import lotto.dto.StatisticDTO;
import lotto.model.Bonus;
import lotto.model.Info;
import lotto.model.Lotto;
import lotto.util.GradeUtil;

public class Discriminator {
    private Info info;
    private Lotto correctLotto;
    private Bonus bonus;

    public Discriminator() {
        this.info = new Info();
    }

    public void setCorrectNumbers(Lotto lotto) {
        this.correctLotto = lotto;
    }

    public void setBonus(Bonus bonus) {
        this.bonus = bonus;
    }

    public void discriminate(List<Integer> lotto) {
        int cnt = 0;

        for (int n : lotto) {
            if (correctLotto.getNumbers().contains(n)) {
                cnt++;
            }
        }

        info.addStatistic(GradeUtil.gradeMapper(cnt, lotto.contains(bonus.getBonus())));
    }

    public StatisticDTO getStatistic() {
        return new StatisticDTO(info.getStatistic());
    }

    public ProfitRateDTO getProfitRate(int won) {
        double rate = (info.getRewards() * 100.0) / won;

        return new ProfitRateDTO(rate);
    }
}
