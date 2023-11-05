package lotto.view.output;

import java.util.List;
import lotto.utils.Templates;

public class DisplayAnnounce extends DisplayView {
    // Features
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


    // Internal Implements
    private void buildBoughtString(List<String> tickets) {
        int amount = tickets.size();
        String message = Templates.BOUGHT_MESSAGE.format(amount);
        addToCache(message);
        for (String ticket : tickets) {
            addToCache(ticket);
            addToCache("\n");
        }
    }

    private void buildCountsString(List<Integer> counts) {
        String[][] stringsList = new String[][]{
                {"3개 일치", "5,000", counts.get(4).toString()},
                {"4개 일치", "50,000", counts.get(3).toString()},
                {"5개 일치", "1,500,000", counts.get(2).toString()},
                {"5개 일치, 보너스 볼 일치", "30,000,000", counts.get(1).toString()},
                {"6개 일치", "2,000,000,000", counts.get(0).toString()}
        };

        addToCache(Templates.RESULT_MESSAGE);
        for (String[] strings : stringsList) {
            String message = Templates.PRIZING_MESSAGE.format(strings[0], strings[1], strings[2]);
            addToCache(message);
        }
    }

    private void buildProfitString(double profitRatio) {
        String string = Templates.PROFIT_RATIO_MESSAGE.format(profitRatio);
        addToCache(string);
    }

}
