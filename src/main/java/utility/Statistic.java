package utility;

import java.util.ArrayList;

public enum Statistic {
    FIFTH(3,"5000"),
    FORTH(4,"50000"),
    THIRD(5,"1500000"),
    SECOND(7,"30000000"),
    FIRST(6,"2000000000");

    private final int sameNumberCount;
    private final String prize;
    Statistic(int sameNumberCount, String prize){
        this.sameNumberCount = sameNumberCount;
        this.prize = prize;
    }

    public int getSameNumberCount(){
        return sameNumberCount;
    }
    public static ArrayList<String> getPrizeList(){
        ArrayList<String> prizes = new ArrayList<>();
        prizes.add(FIFTH.prize);
        prizes.add(FORTH.prize);
        prizes.add(THIRD.prize);
        prizes.add(SECOND.prize);
        prizes.add(FIRST.prize);
        return prizes;
    }
    public static ArrayList<Integer> getSameNumberCountList(){
        ArrayList<Integer> counts = new ArrayList<>();
        counts.add(FIFTH.sameNumberCount);
        counts.add(FORTH.sameNumberCount);
        counts.add(THIRD.sameNumberCount);
        counts.add(SECOND.sameNumberCount);
        counts.add(FIRST.sameNumberCount);
        return counts;
    }
}
