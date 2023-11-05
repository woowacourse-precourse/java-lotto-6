package lotto;

import java.util.Collections;
import java.util.List;

public class GameManager {
    private static final int TICKET_PRICE = 1000;
    public void game() {
        OutputManager outputManager = new OutputManager();
        InputManager inputManager = new InputManager();
        InputValidator inputValidator = new InputValidator();

        outputManager.printInputAmount();
        String inputBuyingAmount = inputManager.getUserInput();
        int buyingAmount = Integer.parseInt(inputBuyingAmount);
        //buyingAmount 예외 체크
        inputValidator.checkBuyingAmount(buyingAmount);
        inputValidator.checkInputValue(inputBuyingAmount);

        int ticketCount = buyTicket(buyingAmount);
        outputManager.printTicketCount(ticketCount);

        String input = inputManager.getUserInput();
        List<Integer> winningNumbers = inputManager.splitAndConvertToList(input);
        Collections.sort(winningNumbers);
        Lotto lotto = new Lotto(winningNumbers);
    }

    private int buyTicket(int buyingAmount){
        return buyingAmount / TICKET_PRICE;
    }
}
