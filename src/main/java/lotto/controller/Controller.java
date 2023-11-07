package lotto.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.domain.Client;
import lotto.domain.Game;
import lotto.domain.Lotto;
import lotto.service.Service;
import lotto.validation.Validation;
import lotto.view.InputMessage;
import lotto.view.OutputMessage;

public class Controller {
    private static final int PERCHASE_AMOUNT_MINUMUN_UNIT = 1000;
    private Client client;
    private Game game;
    private final Service service = new Service();

    public void run(){
        prepareGame();
        startGame();
        showResult();
    }

    private void prepareGame(){
        client = new Client(getInputAmount());
        service.buyLotto(client);
        showPurchaseResult();
    }

    private void showPurchaseResult() {
        OutputMessage.purchaseComplete(client.getPurchaseAmount()/PERCHASE_AMOUNT_MINUMUN_UNIT);
        for(Lotto lotto : client.getClientLottoList()){
            OutputMessage.lottoNumbers(lotto.getNumbers());
        }
    }

    private void startGame(){
        //game = new Game();
    }

    private void showResult(){

    }

    private int getInputAmount() {
        InputMessage.inputAmount();
        String userInput = readLine().trim();
        return stringToInteger(userInput);
    }

    public static int stringToInteger(String string) {
        Validation.validateStringIsInteger(string);
        return Integer.parseInt(string);
    }
}
