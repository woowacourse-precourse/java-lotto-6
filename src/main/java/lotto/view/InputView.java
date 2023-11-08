package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

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
            System.out.println();
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다. 다시 입력해주세요.");
        }

        if (inputNumber == 0 || inputNumber % 1000 != 0) {
            System.out.println();
            throw new IllegalArgumentException("[ERROR] 1,000원 단위의 숫자만 입력 가능합니다. 다시 입력해주세요.");
        }

        return inputNumber;
    }

    public static int getBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");

        while (true) {
            try {
                return checkBonusNumber(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int checkBonusNumber(String input) {
        int inputNumber = 0;

        try {
            inputNumber = Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println();
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다. 다시 입력해주세요.");
        }

        if (inputNumber < Lotto.LOTTO_NUMBER_MIN || inputNumber > Lotto.LOTTO_NUMBER_MAX) {
            System.out.println();
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이의 숫자입니다.");
        }

        return inputNumber;
    }
}
