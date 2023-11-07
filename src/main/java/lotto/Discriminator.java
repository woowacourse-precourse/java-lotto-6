package lotto;

import java.util.List;

public class Discriminator {
    private List<Integer> correctNumbers;
    private int bonus;

    public Discriminator(List<Integer> correctNumbers, int bonus) {
        this.correctNumbers = correctNumbers;
        this.bonus = bonus;
    }

    public Grade discriminate(List<Integer> lotto) {
        int cnt = 0;

        for (int n : lotto) {
            if (correctNumbers.contains(cnt)) {
                cnt++;
            }
        }

        return GradeUtil.gradeMapper(cnt, lotto.contains(bonus));
    }
}
