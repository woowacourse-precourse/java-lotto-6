package lotto.model;

import java.util.ArrayList;
import java.util.List;

import static lotto.Message.ErrorMessage.OBJECT_IS_NULL;

public class Result {
    private final List<Integer> userNumbers;
    private final int equalCount;
    private final String bonus;

    public Result(List<Integer> userNumbers, int equalCount, String bonus) {
        if (userNumbers == null) {
            throw new NullPointerException(OBJECT_IS_NULL.getMessage());
        }
        this.userNumbers = userNumbers;
        this.equalCount = equalCount;
        this.bonus = bonus;
    }

    public List<Integer> getUserNumbers() {
        return new ArrayList<>(userNumbers);
    }

    public int getEqualCount() {
        return equalCount;
    }

    public String getBonus() {
        return bonus;
    }
}
