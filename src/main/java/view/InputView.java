package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static int inputNumber() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                int count = isNumber(Console.readLine());
                countCheck(count);

                return count;
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
            }
        }
    }

    public static void countCheck(int count) throws IllegalArgumentException {
        if (count % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구매가격은 1,000원 단위로 입력해주세요.");
        }
    }

    public static int isNumber(String number) {
        try {
            int count = Integer.parseInt(number);
            return count;
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }
}
