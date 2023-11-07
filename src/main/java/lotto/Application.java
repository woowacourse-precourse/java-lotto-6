package lotto;

import java.util.List;

import lotto.Control.GameProcess;
//import lotto.Control.InputPurchaseAmount;
import lotto.Control.PressEnter;
import lotto.DTO.SystemMessageDTO;
import lotto.Model.MakeAutoTicket;
import lotto.View.CallSystemMessage;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // MakeAutoTicket test = new MakeAutoTicket();
        // List<Integer> numbers = test.getnumbers();
        // System.out.println(numbers);

        // PressEnter lottosystem = new PressEnter();
        // lottosystem.plzPressEnter();
        // String res = lottosystem.getInput();
        // System.out.println(res);



        // CallSystemMessage callmessage = new CallSystemMessage();
        // callmessage.printMessage(SystemMessageDTO.INPUT_PURCHASE_AMOUNT);

        // lottosystem.plzPressEnter();
        // res = lottosystem.getInput();

        GameProcess game = new GameProcess();

    }
}
