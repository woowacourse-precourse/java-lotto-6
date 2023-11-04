package lotto.game;

import camp.nextstep.edu.missionutils.Console;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.domain.Ticket;
import lotto.type.ErrorCode;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.stream;


public class Game {

    public void play() {
        int totalTicketCount;
        try {
            totalTicketCount = buyTicket();
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorCode.INVALID_MONEY_TO_BUY.getDescription());
            totalTicketCount = buyTicket();
        }

        showTickets(totalTicketCount);

        pickLuckyNumbers();

    }

    private void pickLuckyNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<String> numberInput = stream(Console.readLine().split(",")).toList();
        validateLuckyNumbers(numberInput);
        List<Integer> luckyNumbers = new ArrayList<>();
        for (String num : numberInput) {
            luckyNumbers.add(Integer.parseInt(num));
        }
    }

    void validateLuckyNumbers(List<String> numberInput) {
        if (numberInput.size() != 6 || numberInput.size() != numberInput.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorCode.INVALID_LUCKY_NUMBERS.getDescription());
        }
    }

    private int buyTicket() {
        System.out.println("구입금액을 입력해 주세요.");
        int moneyInput = Integer.parseInt(Console.readLine());
        Ticket ticket = new Ticket();
        ticket.setCount(moneyInput);
        return ticket.getCount();
    }

    private void showTickets(int totalTicketCount) {
        System.out.println(totalTicketCount + "개를 구매했습니다.");
        List<Lotto> tickets = getTickets(totalTicketCount);
        for (Lotto lotto : tickets) {
            System.out.println(lotto.getNumbers());
        }
    }
    List<Lotto> getTickets(int totalTicketCount) {
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < totalTicketCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            tickets.add(new Lotto(numbers));
        }
        return tickets;
    }

}
