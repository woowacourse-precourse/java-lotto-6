package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumber {

    static private List<Integer> winningNumbers;
    static private int bonusNumber;

    static public void gettingWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        winningNumbers = Arrays.stream(input.split(","))
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
        validateWinningNumber();
    }

    static public void gettingBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        bonusNumber = Integer.parseInt(input);
        validateBonusNumber();
    }

    static public void validateWinningNumber() {
        try {
            for (int num: winningNumbers) {
                if (num < 1 | num > 45) {
                    throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                }
            }
            Set<Integer> numSet = new HashSet<Integer>(winningNumbers);
            if (numSet.size() != winningNumbers.size()) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되어서는 안 됩니다.");
            }
            if (winningNumbers.size() != 6) {
                throw new IllegalArgumentException("[ERROR] 로또 번호의 개수는 6개여야 합니다.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            gettingWinningNumber();
        }
    }

    static public void validateBonusNumber() {
        try {
            if (bonusNumber < 1 | bonusNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            gettingBonusNumber();
        }
    }
}
