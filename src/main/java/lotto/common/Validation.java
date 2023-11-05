package lotto.common;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.WinningNumbers;

import java.util.List;

public class Validation {

    public static int validatePurchaseMoney() {
        try {
            int input = Integer.parseInt(Console.readLine());
            if (input < 1000) throw new IllegalArgumentException("[ERROR] 1000원 이상 입력해 주세요.");
            if (input % 1000 != 0) throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해 주세요.");
            return input;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }


    public static void validateInputWinningNums(List<Integer> winningNums) {
        try {
            String s = Console.readLine();
            String[] split = s.split(",");
            for (int i = 0; i < split.length; i++) {
                int num = Integer.parseInt(split[i]);
                if (num < 1 || num > 45) throw new IllegalArgumentException("[ERROR] 당첨번호는 1부터 45까지 숫자 중에서 입력해 주세요.");
                winningNums.add(num);
            }
            if (winningNums.size() != 6) throw new IllegalArgumentException("[ERROR] 당첨번호를 6개 입력해 주세요.");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨번호를 올바르게 입력해 주세요.");
        }
    }

    public static int validateInputBonusNum(WinningNumbers winningNumbers) {
        try {
            int bonus = Integer.parseInt(Console.readLine());
            if (winningNumbers.getWinningNums().contains(bonus)) throw new IllegalArgumentException("[ERROR] 이미 입력된 번호입니다.");
            return bonus;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }

    }
}
