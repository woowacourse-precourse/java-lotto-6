package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 1. 구입 금액 입력
        System.out.println("구입금액을 입력해 주세요.");
        int price = 0;
        boolean validInput = false;
        while(!validInput) {
            String input = Console.readLine();
            try {
                price = Integer.parseInt(input);
                if(price % 1000 != 0) {
                    System.out.println("[ERROR] 구입금액은 1,000원 단위로 입력해야 합니다.");
                    continue;
                }
                validInput = true;
            }
            catch (NumberFormatException e) {
                System.out.println("[ERROR] 구입금액은 숫자를 입력하여야 합니다.");
            }
        }
    }
}
