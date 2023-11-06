package lotto.view;

import lotto.utils.OutputMessage;

//todo: input, output view 분리 고민
public class GameView {

    public void printInputBudgetMessage(){
        print(OutputMessage.INPUT_BUDGET.getMessage());
    }

    public void printLottosSize(int lottosSize){
        print(String.format(OutputMessage.OUTPUT_LOTTOS_SIZE.getMessage(), lottosSize));
    }

    public void printLottosNumbers(String lottosNumbers){
        print(lottosNumbers);
    }

    private void print(String message){
        System.out.print(message);
    }
}
