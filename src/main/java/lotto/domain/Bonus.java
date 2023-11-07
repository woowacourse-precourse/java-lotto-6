package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class Bonus {

    private final int bonusNumber;

    public Bonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
        this.bonusNumber = Integer.parseInt(Console.readLine());
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
