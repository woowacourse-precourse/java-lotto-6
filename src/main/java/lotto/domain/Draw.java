package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.Exception;

import java.util.ArrayList;
import java.util.List;

public class Draw {
    Exception exception = null;
    private List<Integer> winningNumber = null;
    private int bonusNumber = 0;

    public Draw() {
        exception = new Exception();
        winningNumber = new ArrayList<>();
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void winningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        while (winningNumber.size() != 6) {
            String number = Console.readLine();
            winningNumber = exception.checkNumbers(number);
        }
        System.out.println("보너스 번호를 입력해 주세요.");
        while (bonusNumber < 1) {
            String bonus = Console.readLine();
            bonusNumber = exception.checkBonus(winningNumber, bonus);
        }
    }
}
