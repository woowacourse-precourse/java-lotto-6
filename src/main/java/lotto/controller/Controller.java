package lotto.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.domain.Client;
import lotto.domain.Game;
import lotto.domain.Lotto;
import lotto.service.Service;
import lotto.validation.Validation;
import lotto.view.InputMessage;
import lotto.view.OutputMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {
    private static final int PERCHASE_AMOUNT_MINUMUN_UNIT = 1_000;
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
        game = new Game(getInputWinningNumbers(),getInputBonusNumber());
    }


    private List<Integer> getInputWinningNumbers() {
        InputMessage.inputWinningNumbers();
        return stringToIntegerList(readLine().trim());
    }

    private int getInputBonusNumber() {
        InputMessage.inputBonusNumber();
        return stringToInteger(readLine().trim());
    }

    private void showResult(){
        service.checkResult(client,game);
        OutputMessage.winningStatics();
        OutputMessage.printPrizeResults(client.getResult());
        OutputMessage.printEarningRate(client.getEarningRate());
    }

    private int getInputAmount() {
        InputMessage.inputAmount();
        String userInput = readLine().trim();
        return stringToInteger(userInput);
    }

    private int stringToInteger(String string) {
        Validation.validateStringIsInteger(string);
        return Integer.parseInt(string);
    }

    private int[] stringToIntArray(String string) {
        return Arrays.stream(string.split(",")).mapToInt(Integer::parseInt).toArray();
    }

    private List<Integer> stringToIntegerList(String string){
        Validation.validateListStringToInteger(Arrays.asList(string.split(",")));
        return Arrays.stream(stringToIntArray(string)).boxed().collect(Collectors.toList());
    }
}
