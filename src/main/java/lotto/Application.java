package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    static int lottoMoney = 0;
    public static boolean lottoMoneyInput() {
        try {
            String userInput = Console.readLine();
            lottoMoney = Integer.parseInt(userInput);
            if (lottoMoney % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위로 입력해야 합니다.");
            }
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }
    public static void main(String[] args) {
        // 로또 구입 금액 입력받고 예외처리
        boolean flag = true;
        while(flag) {
            System.out.println("구입금액을 입력해 주세요.");
            flag = lottoMoneyInput();
        }
        System.out.println();

        // 발행한 로또 수량 출력
        int lottoAmount = lottoMoney / 1000;
        System.out.println(lottoAmount + "개를 구매했습니다.");

    }
}
