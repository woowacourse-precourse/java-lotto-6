package lotto;

import java.util.List;

public class Exception {
    public static void notNumber(String inputData) throws IllegalArgumentException {
        try {
            Integer.parseInt(inputData);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    public static void notThousandWon(String inputData) throws IllegalArgumentException {
        final int thousandWon = 1000;
        final int zero = 0;
        int amount = Integer.parseInt(inputData);

        if (amount == zero || amount % thousandWon != zero) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로만 입력 가능합니다.");
        }
    }

    public static void overLimitCount(int inputSize, int limitCount) throws IllegalArgumentException {
        if (inputSize != limitCount) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개만 입력 가능합니다.");
        }
    }

    public static void duplicateWinNumbers(List<Integer> winNumbers) throws IllegalArgumentException {
        final int firstIndex = 0;

        for (int i = 0; i < winNumbers.size(); i++) {
            int number = winNumbers.remove(firstIndex);
            if (winNumbers.contains(number)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 서로 다른 숫자만 입력 가능합니다.");
            }
            winNumbers.add(number);
        }
    }

    public static void duplicateBonusNumber(List<Integer> winNumbers, int bonusNumber) throws IllegalArgumentException {
        if (winNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 서로 다른 숫자만 입력 가능합니다.");
        }
    }

    public static void overLimitNumberRange(int number) throws IllegalArgumentException {
        final int startRangeNumber = 1;
        final int endRangeNumber = 45;

        if (number < startRangeNumber || number > endRangeNumber) {
            throw new IllegalArgumentException("[ERROR] 번호는 1부터 45 사이의 숫자만 입력 가능합니다.");
        }
    }
}
