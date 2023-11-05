package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private final OutputView outputView = new OutputView();

    public String inputPurchaseAmount(){
        outputView.requestInputAmountMessage();
        String userInput = readLine().trim();
        return userInput;
    }

    public String inputWinningNumbers(){
        outputView.requestInputWinningNumbersMessage();
        String userInput = readLine().trim();
        return userInput;
    }

    public String inputBonusNumber(){
        outputView.requestInputBonusNumberMessage();
        String userInput = readLine().trim();
        return userInput;
    }


}
