package lotto.service;

import camp.nextstep.edu.missionutils.Console;

public class InputService {
    public static int inputMoney() {
        System.out.println("구입 금액을 입력해 주세요");
        String money = Console.readLine();
        return Integer.parseInt(money);
    }

    public static String inputNumbers() {
        System.out.println("당첨 번호를 입력해주세요.");
        String numbers = Console.readLine();
        return numbers;
    }

    public static String inputBonusNumber() {
        System.out.println("보너스 번호를 입력해주세요.");
        String number = Console.readLine();
        return number;
    }
}
