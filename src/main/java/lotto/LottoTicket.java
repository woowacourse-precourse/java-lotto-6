package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {

    private final List<List<Integer>> ticketNumbers;

    public LottoTicket(List<List<Integer>> ticketNumbers) {
        this.ticketNumbers = purchaseTicketNumbers();
    }

    public List<List<Integer>> purchaseTicketNumbers() {
        int ticket = purchaseTicket();
        List<List<Integer>> purchaseTicketNumbers = new ArrayList<>();

        for(int i = 0; i < ticket; i++) {
            purchaseTicketNumbers.add(setTicketNumbers());
        }

        return purchaseTicketNumbers;
    }

    public List<Integer> setTicketNumbers () {
        List<Integer> ticketNumbers = new ArrayList<>();

        for(int i = 0; i < 6; i++){
            int number = Randoms.pickNumberInRange(1,45);
            validateDistinction(ticketNumbers, number);
        }

        Collections.sort(ticketNumbers);
        return ticketNumbers;
    }

    public void validateDistinction (List<Integer> ticketNumbers, int randomNumber) {

        if (!ticketNumbers.contains(randomNumber)) {
            ticketNumbers.add(randomNumber);
        }

    }

    public int purchaseTicket() {
        int money = Integer.parseInt(Console.readLine());
        return calculate(money);
    }

    private int calculate(int money) {
        int ticketCost = 1000;
        calculationValidation(money);
        return money/ticketCost;
    }
//todo: private으로 fix
    public void calculationValidation(int money) {
        if (money%1000 != 0){
            throw new IllegalArgumentException();
        }
    }

    public List<List<Integer>> getTicketNumbers() {
        return ticketNumbers;
    }
}