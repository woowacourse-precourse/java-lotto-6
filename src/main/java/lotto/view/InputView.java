package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public String inputPurchaseAmount(){
        OutputView.requestInputAmountMessage();
        String userInput = readLine();
        return userInput;
    }

    public String inputWinningNumbers(){
        OutputView.requestInputWinningNumbersMessage();
        String userInput = readLine();
        return userInput;
    }

    public String inputBonusNumber(){
        OutputView.requestInputBonusNumberMessage();
        String userInput = readLine();
        return userInput;
    }


}
