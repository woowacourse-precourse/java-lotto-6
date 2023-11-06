package lotto.input;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.output.MessageType.INPUT_ERROR;

import lotto.ApplicationContext;
import lotto.controller.LottoController;
import lotto.exception.InputException;
import lotto.input.convert.ConverToInt;
import lotto.output.MessageType;
import lotto.output.OutputMessage;

public class LottoBuyer {
    private LottoController lottoController = ApplicationContext.getController();

    public void gernerateTicket(){
        OutputMessage.print(MessageType.INPUT_BUY_START);
        try{
            ConverToInt converToInt = ConverToInt.from(readLine());
            int wallet = converToInt.getValue();

            lottoController.gernerateTicket(wallet);
        }catch (InputException ie){
            OutputMessage.printf(INPUT_ERROR,ie.getMessage());

            gernerateTicket();
        }
    }

    public void printWinRecord(){
        lottoController.printWinRecord();
    }

    public void printReturns(){
        lottoController.printReturns();
    }

}
