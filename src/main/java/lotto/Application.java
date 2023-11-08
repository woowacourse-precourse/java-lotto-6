package lotto;

import lotto.Service.GameService;

public class Application {
    public static void main(String[] args) {
        GameService gameService = new GameService();

        gameService.setMoney();
        gameService.setAnswer();
        gameService.setBonusNumber();
        gameService.resultGame();
    }
}
