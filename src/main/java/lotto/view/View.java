package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class View {
    public static int requestMoney(){
        printMessage("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
    public static void printMessage(String message) {
        System.out.println(message);
    }
    public static void printNewLine() {
        System.out.println();
    }
}
