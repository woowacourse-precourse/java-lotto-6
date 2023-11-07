package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.ExceptionMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {

    private final int tickets;
    private final List<List<Integer>> ticketNumbers;

    public LottoTicket() {
        this.tickets = purchaseTicket();
        this.ticketNumbers = purchaseTicketNumbers();
    }

    private List<List<Integer>> purchaseTicketNumbers() {
        int ticket = purchaseTicket();
        List<List<Integer>> purchaseTicketNumbers = new ArrayList<>();

        for(int i = 0; i < ticket; i++) {
            purchaseTicketNumbers.add(setTicketNumbers());
        }

        return purchaseTicketNumbers;
    }

    private List<Integer> setTicketNumbers () {
        List<Integer> ticketNumbers = new ArrayList<>();

        for(int i = 0; i < 6; i++){
            int number = Randoms.pickNumberInRange(1,45);
            validateDistinction(ticketNumbers, number);
        }

        Collections.sort(ticketNumbers);
        return ticketNumbers;
    }

    private void validateDistinction (List<Integer> ticketNumbers, int randomNumber) {

        if (!ticketNumbers.contains(randomNumber)) {
            ticketNumbers.add(randomNumber);
        }

    }

    private int purchaseTicket() {
        int money = Integer.parseInt(Console.readLine());
        return calculate(money);
    }

    private int calculate(int money) {
        int ticketCost = GameEnvironment.TICKET.getValue();
        calculationValidation(money);
        return money/ticketCost;
    }

    private void calculationValidation(int money) {
        if (money%1000 != 0){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }

    public List<List<Integer>> getTicketNumbers() {
        return ticketNumbers;
    }

    public int getTickets() {
        return tickets;
    }
}