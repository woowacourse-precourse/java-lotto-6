package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void lottoMoneyInput() {
        String userInput = Console.readLine();
        int lottoMoney = Integer.parseInt(userInput);
        if (lottoMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위로 입력해야 합니다.");
        }
    }
    public static void main(String[] args) {
        // 로또 구입 금액 입력받고 예외처리
        while(true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                lottoMoneyInput();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
