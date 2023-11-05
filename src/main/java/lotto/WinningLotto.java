package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.Constant;

public class WinningLotto {

    private final String[] numbers;
    private int bonusNumber;

    public WinningLotto() {
        this.numbers = Console.readLine().split(",");
        setBonusNumber();
    }

    private void setBonusNumber() {
        System.out.println(Constant.bonusNumber);
        this.bonusNumber = Integer.parseInt(Console.readLine());
    }
}
