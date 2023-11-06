package lotto.view;

import lotto.utils.OutputMessage;

//todo: input, output view 분리 고민
public class GameView {

    public void printInputBudgetMessage(){
        print(OutputMessage.INPUT_BUDGET.getMessage());
    }

    private void print(String message){
        System.out.print(message);
    }
}
