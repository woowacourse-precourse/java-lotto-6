package lotto.view.output;

import java.util.List;
import lotto.utils.Templates;

public class DisplayAnnounce extends DisplayView {
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

    public void displayProfitRatio(double profitRatio) {
        initializaCache();
        buildProfitString(profitRatio);
        print();
    }


    private void buildBoughtString(List<String> tickets) {
        int amount = tickets.size();
        String message = String.format(Templates.BOUGHT_MESSAGE.format(amount));
        addToCache(message);
        for (String ticket : tickets) {
            addToCache(ticket);
            addToCache("\n");
        }
    }

    private void buildCountsString(List<Integer> counts) {
        addToCache(Templates.RESULT_MESSAGE);
        String fifthRankMessage = Templates.PRIZING_MESSAGE.format("3개 일치", "5,000", counts.get(4));
        String fourthRankMessage = Templates.PRIZING_MESSAGE.format("4개 일치", "50,000", counts.get(3));
        String thirdRankMessage = Templates.PRIZING_MESSAGE.format("5개 일치", "1,500,000", counts.get(2));
        String secondRankMessage = Templates.PRIZING_MESSAGE.format("5개 일치, 보너스 볼 일치", "30,000,000",
                counts.get(1));
        String firstRankMessage = Templates.PRIZING_MESSAGE.format("6개 일치", "2,000,000,000", counts.get(0));
        addToCache(fifthRankMessage);
        addToCache(fourthRankMessage);
        addToCache(thirdRankMessage);
        addToCache(secondRankMessage);
        addToCache(firstRankMessage);
    }

    private void buildProfitString(double profitRatio) {
        String string = String.format(Templates.PROFIT_RATIO_MESSAGE.format(profitRatio));
        addToCache(string);
    }

}
