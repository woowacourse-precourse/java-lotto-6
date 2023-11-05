package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public int requestPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String stringPurchaseAmount = Console.readLine();
        return Integer.parseInt(stringPurchaseAmount);
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
