package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.awt.print.PrinterGraphics;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.InputAmount;
import lotto.domain.LotteryTicket;
import lotto.domain.Lotto;
import lotto.domain.refinedWinning;
import lotto.view.PrintView;

public class Application {
    private static InputAmount inputAmount;
    private static Lotto lotto;
    private static List<Integer> printlotto = new ArrayList<>();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        start_Lotto();
    }
    public static void start_Lotto(){
        int Buy_Ticket = Input_Lotto_Buy();
        PrintView.Output_Lotto_Buy(Buy_Ticket);
        Print_Lotto(Buy_Ticket);
        Input_winning_num();
    }
    public static int Input_Lotto_Buy(){
        inputAmount = new InputAmount(PrintView.Input_Lotto_Buy());
        return inputAmount.Used_Lotto();
    }
    public static void Print_Lotto(int Buy_Ticket) {
        LotteryTicket lotteryticket = new LotteryTicket();
        printlotto = new ArrayList<>();
        for (int i = 0; i < Buy_Ticket; i++) {
            printlotto = lotteryticket.RandomLottoNum();
            System.out.println(printlotto);
        }
    }

    public static void Input_winning_num(){
       String Input_winning = PrintView.Input_Winning_Number();
       refinedWinning.Input_Winning(Input_winning);
    }

    public static void Guessing_lotto(){
        lotto = new Lotto(refinedWinning.change_winning());

    }

}
