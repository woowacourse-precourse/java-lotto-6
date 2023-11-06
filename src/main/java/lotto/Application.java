package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        int money = inputMoney();
        System.out.println(money);
    }

    public static Integer inputMoney() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요");
            String input = Console.readLine();
            try {
                int money = Integer.parseInt(input);
                return money;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 구입 금액은 정수로만 이루어져야 합니다.");
            }
        }
    }
}
