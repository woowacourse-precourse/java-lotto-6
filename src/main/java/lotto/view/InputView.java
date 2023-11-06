package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = readLine();
        isDigit(money);
        canDivideByKilo(money);
        return Integer.parseInt(money);
    }

    public static String inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputWinningNumbers = readLine();
        return inputWinningNumbers;
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputBonusNumber = readLine();
        isDigit(inputBonusNumber);

        return Integer.parseInt(inputBonusNumber);
    }

    private static void isDigit(String money) {
        if (!money.matches("-?\\d+")) {
            throw new IllegalArgumentException("[ERROR] 정수를 입력해 주세요.");
        }
    }

    private static void canDivideByKilo(String money) {
        if (Integer.parseInt(money) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 천 원단위로 입력해 주세요.");
        }
    }
}