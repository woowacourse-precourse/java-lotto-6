package lotto;

import lotto.enums.MatchStatus;

import java.util.Map;
import java.util.TreeMap;

public class MatchStatusGatherer {
    private Map<MatchStatus, Integer> map;
    private int totalCount;
    private int totalReward;
    public MatchStatusGatherer(){
        this.totalCount = 0;
        this.totalReward = 0;
        this.map = new TreeMap<>();
        map.put(MatchStatus.CORRESPOND_3, 0);
        map.put(MatchStatus.CORRESPOND_4, 0);
        map.put(MatchStatus.CORRESPOND_5, 0);
        map.put(MatchStatus.CORRESPOND_5_AND_BONUS, 0);
        map.put(MatchStatus.CORRESPOND_6, 0);
        map.put(MatchStatus.FAIL, 0);
    }
    public void addMatchStatus(MatchStatus matchStatus){
        totalCount += 1;
        totalReward += matchStatus.reward;
        map.compute(matchStatus, (key, value)->value+1);
    }
    private double getTotalRate(){
        return (double)totalReward/(double) totalCount *Lotto.PRICE - 1;
    }
    public void printResult(){
        for(Map.Entry<MatchStatus, Integer> entry: map.entrySet()){
            MatchStatus m = entry.getKey();
            int count = entry.getValue();
            System.out.println(m.prompt + " - "+count+"개");
        }
        double totalRate = getTotalRate();
        System.out.println("총 수익률은 "
                +String.format("%.1f", totalRate)
                +"입니다.");
    }
}
