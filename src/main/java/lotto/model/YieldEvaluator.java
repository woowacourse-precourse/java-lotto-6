package lotto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class YieldEvaluator {
    private ArrayList<Integer> eachWinPrizes = new ArrayList<>();
    private int totalWinPrize;
    private final String TOTAL_RETURN;

    private static final Map<String,Integer> winPrize = new HashMap<>(){{
       put("5",5000);
       put("4",50000);
       put("3",1500000);
       put("2",30000000);
       put("1",2000000000);
    }};
    public YieldEvaluator(String[] ranks,int purchasePrice){
        getEachWinPrizes(ranks);
        addWinLottos();
        this.TOTAL_RETURN = String.valueOf(totalWinPrize / purchasePrice) ;
    }

    public String getTotalReturn(){
        return TOTAL_RETURN;
    }
    private void addWinLottos(){
        for(Integer winPrize : eachWinPrizes){
            totalWinPrize += winPrize;
        }
    }
    private void getEachWinPrizes(String[] ranks){
        for(String rank : ranks){
            eachWinPrizes.add(winPrize.get(rank));
        }
    }
}
