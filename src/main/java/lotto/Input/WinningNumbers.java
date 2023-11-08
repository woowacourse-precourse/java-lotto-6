package lotto.Input;

import lotto.DuplicationCheck;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    static final int LOTTO_SIZE = 6;

    private static final List<Integer> numbers = new ArrayList<>();

    public static List<Integer> takeInput() {
        do {
            System.out.println("당첨 번호를 입력해 주세요.");
            String input = camp.nextstep.edu.missionutils.Console.readLine();
            if (makeNumbers(input) && checkDuplicate()) {
                break;
            }
        } while (true);
        System.out.println();
        return numbers;
    }

    private static boolean makeNumbers(String input) {
        try {
            for (String number : input.split(",")) {
                RangeCheck.validateRange(number);
                numbers.add(Integer.valueOf(number));
            }
            if (numbers.size() != LOTTO_SIZE) {
                throw new IllegalArgumentException();
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
