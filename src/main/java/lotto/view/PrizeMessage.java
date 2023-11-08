package lotto.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrizeMessage {
    private List<String> resultOutput;

    public PrizeMessage() {
        this.resultOutput = new ArrayList<>();
    }

    public List<String> makePrizeMessage(HashMap<String,Integer> result){


        Map<Prize, Integer> winnings = new HashMap<>();
        winnings.put(Prize.THREE_MATCH, result.get("Three"));
        winnings.put(Prize.FOUR_MATCH, result.get("Four"));
        winnings.put(Prize.FIVE_MATCH, result.get("Five"));
        winnings.put(Prize.FIVE_MATCH_WITH_BONUS, result.get("Five_WITH_BONUS"));
        winnings.put(Prize.SIX_MATCH,result.get("Six"));


        for (Prize prize : Prize.values()) {
            int numberOfWinners;
            try {
                numberOfWinners = winnings.getOrDefault(prize, 0);
            }
            catch (NullPointerException e) {
                numberOfWinners = 0;
            }
           resultOutput.add(prize.generatePrizeString(numberOfWinners));
        }
        return resultOutput;
    }




}
