package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    static String inputPurchaseAmount() {
        return Console.readLine();
    }
    
    String inputWinningNumbers() {
        return Console.readLine();
    }
    
    String inputBonusNumber() {
        return Console.readLine();
    }
}
