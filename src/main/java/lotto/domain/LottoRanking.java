package lotto.domain;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LottoRanking {
    private int matchNumber;
    private HashMap<Integer,Integer> ranking;

    public LottoRanking(){
        HashMap<Integer,Integer> rank = new LinkedHashMap<>();
        rank.put(1,0);
        rank.put(2,0);
        rank.put(3,0);
        rank.put(4,0);
        rank.put(5,0);

        this.ranking=rank;
    }

    public HashMap<Integer, Integer> getRanking() {
        return ranking;
    }
    public void checkRanking(int count, boolean bonus){
        if(count <3){
            return;
        }
        if(count == 6){
            ranking.put(1, ranking.get(1) + 1 );
        }
        if( count == 5 && bonus){
            ranking.put(2, ranking.get(2) + 1 );
        }
        if( count == 5 && !bonus){
            ranking.put(3, ranking.get(3) + 1 );
        }
        if( count == 4 ){
            ranking.put(4, ranking.get(4) + 1 );
        }
        if( count == 3 ){
            ranking.put(5, ranking.get(5) + 1 );
        }

    }
}
