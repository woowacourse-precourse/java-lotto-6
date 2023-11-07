package lotto;

import java.util.List;

public class Comparator {
    private final int match;
    private final boolean bonus;

    public Comparator(List<Integer> ticket, List<Integer> lotto, int bonusNumber) {
        this.match = compareLotto(ticket, lotto);
        this.bonus = compareBonus(ticket, bonusNumber);
    }

    private int compareLotto(List<Integer> user, List<Integer> lotto) {
        int match = 0;
        for (Integer userNumber : user) {
            if (lotto.contains(userNumber)) {
                match++;
            }
        }
        return match;
    }

    private boolean compareBonus(List<Integer> user, int bonusNumber) {
        return user.contains(bonusNumber);
    }

    public int getMatch() {
        return match;
    }

    public boolean getBonus() {
        return bonus;
    }
}
