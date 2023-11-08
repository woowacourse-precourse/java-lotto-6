package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static lotto.LottoGenerator.LIMIT_NUMBER_COUNT;
import static lotto.LottoGenerator.MIN_NUMBER_RANGE;

public class Player {

    private int money;
    private List<Lotto> myLottos;
    private Map<Integer, Integer> lottoResultsMap;

    public Player(int money, List<Lotto> lottos){
        this.money = money;
        this.myLottos = lottos;
        initResultMap();
    }

    public void initResultMap(){
        lottoResultsMap = new HashMap<>();
        for(int rank=1; rank<LIMIT_NUMBER_COUNT; rank++){
            lottoResultsMap.put(rank, 0);
        }
    }

    public void checkMyLottoResults(List<Integer> winNumber, int bonus){
        for(Lotto lotto : myLottos){
            int division = lotto.getDrawResult(Set.copyOf(winNumber), bonus);
            if(division == LIMIT_NUMBER_COUNT){
                continue;
            }
            int prevValue = lottoResultsMap.get(division);
            lottoResultsMap.replace(division, prevValue+1);
        }
    }

    public String toStringMyLottoResults(){
        StringBuilder sb = new StringBuilder();
        for(int division = LIMIT_NUMBER_COUNT-1; division>0; division--){
            int divisionCount = lottoResultsMap.get(division);
            Division curDivision = Division.getEnumFromDivision(division);
            sb.append(
                    String.format("%s - %d개\n", curDivision, divisionCount)
            );
        }
        return sb.toString();
    }

    public long getTotalAmount(){
        long totalAmount = 0;
        for(int division = MIN_NUMBER_RANGE; division<LIMIT_NUMBER_COUNT; division++){
            int divisionAmount = Division.getEnumFromDivision(division).getAmount();
            int count = lottoResultsMap.get(division);
            totalAmount += (divisionAmount * 1.0) * count;
        }
        return totalAmount;
    }

    public double getRatioOfReturn(){
        return getTotalAmount()*100.0 / money;
    }

}
