package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class View {

    public static void printStartMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static String input() {
        return Console.readLine();
    }

    public static void printPurchaseMessage(int quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
    }

}
