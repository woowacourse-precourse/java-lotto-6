package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Bonus {

    private final int bonusNumber;

    public Bonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
        this.bonusNumber = Integer.parseInt(Console.readLine());
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public boolean isContainBonusNumber(List<Integer> lottoNumbers){
        return lottoNumbers.contains(bonusNumber);
    }
}
