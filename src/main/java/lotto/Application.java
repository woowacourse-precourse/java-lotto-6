package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");
        int purchase = Integer.parseInt(Console.readLine());
        if (purchase % 1000 != 0) {
            throw new IllegalArgumentException("[Error] 올바른 금액을 입력해주세요.");
        }
        System.out.println();


    }
}
