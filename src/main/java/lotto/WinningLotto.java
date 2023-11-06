package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.Constant;

public class WinningLotto {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningLotto() {
        this.winningNumbers = initializeWinningNumbers();
        this.bonusNumber = initializeBonusNumber();
    }

    private List<Integer> initializeWinningNumbers() {
        List<Integer> inputNumbers = new ArrayList<>();

        for (String number : Console.readLine().split(",")) {
            inputNumbers.add(Integer.parseInt(number));
        }

        return inputNumbers;
    }

    private int initializeBonusNumber() {
        System.out.println(Constant.bonusNumber);
        return Integer.parseInt(Console.readLine());
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
