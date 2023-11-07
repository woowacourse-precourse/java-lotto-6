package service;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import util.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static util.Validator.validateTicketPurchaseAmount;

public class LottoGame {
    static final int TICKET_PRICE = 1000;
    static final int MIN_LOTTO_NUMBER = 1;
    static final int MAX_LOTTO_NUMBER = 45;
    static final int NUMBER_OF_LOTTO_NUMBERS = 6;

    public void start() {
        int ticketPurchaseAmount = getTicketPurchaseAmount();
        int ticketQuantity = ticketPurchaseAmount / TICKET_PRICE;
        List<List<Integer>> tickets = getTickets(ticketQuantity);

        printGeneratedLottoNumbers(ticketQuantity, tickets);
        getWinningNumbers();
    }

    private static void getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");

        List<Integer> winningNumbers = Arrays.stream(Console.readLine().split(",")).map(Integer::parseInt).toList();
        Lotto winningTicket = new Lotto(winningNumbers, MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, NUMBER_OF_LOTTO_NUMBERS);
    }

    private static void printGeneratedLottoNumbers(int ticketQuantity, List<List<Integer>> tickets) {
        System.out.println(ticketQuantity + "개를 구매했습니다.");

        for (List<Integer> ticket : tickets) {
            System.out.println(ticket);
        }

        System.out.println();
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
        String input = Console.readLine();
        validateTicketPurchaseAmount(input);

        return Integer.parseInt(input);
    }
}
