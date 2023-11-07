package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.Exception;

import java.util.ArrayList;
import java.util.List;

public class Draw {
    Exception exception = null;
    List<Integer> winningNumber = null;
    boolean exist = true;

    public void winningNumbers() {
        exception = new Exception();
        System.out.println("당첨 번호를 입력해 주세요.");
        while (winningNumber.size() != 6) {
            String number = Console.readLine();
            winningNumber = exception.checkNumbers(number);
        }
        System.out.println("보너스 번호를 입력해 주세요.");
        while (exist) {
            String bonus = Console.readLine();
            exist = exception.checkBonus(winningNumber, bonus, exist);
        }
    }
}
