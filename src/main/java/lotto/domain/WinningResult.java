package lotto.domain;

import java.util.HashMap;

public class WinningResult {

    private static final long FIRST = 6;
    private static final long SECOND = 7;
    private static final long THIRD = 5;
    private static final long FOURTH = 4;
    private static final long FIFTH = 3;

    private static final long FIRSTPRIZE = 2000000000;
    private static final long SECONDPRIZE = 30000000;
    private static final long THIRDPRIZE = 1500000;
    private static final long FOURTHPRIZE = 500000;
    private static final long FIFTHPRIZE = 5000;

    private final HashMap<Long, Integer> winningResult;

    public WinningResult(HashMap<Integer, Integer> winningCounts) {
        this.winningResult = winningCountsToWinningResult(winningCounts);
    }

    private HashMap<Long, Integer> winningCountsToWinningResult(HashMap<Integer, Integer> winningCounts) {
        HashMap<Long,Integer> winningResult= new HashMap<>();
        winningResult.put(FIRST,winningCounts.getOrDefault(FIRST,0));
        winningResult.put(SECOND,winningCounts.getOrDefault(SECOND,0));
        winningResult.put(THIRD,winningCounts.getOrDefault(THIRD,0));
        winningResult.put(FOURTH,winningCounts.getOrDefault(FOURTH,0));
        winningResult.put(FIFTH,winningCounts.getOrDefault(FIFTH,0));
        return winningResult;
    }

    public int getFirstPrizeCount(){
        return winningResult.getOrDefault(FIRST,0);
    }

    public int getSecondPrizeCount(){
        return winningResult.getOrDefault(SECOND,0);
    }

    public int getThirdPrizeCount(){
        return winningResult.getOrDefault(THIRD,0);
    }

    public int getFourthPrizeCount(){
        return winningResult.getOrDefault(FOURTH,0);
    }

    public int getFifthPrizeCount(){
        return winningResult.getOrDefault(FIFTH,0);
    }

    public long getTotalLotteryPrize() {
        long prize = 0;
        prize +=FIRSTPRIZE*this.getFirstPrizeCount();
        prize +=SECONDPRIZE*this.getSecondPrizeCount();
        prize +=THIRDPRIZE*this.getThirdPrizeCount();
        prize +=FOURTHPRIZE*this.getFourthPrizeCount();
        prize +=FIFTHPRIZE*this.getFifthPrizeCount();
        return prize;
    }

}
