package lotto.view;

import java.util.List;

public class OutputView {
    StringBuilder cache = new StringBuilder();
    private final String boughtMessage = "\n%d개를 구매했습니다.\n";
    private final String prizingMessage = "\n당첨 통계\n---\n";
    private final String prizingMessageTemplate = "%s (%s원) - %d개\n";


    public void displayBoughtTickets(List<String> tickets) {
        initializaCache();
        buildBoughtString(tickets);
        print();
    }

    public void displayRankCounts(List<Integer> counts) {
        initializaCache();
        buildCountsString(counts);
        print();
    }


    private void buildCountsString(List<Integer> counts) {
        addToCache(prizingMessage);
        String fifthRankMessage = String.format(prizingMessageTemplate, "3개 일치", "5,000", counts.get(4));
        String fourthRankMessage = String.format(prizingMessageTemplate, "4개 일치", "50,000", counts.get(3));
        String thirdRankMessage = String.format(prizingMessageTemplate, "5개 일치", "1,500,000", counts.get(2));
        String secondRankMessage = String.format(prizingMessageTemplate, "5개 일치, 보너스 볼 일치", "30,000,000",
                counts.get(1));
        String firstRankMessage = String.format(prizingMessageTemplate, "6개 일치", "2,000,000,000", counts.get(0));
        addToCache(fifthRankMessage);
        addToCache(fourthRankMessage);
        addToCache(thirdRankMessage);
        addToCache(secondRankMessage);
        addToCache(firstRankMessage);
    }

    private void buildBoughtString(List<String> tickets) {
        int amount = tickets.size();
        String message = String.format(boughtMessage, amount);
        addToCache(message);
        for (String ticket : tickets) {
            addToCache(ticket);
            addToCache("\n");
        }
    }

    private void initializaCache() {
        cache.setLength(0);
    }

    private void addToCache(String string) {
        cache.append(string);
    }

    private void print() {
        System.out.print(cache);
    }

}
