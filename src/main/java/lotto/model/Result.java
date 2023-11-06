package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private final List<Integer> userNumbers;
    private final Long equalCount;
    private String bonus = "";

    public Result(List<Integer> userNumbers, Long equalCount) {
        this.userNumbers = userNumbers;
        this.equalCount = equalCount;
    }

    public void updateBonus(int bonusNumber) {
        for (Integer userNumber : userNumbers) {
            if (userNumber == bonusNumber) {
                this.bonus = "보너스 볼";
                break;
            }
        }
    }

    public List<Integer> getUserNumbers() {
        return new ArrayList<>(userNumbers);
    }

    public Long getEqualCount() {
        return equalCount;
    }

    public String getBonus() {
        return bonus;
    }
}
