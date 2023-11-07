package lotto;

import java.util.List;

public class LuckeyLotto {
    private int luckeyBonusNumber;
    private List<Integer> luckeyNumbers;

    public LuckeyLotto(List<Integer> luckeyNumbers, String inputBonusNumber) {
        int luckeyBonusNumber = Integer.valueOf(inputBonusNumber);
        luckeyNumbers.add(luckeyBonusNumber);
        this.luckeyNumbers = luckeyNumbers;
        this.luckeyBonusNumber = luckeyBonusNumber;
    }
}
