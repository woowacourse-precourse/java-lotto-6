package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static String customerWalletInput() {

        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static String winNumberInput() {

        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static String bonusNumberInput() {

        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static void buyLottosInput(int wallet) {

        wallet /= 1000;
        System.out.println(wallet + "개를 구매했습니다.");
    }
}
