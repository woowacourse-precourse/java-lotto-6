package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class DrawMachineModel {
    List<Integer> winningNumbers;

    private void setWinningNumbers() {
        this.winningNumbers = Randoms.pickUniqueNumbersInRange(RuleModel.MIN_NUMBER.value(), RuleModel.MAX_NUMBER.value(), RuleModel.DIGITS.value());
    }
}
