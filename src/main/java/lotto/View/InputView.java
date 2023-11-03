package lotto.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputLottoPurchaseAmount(){
        System.out.println("구입금액을 입력해주세요.");
        return Console.readLine();
    }
}
