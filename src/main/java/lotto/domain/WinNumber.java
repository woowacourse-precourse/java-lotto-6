package lotto.domain;

import java.util.Collections;
import java.util.List;

public class WinNumber {
    private final List<Integer> pickNumbers;
    private final int bonusNumber;

    private WinNumber(List<Integer> pickNumbers, int bonusNumber) {
        this.pickNumbers = pickNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinNumber from(List<Integer> pickNumbers, int bonusNumber) {
        return new WinNumber(pickNumbers, bonusNumber);
    }

    public List<Integer> getPickNumbers() {
        return Collections.unmodifiableList(pickNumbers);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}