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
                try {
                    checkMoney(money);
                    return money;
                } catch (IllegalArgumentException e) {
                    System.out.println("[ERROR] 구입 금액은 1000원 단위로 이루어져야 합니다.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 구입 금액은 정수로만 이루어져야 합니다.");
            }
        }
    }

    public static void checkMoney(int money) {
        if (money % 1000 == 0) {
            return;
        }
        throw new IllegalArgumentException();
    }
}
