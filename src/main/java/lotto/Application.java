package lotto;

import java.awt.print.PrinterGraphics;
import lotto.domain.InputAmount;
import lotto.view.PrintView;

public class Application {
    private static InputAmount inputAmount;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        start_Lotto();
    }
    public static void start_Lotto(){
        int Buy_Ticket = Input_Lotto_Buy();
        PrintView.Output_Lotto_Buy(Buy_Ticket);
        Lottery_Ticket(Buy_Ticket);
    }
    public static int Input_Lotto_Buy(){
        inputAmount = new InputAmount(PrintView.Input_Lotto_Buy());
        return inputAmount.Used_Lotto();
    }
    public static void Lottery_Ticket(int Buy_Ticket){

    }

}
