package lotto;

import lotto.Service.GameService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    GameService gameService = new GameService();

    @Test
    public void run() throws IllegalArgumentException {
        setGame();
        resultGame();
    }

    @Test
    public void setGame() {
        gameService.setMoney();;
        gameService.setAnswer();;
        gameService.setBonusNumber();;
    }

    @Test
    private void resultGame() {
        gameService.resultGame();
    }
}