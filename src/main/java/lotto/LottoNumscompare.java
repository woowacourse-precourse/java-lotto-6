package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoNumscompare {
    private final Map<Integer, Integer> userWinningRanks = new HashMap<>(){{
        put(1, 0);
        put(2, 0);
        put(3, 0);
        put(4, 0);
        put(5, 0);
    }};

    private enum Rank{
        FIRST_PLACE("2000000000"),
        SECOND_PLACE("30000000"),
        THIRD_PLACE("1500000"),
        FOURTH_PLACE("50000"),
        FIFTH_PLACE("5000");

        final private String winningAmount;
        public Long getWinningAmount() {
            return Long.parseLong(winningAmount);
        }
        Rank(String winningAmount){
            this.winningAmount = winningAmount;
        }
    }

    public Map<Integer, Integer> getUserWinningRanks(){
        return new HashMap<Integer, Integer>(userWinningRanks);
    }

    public int compareLotto(List<Integer> userNums, List<Integer> winningNums){
        int sameNum = 0, userNumIndex = 0, winningNumIndex = 0;
        while(userNumIndex<6&&winningNumIndex<6){
            if(userNums.get(userNumIndex).equals(winningNums.get(winningNumIndex))){
                sameNum++;
                winningNumIndex++;
                userNumIndex++;
                continue;
            }
            if(userNums.get(userNumIndex)>winningNums.get(winningNumIndex)){
                winningNumIndex++;
                continue;
            }
            if(userNums.get(userNumIndex)<winningNums.get(winningNumIndex)){
                userNumIndex++;
            }
        }
        return sameNum;
    }
    public void winningRanksUpdate(List<Integer> userNums, int sameNum, int bounsNum){
        if(sameNum == 6){
            userWinningRanks.put(7-sameNum, userWinningRanks.get(7-sameNum)+1);
            return;
        }
        if(sameNum == 5){
            if(userNums.contains(bounsNum)){
                userWinningRanks.put(7-sameNum, userWinningRanks.get(7-sameNum)+1);
                return;
            }
        }
        if(sameNum < 6 && sameNum>2){
            userWinningRanks.put(8-sameNum, userWinningRanks.get(8-sameNum)+1);
        }
    }

    public double calculateProfitSummary(int lottoPurchaseNum){
        double winningAmount = Rank.FIRST_PLACE.getWinningAmount()*userWinningRanks.get(1)
                +Rank.SECOND_PLACE.getWinningAmount()*userWinningRanks.get(2)
                +Rank.THIRD_PLACE.getWinningAmount()*userWinningRanks.get(3)
                +Rank.FOURTH_PLACE.getWinningAmount()*userWinningRanks.get(4)
                +Rank.FIFTH_PLACE.getWinningAmount()*userWinningRanks.get(5);
        return Math.round(winningAmount/(lottoPurchaseNum*1000)*100*10)/10.0;
    }
}
