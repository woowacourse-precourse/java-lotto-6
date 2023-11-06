package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    //로또 구입 금액 입력
    public static String purchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    //당첨 번호 6자리 입력
    public static String winningNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    //보너스 번호 1자리 입력
}
