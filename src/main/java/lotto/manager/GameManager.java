package lotto.manager;

import lotto.Lotto;
import lotto.lottery.Bonus;
import lotto.lottery.Ticket;
import lotto.lottery.Winning;

import java.util.List;
import java.util.Map;

public class GameManager {

    public void game() {
        OutputManager outputManager = new OutputManager();
        InputManager inputManager = new InputManager();

        //구입 금액
        String buyingAmount = getBuyingAmount(inputManager, outputManager);
        List<List<Integer>> ticketNumbers = buyTicket(buyingAmount, outputManager);

        Winning winning = getWinningNumbers(inputManager, outputManager);
        List<Integer> winningNumbers = winning.getWinningNumbers();

        Bonus bonus = getBonusNumber(inputManager, outputManager);

        Lotto lotto = new Lotto(winningNumbers);

        Map<Integer, Integer> winningStatistics = lotto.winningStatistics(ticketNumbers);
        outputManager.printWinningMessage(winningStatistics);
    }

    private String getBuyingAmount(InputManager inputManager, OutputManager outputManager) {
        outputManager.printInputAmount();
        return inputManager.getUserInput();
    }

    private List<List<Integer>> buyTicket(String buyingAmount, OutputManager outputManager) {
        Ticket ticket = new Ticket(buyingAmount);
        int ticketCount = ticket.getTicketCount();
        outputManager.printTicketCount(ticketCount);
        List<List<Integer>> ticketNumbers = ticket.getTicketNumbers();
        outputManager.printRandomNumber(ticketNumbers);
        return ticketNumbers;
    }

    private Winning getWinningNumbers(InputManager inputManager, OutputManager outputManager) {
        outputManager.printWinningNumbers();
        String inputWinningNumbers = inputManager.getUserInput();
        return new Winning(inputWinningNumbers);
    }

    private Bonus getBonusNumber(InputManager inputManager, OutputManager outputManager) {
        outputManager.printBonusNumber();
        String bonusNumber = inputManager.getUserInput();
        return new Bonus(bonusNumber);
    }

}
