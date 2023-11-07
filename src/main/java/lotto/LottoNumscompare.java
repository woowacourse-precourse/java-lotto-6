package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoNumscompare {
    private Map<Integer, Integer> userWinningRanks = new HashMap<>(){{
        put(1, 0);
        put(2, 0);
        put(3, 0);
        put(4, 0);
        put(5, 0);
    }};

    public Map<Integer, Integer> getUserWinningRanks(){
        return new HashMap<Integer, Integer>(userWinningRanks);
    }

    public int compareLotto(List<Integer> userNums, List<Integer> winningNums){
        int sameNum = 0, userNumIndex = 0, winningNumIndex = 0;
        while(userNumIndex<7&&winningNumIndex<7){
            if(userNums.get(userNumIndex)==winningNums.get(winningNumIndex)){
                sameNum++;
                winningNumIndex++;
                userNumIndex++;
            }
            if(userNums.get(userNumIndex)>winningNums.get(winningNumIndex)){
                winningNumIndex++;
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
        userWinningRanks.put(8-sameNum, userWinningRanks.get(8-sameNum)+1);
    }
}
