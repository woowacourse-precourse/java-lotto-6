package service;

import camp.nextstep.edu.missionutils.Console;
import util.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    final int TICKET_PRICE = 1000;
    final int MIN_LOTTO_NUMBER = 1;
    final int MAX_LOTTO_NUMBER = 45;
    final int NUMBER_OF_LOTTO_NUMBERS = 6;

    public void start() {
        int ticketPurchaseAmount = getTicketPurchaseAmount();
        int ticketQuantity = ticketPurchaseAmount / TICKET_PRICE;

        List<List<Integer>> tickets = getTickets(ticketQuantity);
    }

    private List<List<Integer>> getTickets(int ticketQuantity) {
        List<List<Integer>> tickets = new ArrayList<>();

        for (int i = 0; i < ticketQuantity; i++) {
            tickets.add(LottoNumberGenerator.generate(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, NUMBER_OF_LOTTO_NUMBERS));
        }

        System.out.println();
        return tickets;
    }

    private static int getTicketPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int ticketPurchaseAmount = Integer.parseInt(Console.readLine());
        validateDivisor(ticketPurchaseAmount);
        return ticketPurchaseAmount;
    }

    public static void validateDivisor(int divisor) {
        if (divisor % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해야 합니다.");
        }
    }
}
