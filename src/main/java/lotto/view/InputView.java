package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {

    }

    public static int getInputNumber() {
        System.out.println("구입금액을 입력해 주세요.");

        while (true) {
            try {
                return checkInputNumber(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int checkInputNumber(String input) {
        int inputNumber = 0;

        try {
            inputNumber = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다. 다시 입력해주세요.");
        }

        if (inputNumber == 0 || inputNumber % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위의 숫자만 입력 가능합니다. 다시 입력해주세요.");
        }

        return inputNumber;
    }
}
