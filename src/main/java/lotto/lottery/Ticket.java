package lotto.lottery;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.exception.InputValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ticket {
    private static final int TICKET_PRICE = 1000;
    private static int buyingAmount;

    public Ticket(String buyingAmount) {
        this.buyingAmount = Integer.parseInt(buyingAmount);
        checkBuyingAmount(buyingAmount);
    }

    public List<List<Integer>> getTicketNumbers() {
        List<List<Integer>> ticketNumbers = new ArrayList<>();
        ticketNumbers = createRandomNumbers(buyTicket());
        return ticketNumbers;
    }

    public int getTicketCount() {
        return buyTicket();
    }

    //구입 금액 예외 체크
    private void checkBuyingAmount(String buyingAmount) {
        InputValidator inputValidator = new InputValidator();
        inputValidator.checkBuyingAmount(this.buyingAmount);
        inputValidator.checkInputValue(buyingAmount);
    }

    private int buyTicket() {
        return buyingAmount / TICKET_PRICE;
    }

    private List<List<Integer>> createRandomNumbers(int ticketCount) {
        List<List<Integer>> randomNumbers = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);

            randomNumbers.add(numbers);
        }
        return randomNumbers;
    }
}
