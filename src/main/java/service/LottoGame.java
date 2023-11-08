package service;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.LottoRank;
import util.LottoNumberGenerator;

import java.util.*;

import static util.TicketPurchaseAmountValidator.validateTicketPurchaseAmount;

public class LottoGame {
    static final int TICKET_PRICE = 1000;
    static final int MIN_LOTTO_NUMBER = 1;
    static final int MAX_LOTTO_NUMBER = 45;
    static final int NUMBER_OF_LOTTO_NUMBERS = 6;
    static final int NUMBER_OF_LOTTO_BONUS_NUMBER = 1;

    public void start() {
        int ticketPurchaseAmount = getTicketPurchaseAmount();
        int ticketQuantity = ticketPurchaseAmount / TICKET_PRICE;
        List<Lotto> tickets = getTickets(ticketQuantity);

        printGeneratedNumbers(ticketQuantity, tickets);

        Lotto winningNumbers = getWinningNumbers();
        Lotto bonusNumber = getBonusNumber();
    }

    private static void getBonusNumber() {

    private Lotto getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");

        List<Integer> bonusNumber = new ArrayList<>();

        try {
            bonusNumber = Arrays.asList(Integer.parseInt(Console.readLine()));
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 숫자를 입력해 주세요.");
        }

        System.out.println();
        return new Lotto(bonusNumber, MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, NUMBER_OF_LOTTO_BONUS_NUMBER);
    }


    private Lotto getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = Arrays.stream(Console.readLine().split(",")).map(Integer::parseInt).toList();
        System.out.println();

        return new Lotto(winningNumbers, MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, NUMBER_OF_LOTTO_NUMBERS);
    }

    private void printGeneratedNumbers(int ticketQuantity, List<Lotto> tickets) {
        System.out.println(ticketQuantity + "개를 구매했습니다.");

        for (Lotto ticket : tickets) {
            System.out.println(ticket.getNumbers());
        }

        System.out.println();
    }

    private List<Lotto> getTickets(int ticketQuantity) {
        List<Lotto> tickets = new ArrayList<>();

        for (int i = 0; i < ticketQuantity; i++) {
            Lotto ticket = new Lotto(LottoNumberGenerator.generate(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, NUMBER_OF_LOTTO_NUMBERS), MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, NUMBER_OF_LOTTO_NUMBERS);
            tickets.add(ticket);
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
