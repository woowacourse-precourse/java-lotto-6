package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

    }
    private static int deposit() {
        System.out.println("구매금액을 입력해 주세요.");
        String depositMoney = Console.readLine();
        int change = Integer.parseInt(depositMoney);
        try {
            if (change % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 1000원 단위로 나누어지는 금액을 입력해주세요.");
            }
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            deposit();
        }
        return change / 1000;
    }
}
