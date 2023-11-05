package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Tickets;
import lotto.utils.Validator;

public class LottoManager {
    private Validator valid = new Validator();
    private Tickets tickets = new Tickets();
    private int TICKET_PRICE = 1000;


    public void buyTickets(String string) {
        int money = valid.validateMoney(string);
        int amount = calculateTicketAmount(money);
        tickets.generateTickets(amount);
    }


    public List<String> getTickets() {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < tickets.getTicketsCount(); i++) {
            String ticket = tickets.getTicketOfIndex(i);
            list.add(ticket);
        }

        return list;
    }

    public List<Integer> checkTicketPoints(String winning, String bonus) {
        List<Integer> winningNumber = winningNumbersToIntegerList(winning, bonus);
        List<Integer> points = tickets.getMatchesForAllTickets(winningNumber);

        return points;
    }


    private List<Integer> winningNumbersToIntegerList(String winning, String bonus) {
        List<Integer> numbers = Arrays
                .stream(winning.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int bonusNumber = Integer.parseInt(bonus);
        numbers.add(bonusNumber);

        return numbers;
    }

    private int calculateTicketAmount(int money) {
        int amount = money / TICKET_PRICE;

        return amount;
    }


    // testcode
    protected int getTicketsCount() {
        return tickets.getTicketsCount();
    }

}
