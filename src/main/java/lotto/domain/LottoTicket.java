package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoTicket {
    private final List<Lotto> tickets;

    public LottoTicket(List<Lotto> tickets) {
        this.tickets = tickets;
    }

    public void printTickets() {
        for (Lotto lotto : tickets) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static LottoTicket purchase(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("로또 한 장은 1,000원입니다.");
        }

        int numberOfTickets = amount / 1000;
        List<Lotto> tickets = new ArrayList<>();

        for (int i = 0; i < numberOfTickets; i++) {
            tickets.add(Lotto.generateRandomLotto());
        }

        return new LottoTicket(tickets);
    }

    public void calculateAndPrintResult(WinningNumbers winningNumbers, int bonusNumber) {
        Map<Rank, Integer> result = new HashMap<>();

        for (Lotto lotto : tickets) {
            Rank rank = winningNumbers.calculateRank(lotto, bonusNumber);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }

        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            int count = result.getOrDefault(rank, 0);
            rank.printResult(count);
        }

        double profitRate = winningNumbers.calculateProfitRate(result);
        System.out.printf("총 수익률은 %.1f%% 입니다.%n", profitRate);
    }

}
