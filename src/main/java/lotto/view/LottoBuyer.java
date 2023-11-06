package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.config.output.MessageType.INPUT_ERROR;

import lotto.config.AppConfig;
import lotto.config.exception.InputException;
import lotto.config.output.MessageType;
import lotto.config.output.OutputMessage;
import lotto.controller.LottoController;
import lotto.view.convert.ConvertToInt;

public class LottoBuyer {
    private LottoController lottoController = AppConfig.getController();

    public void gernerateTicket(){
        OutputMessage.print(MessageType.INPUT_BUY_START);
        try{
            ConvertToInt converToInt = ConvertToInt.from(readLine());
            int wallet = converToInt.getValue();

            lottoController.gernerateTicket(wallet);
        }catch (InputException ie){
            OutputMessage.printf(INPUT_ERROR,ie.getMessage());

            gernerateTicket();
        }
    }

    public void printWinRecord(){
        OutputMessage.print(MessageType.OUTPUT_MATCH_STATICS);
        lottoController.printWinRecord();
    }

    public void printReturns(){
        lottoController.printReturns();
    }

}
