package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.Message;
import lotto.controller.GameController;

public class Game {

    private final String ERROR_MESSAGE = "[ERROR]";
    private final GameController gameController = new GameController();

    public void run(){

        try{

            purchaseLotto();

        }catch (Exception e){

            System.out.println(ERROR_MESSAGE);
            String errorType = e.getMessage();
            reRunMethod(errorType);
        }
    }

    private void reRunMethod(String errorType){

        if(errorType.contains("MONEY")) {

            purchaseLotto();
        }
    }

    private void purchaseLotto() {

        System.out.println(Message.LOTTO_PURCHASE_MESSAGE.getMessage());
        String input = Console.readLine();

        gameController.purchaseLotto(input);
    }
}
