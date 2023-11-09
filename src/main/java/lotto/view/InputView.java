package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String collectionOfMoney() {
        print("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        print("");
        return input;
    }

    public static String receiveWinningNumber() {
        print("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static String receiveBonusNumber() {
        print("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

    private static void print(String message) {
        System.out.println(message);
    }
}
