package lotto;

public class Exception {
    public static void notNumber(String inputData) throws IllegalArgumentException {
        try {
            Integer.parseInt(inputData);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.\n");
        }
    }

    public static void notThousandWon(String inputData) throws IllegalArgumentException {
        int amount = Integer.parseInt(inputData);

        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로만 입력 가능합니다.\n");
        }
    }

    public static void overLimitCount(int inputSize, int limitCount) throws IllegalArgumentException {
        if (inputSize > limitCount) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개만 입력 가능합니다.\n");
        }
    }
}
