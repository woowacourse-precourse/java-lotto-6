package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    private final OutputHandler outputHandler;

    public InputHandler(OutputHandler outputHandler) {
        this.outputHandler = outputHandler;
    }

    public int getValidPurchaseAmount() {
        outputHandler.printMessage(MessageForm.ASK_PURCHASE_AMOUNT);
        String userInput = Console.readLine();
        int purchaseAmount = Integer.parseInt(userInput);
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해야 합니다.");
        }
        return purchaseAmount;
    }

}
