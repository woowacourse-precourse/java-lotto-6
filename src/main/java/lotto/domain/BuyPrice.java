package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class BuyPrice {
    static public int buylotto() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        System.out.println();
        return Integer.parseInt(input);
    }
}