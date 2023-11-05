package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static int inputPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();
        return Integer.parseInt(purchaseAmount);
    }

    public static String[] inputLottoNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String lottoNumber = Console.readLine();
        return lottoNumber.split(",");
    }

    public static String inputBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }
}
