package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    static int askPurchaseAmount() {
        System.out.println("구매금액을 입력해 주세요.");
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
