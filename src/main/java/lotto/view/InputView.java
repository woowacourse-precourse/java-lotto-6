package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String collectionOfMoney() {
        print("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        print("");
        return input;
    }

    private static void print(String message) {
        System.out.println(message);
    }
}
