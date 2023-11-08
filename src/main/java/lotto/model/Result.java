package lotto.model;

import static lotto.model.LottoInfo.RANK_COUNT;

public class Result {
    private int[] results;

    public Result(){
        this.results= new int[RANK_COUNT];
    }
    public Result(int[] results){
        this.results = results;
    }
    public int[] getResults(){
        return results;
    }

    public int getTotalPrize(){
        int total=0;
        for(int idx=0;idx<results.length;idx++){
            total += results[idx]* LottoInfo.Prize.values()[idx].money;
        }
        return total;
    }
}
