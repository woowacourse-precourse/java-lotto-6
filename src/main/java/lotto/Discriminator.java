package lotto;

import java.util.List;
import lotto.dto.LottoNumberDTO;
import lotto.dto.ProfitRateDTO;
import lotto.dto.StatisticDTO;

public class Discriminator {
    private Info info;
    private Lotto correctLotto;
    private int bonus;

    public Discriminator() {
        this.info = new Info();
    }

    public void setCorrectNumbers(Lotto lotto) {
        this.correctLotto = lotto;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public void discriminate(List<Integer> lotto) {
        int cnt = 0;

        for (int n : lotto) {
            if (correctLotto.getNumbers().contains(n)) {
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
