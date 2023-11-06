package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.Message;
import lotto.controller.GameController;

public class Game {
    private final GameController gameController = new GameController();

    public void run(){

        try{

            purchaseLotto();
            saveWinningNumbers();
            saveBonusNumbers();

        }catch (Exception e){

            String errorType = e.getMessage();
            System.out.println(Message.valueOf(errorType).getMessage());

            reRun(errorType);
        }
    }

    private void reRun(String errorType){

        if(errorType.contains("MONEY")) {

            purchaseLotto();
        }

        if(errorType.contains("WINNING")) {

            saveWinningNumbers();
        }

        if(errorType.contains("BONUS")) {

            saveBonusNumbers();
        }
    }

    private void purchaseLotto() {

        System.out.println(Message.LOTTO_PURCHASE_MESSAGE.getMessage());
        String input = Console.readLine();

        gameController.purchaseLotto(input);
    }

    private void saveWinningNumbers() {

        System.out.println(Message.WINNING_NUMBER_MESSAGE.getMessage());
        String input = Console.readLine();

        gameController.saveWinningNumbers(input);
    }

    private void saveBonusNumbers() {

        System.out.println(Message.BONUS_NUMBER_MESSAGE.getMessage());
        String input = Console.readLine();

        gameController.saveBonusNumber(input);
    }
}
