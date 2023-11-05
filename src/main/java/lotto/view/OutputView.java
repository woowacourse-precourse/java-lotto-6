package lotto.view;

import lotto.view.constant.OutputConstant;
import lotto.view.message.OutputMessage;

public class OutputView {
    public void askUserToInsertMoneyToBuyLotto(){
        printMessage(OutputMessage.ASK_TO_INSERT_MONEY_FOR_LOTTO.getMessage() + OutputConstant.newLine);
    }

    public void askUserToInsertLottoWinningNumbers(){
        printMessage(OutputMessage.ASK_TO_INSERT_LOTTO_WINNING_NUMBERS.getMessage() + OutputConstant.newLine);
    }

    private void printMessage(String message){
        System.out.print(message);
    }
}