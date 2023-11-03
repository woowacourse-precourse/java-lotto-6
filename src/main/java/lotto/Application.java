package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    private static int inMoney;
    private static int count;
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 로또 구입 금액 입력
        lottoMoney();
        // 로또 수량 출력
        printLottoCount();
    }

    public static void printLottoCount() {
        count = inMoney / 1000;
        System.out.println(count + "개를 구매했습니다.");
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
