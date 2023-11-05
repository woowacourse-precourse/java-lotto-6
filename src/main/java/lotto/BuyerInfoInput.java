package lotto;

import camp.nextstep.edu.missionutils.Console;

public class BuyerInfoInput {
    public String inputLottoPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public String[] inputWinningNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return input.split(",");
    }

    public String inputBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

}
