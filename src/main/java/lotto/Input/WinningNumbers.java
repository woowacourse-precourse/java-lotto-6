package lotto.Input;

import lotto.DuplicationCheck;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    private static final List<Integer> numbers = new ArrayList<>();

    public static List<Integer> takeInput() {
        do {
            String input = camp.nextstep.edu.missionutils.Console.readLine();
            if (makeNumbers(input) && checkDuplicate()) {
                break;
            }
        } while (true);
        return numbers;
    }

    private static boolean makeNumbers(String input) {
        try {
            for (String number : input.split(",")) {
                RangeCheck.validateRange(number);
                numbers.add(Integer.valueOf(number));
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            numbers.clear();
            return false;
        }
        return true;
    }

    private static boolean checkDuplicate() {
        try {
            DuplicationCheck.validateDuplication(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 당첨 번호에는 중복이 없어야 합니다.");
            WinningNumbers.numbers.clear();
            return false;
        }
        return true;
    }
}
