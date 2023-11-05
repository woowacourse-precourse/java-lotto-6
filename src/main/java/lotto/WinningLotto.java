package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.Constant;

public class WinningLotto {

    private final List<Integer> winningNumbers = new ArrayList<>();
    private int bonusNumber;

    public WinningLotto() {
        for (String number : Console.readLine().split(",")) {
            int numbers = Integer.parseInt(number);
            this.winningNumbers.add(numbers);
        }
        setBonusNumber();
    }

    private void setBonusNumber() {
        System.out.println(Constant.bonusNumber);
        this.bonusNumber = Integer.parseInt(Console.readLine());
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
