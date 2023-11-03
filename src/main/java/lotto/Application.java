package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static int inMoney;
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 로또 구입 금액 입력
        lottoMoney();

    }

    public static void lottoMoney() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String s = Console.readLine();
            try {
                inMoney = Integer.parseInt(s);
                validateMoney();
                return;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 금액을 잘못 입력하셨습니다.");
            }
        }
    }

    public static void validateMoney() {
        if (inMoney % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}
