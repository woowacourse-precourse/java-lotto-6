package lotto.Input;

import java.util.List;

public class BonusNumber {
    private static int number;

    public static int takeInput(List<Integer> winningNumbers) {
        do {
            System.out.println("보너스 번호를 입력해 주세요.");
            String input = camp.nextstep.edu.missionutils.Console.readLine();
            if (makeNumber(input) && checkDuplicate(winningNumbers)) {
                break;
            }
        } while (true);
        System.out.println();
        return number;
    }

    private static boolean makeNumber(String input) {
        try {
            RangeCheck.validateRange(input);
            number = Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            return false;
        }
        return true;
    }

    private static boolean checkDuplicate(List<Integer> winningNumbers) {
        try {
            if (winningNumbers.contains(number)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 보너스 번호는 당첨 번호와 같을 수 없습니다.");
            return false;
        }
        return true;
    }
}
