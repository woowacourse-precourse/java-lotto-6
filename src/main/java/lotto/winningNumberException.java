package lotto;

import java.util.HashSet;
import java.util.Set;

public class winningNumberException {
    public static void isContainComma(String winningNumbers) {
        if(!winningNumbers.contains(",")) {
            throw new IllegalArgumentException("당첨 번호는 쉼표로 구분해주세요.");
        }
    }
    public static void getBeWinningNumbers(String inputWinningNumbers) {
        Set<Integer> uniqueWinningNumbers = new HashSet<>();
        for (String inputWinningNumber: inputWinningNumbers.split(",")) {
            int num = isRangeIn(inputWinningNumber);
            if (!uniqueWinningNumbers.add(num)) {
                throw new IllegalArgumentException("당첨 번호는 중복될 수 없습니다.");
            }
        }

        if (uniqueWinningNumbers.size()!=6) {
            throw new IllegalArgumentException("당첨 번호는 6개의 숫자를 입력해야합니다.");
        }
    }
    public static int isRangeIn(String inputWinningNumber) {

        try {
            int num = Integer.parseInt(inputWinningNumber.trim());
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException("번호는 1에서 45사이의 숫자입니다.");
            }
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("당첨 번호는 숫자여야 합니다.");
        }
    }
}
