package lotto;

import lotto.Service.GameService;

import javax.imageio.metadata.IIOInvalidTreeException;

public class Controller {

    GameService gameService = new GameService();

    public void run() throws IllegalArgumentException {
        setGame();
    }

    private void setGame() {
        gameService.setGame();;
    }
}
