package lotto.manager;

import lotto.Lotto;
import lotto.ProfitCalculator;
import lotto.lottery.Bonus;
import lotto.lottery.BuyingAmount;
import lotto.lottery.Ticket;
import lotto.lottery.Winning;

import java.util.List;
import java.util.Map;

public class GameManager {

    public void game() {
        OutputManager outputManager = new OutputManager();
        InputManager inputManager = new InputManager();
        ProfitCalculator profitCalculator = new ProfitCalculator();

        //구입 금액
        String buyingAmount = getBuyingAmount(inputManager, outputManager);
        List<List<Integer>> ticketNumbers = buyTicket(buyingAmount, outputManager);
        //당첨 번호
        Winning winning = getWinningNumbers(inputManager, outputManager);
        List<Integer> winningNumbers = winning.getWinningNumbers();

        Bonus bonus = getBonusNumber(inputManager, outputManager, winningNumbers);

        Lotto lotto = new Lotto(winningNumbers);
        Map<Integer, Integer> winningStatistics = lotto.winningStatistics(ticketNumbers, bonus.getBonus());
        outputManager.printWinningMessage(winningStatistics);

        double profitRate = profitCalculator.calculateProfitRate(winningStatistics, buyingAmount);
        outputManager.printProfitRate(profitRate);
    }

    private String getBuyingAmount(InputManager inputManager, OutputManager outputManager) {
        outputManager.printInputAmount();
        while (true) {
            try {
                String buyingAmountInput = inputManager.getUserInput();
                BuyingAmount buyingAmount = new BuyingAmount(buyingAmountInput);
                return buyingAmountInput;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
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
        while (true) {
            try {
                String inputWinningNumbers = inputManager.getUserInput();
                Winning winning = new Winning(inputWinningNumbers);
                return winning;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Bonus getBonusNumber(InputManager inputManager, OutputManager outputManager, List<Integer> winningNumbers) {
        outputManager.printBonusNumber();
        while (true) {
            try {
                String bonusNumber = inputManager.getUserInput();
                Bonus bonus = new Bonus(bonusNumber, winningNumbers);
                return bonus;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
