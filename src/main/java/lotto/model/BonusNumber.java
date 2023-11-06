package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber, Lotto lotto) {
        rangeCheck(bonusNumber); // 1~45 사이의 숫자인지 체크
        duplicationCheck(lotto, bonusNumber);// 중복 숫자 있는 지 체크
        this.bonusNumber = bonusNumber;
    }
    public void rangeCheck(int num) {
        if (num < 1 || 45 < num) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public void duplicationCheck(Lotto winningNums, int bonusNum){
        if (winningNums.getNumbers().contains(bonusNum)){
            throw new IllegalArgumentException("[ERROR] 중복된 숫자를 선택할 수 없습니다.");
        }
    }

    public int getNumbers() {
        return bonusNumber;
    }
}
