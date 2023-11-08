package lotto;

public class Game {
    public void run() {
        Purchase purchase = new Purchase(Input.inputPurchaseAmount());
        int ticketQuantity = purchase.getQuantity();
        printTickets(ticketQuantity);
    }

    private void printTickets(int ticketQuantity) {
        Tickets tickets = new Tickets(ticketQuantity);
        Output.printTicketQuantity(ticketQuantity);
        Output.printTickets(tickets);
        inputLotto(tickets, ticketQuantity);
    }

    private void inputLotto(Tickets tickets, int ticketQuantity) {
        Numbers numbers = new Numbers(Input.inputLottoNumber());
        Number number = new Number(Input.inputBonusNumber());
        Lotto lotto = new Lotto(numbers.getNumbers());
        Bonus bonus = new Bonus(number.getNumber(), lotto);
        printWinningResult(new Winning(tickets, lotto, bonus), ticketQuantity);
    }

    private void printWinningResult(Winning winning, int ticketQuantity) {
        Output.printWinningResult(winning);
        printRateOfProfit(winning, ticketQuantity);
    }

    private void printRateOfProfit(Winning winning, int ticketQuantity) {
        Profit profit = new Profit(winning.getWinningResult(),ticketQuantity);
        Output.printRateOfProfit(profit);
    }
}
