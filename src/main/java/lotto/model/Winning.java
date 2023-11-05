package lotto.model;

import java.util.List;

public class Winning {
    private final Long equalCount;
    private String bonus = "";

    public Winning(Long equalCount) {
        this.equalCount = equalCount;
    }

    public void updateBonus(List<Integer> userNumbers, int bonusNumber) {
        for (Integer userNumber : userNumbers) {
            if (userNumber == bonusNumber) {
                this.bonus = "보너스 볼";
                break;
            }
        }
    }

    public Long getEqualCount() {
        return equalCount;
    }

    public String getBonus() {
        return bonus;
    }
}
