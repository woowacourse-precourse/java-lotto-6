package lotto.model;

import lotto.util.Rank;

import java.util.HashMap;
import java.util.Map;

public class Winning {
    private static Map<String, Integer> winningTicket = new HashMap<>();

    public Winning() {
        winningTicket.put(Rank.First.name(),0);
        winningTicket.put(Rank.Second.name(), 0);
        winningTicket.put(Rank.Third.name(), 0);
        winningTicket.put(Rank.Fourth.name(), 0);
        winningTicket.put(Rank.Fifth.name(), 0);
        winningTicket.put(Rank.Miss.name(), 0);
    }

    public void setWinningTickets(int matchCount, boolean isSecond) {

        if (matchCount == Rank.First.getMatchCount()) {
            winningTicket.put(Rank.First.name(), winningTicket.get(Rank.First.name()) + 1);
        } else if (matchCount == Rank.Second.getMatchCount() && isSecond) {
            winningTicket.put(Rank.Second.name(), winningTicket.get(Rank.Second.name()) + 1);
        } else if (matchCount == Rank.Third.getMatchCount() && !isSecond) {
            winningTicket.put(Rank.Third.name(), winningTicket.get(Rank.Third.name()) + 1);
        } else if (matchCount == Rank.Fourth.getMatchCount()) {
            winningTicket.put(Rank.Fourth.name(), winningTicket.get(Rank.Fourth.name()) + 1);
        } else if (matchCount == Rank.Fifth.getMatchCount()) {
            winningTicket.put(Rank.Fifth.name(), winningTicket.get(Rank.Fifth.name()) + 1);
        } else if (matchCount < 3) {
            winningTicket.put(Rank.Miss.name(), 0);
        }
    }

    public void lottoResult() {
        System.out.println("당첨 통계 \n---");
        System.out.println(Rank.Fifth.getResultMessage() + winningTicket.get(Rank.Fifth.name()) + "개");
        System.out.println(Rank.Fourth.getResultMessage() + winningTicket.get(Rank.Fourth.name()) + "개");
        System.out.println(Rank.Third.getResultMessage() + winningTicket.get(Rank.Third.name()) + "개");
        System.out.println(Rank.Second.getResultMessage() + winningTicket.get(Rank.Second.name()) + "개");
        System.out.println(Rank.First.getResultMessage() + winningTicket.get(Rank.First.name()) + "개");
    }

    public long calculateProfit() {
        long profit = 0;
        for (String name : winningTicket.keySet()) {
            int count = winningTicket.get(name);
            profit += (long) Rank.valueOf(name).getPrize() * count;
        }

        return profit;
    }

    public void calculateProfitRate(int tickets) {
        int money = tickets * 1000;
        long profit = calculateProfit();

        double rate = (profit / (double) money) * 100;

        String profitRate = String.format("%.1f", rate);

        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }



}
