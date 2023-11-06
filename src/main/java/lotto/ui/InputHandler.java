package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputHandler {

    private final OutputHandler outputHandler;

    public InputHandler(OutputHandler outputHandler) {
        this.outputHandler = outputHandler;
    }

    public int getValidPurchaseAmount() {
        outputHandler.printMessage(OutputForm.ASK_PURCHASE_AMOUNT);
        String userInput = Console.readLine();

        if (!isInteger(userInput)) {
            throw new IllegalArgumentException("[ERROR] 정수만 입력 가능합니다.");
        }

        int purchaseAmount = Integer.parseInt(userInput);
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해야 합니다.");
        }
        return purchaseAmount;
    }

    public boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^-?\\d+$");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public String getWinnerNumbers() {
        outputHandler.printMessage(OutputForm.ASK_WINNER_NUMBERS);
        return Console.readLine();
    }

    public int getBonusNumber() {
        outputHandler.printMessage(OutputForm.ASK_BONUS_NUMBER);
        return Integer.parseInt(Console.readLine());
    }

}
