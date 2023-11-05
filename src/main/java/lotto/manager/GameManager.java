package lotto.manager;

import lotto.Lotto;
import lotto.lottery.Bonus;
import lotto.lottery.Ticket;
import lotto.lottery.Winning;

import java.util.List;

public class GameManager {

    public void game() {
        OutputManager outputManager = new OutputManager();
        InputManager inputManager = new InputManager();

        String buyingAmount = getBuyingAmount(inputManager, outputManager);
        Ticket ticket = buyTicket(buyingAmount, outputManager);
        List<List<Integer>> ticketNumbers = ticket.getTicketNumbers();

        Winning winning = getWinningNumbers(inputManager, outputManager);
        Bonus bonus = getBonusNumber(inputManager, outputManager);

        List<Integer> winningNumbers = winning.getWinningNumbers();
        Lotto lotto = new Lotto(winningNumbers);

    }

    private String getBuyingAmount(InputManager inputManager, OutputManager outputManager){
        outputManager.printInputAmount();
        return inputManager.getUserInput();
    }

    private Ticket buyTicket(String buyingAmount, OutputManager outputManager){
        Ticket ticket = new Ticket(buyingAmount);
        int ticketCount = ticket.getTicketCount();
        outputManager.printTicketCount(ticketCount);
        outputManager.printRandomNumber(ticket.getTicketNumbers());
        return ticket;
    }

    private Winning getWinningNumbers(InputManager inputManager, OutputManager outputManager){
        outputManager.printWinningNumbers();
        String inputWinningNumbers = inputManager.getUserInput();
        return new Winning(inputWinningNumbers);
    }

    private Bonus getBonusNumber(InputManager inputManager, OutputManager outputManager){
        outputManager.printBonusNumber();
        String bonusNumber = inputManager.getUserInput();
        return new Bonus(bonusNumber);
    }
}
