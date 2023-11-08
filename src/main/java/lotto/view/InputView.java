package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String requestPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        System.out.println(input);
        System.out.println();
        return input;
    }

    public static String requestLotteryNumber(){
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        System.out.println(input);
        System.out.println();
        return input;
    }

    public static String requestBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        System.out.println(input);
        return input;
    }
}