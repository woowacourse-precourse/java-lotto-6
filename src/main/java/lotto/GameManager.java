package lotto;

import java.util.List;

public class GameManager {
    public void game(){
        OutputManager outputManager = new OutputManager();
        InputManager inputManager = new InputManager();
        outputManager.printInputAmount();
        String input = inputManager.getUserInput();
        List<Integer> winningNumbers = inputManager.splitAndConvertToList(input);
    }
}
