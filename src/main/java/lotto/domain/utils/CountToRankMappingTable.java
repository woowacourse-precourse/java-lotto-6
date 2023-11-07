package lotto.domain.utils;

import java.util.Map;

public class CountToRankMappingTable {

    private final Map<Long, Integer> map;


    public CountToRankMappingTable() {
        this.map = Map.ofEntries(
               Map.entry(6L, 1),
               Map.entry(5L,3),
               Map.entry(4L, 4),
               Map.entry(3L, 5)
       );
    }


    public Integer getRanking(long numberOfMatching, boolean matchBonus){
        if (numberOfMatching == 5L && matchBonus){
            return 2;
        }
        return map.get(numberOfMatching);
    }


}
