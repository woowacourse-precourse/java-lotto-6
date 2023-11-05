package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class View {
    public static int requestMoney(){
        return Integer.parseInt(Console.readLine());
    }
    public static void printMessage(String message) {
        System.out.println(message);
    }
    public static void newLine() {
        System.out.println();
    }
}
