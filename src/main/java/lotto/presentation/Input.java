package lotto.presentation;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    final private String INPUT_PURCHASE_PRICE_COMMAND = "구입금액을 입력해 주세요.";
    final private String INPUT_WINNING_NUMBER_COMMAND = "당첨 번호를 입력해 주세요.";
    final private String INPUT_BONUS_NUMBER_COMMAND = "보너스 번호를 입력해 주세요.";

    public String inputPurchasePrice(){
        System.out.println(INPUT_PURCHASE_PRICE_COMMAND);
        String purchasePrice = readLine();
        return purchasePrice;
    }

    public String[] inputWinningNumber(){
        System.out.println("\n" + INPUT_WINNING_NUMBER_COMMAND);
        String[] winningNumber = readLine().split(",");
        return winningNumber;
    }

    public String inputBonusNumber(){
        System.out.println("\n" + INPUT_BONUS_NUMBER_COMMAND);
        String bonusNumber = readLine();
        return bonusNumber;
    }
}
