package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Result {
    private Map<Reward,Integer> result;
    private String earningRate;

    public Result() {
        result = new HashMap<>();
        result.put(Reward.FAIL, 0);
        result.put(Reward.FIRST, 0);
        result.put(Reward.SECOND, 0);
        result.put(Reward.THIRD, 0);
        result.put(Reward.FOURTH, 0);
        result.put(Reward.FIFTH, 0);
    }

    public void addResult(Reward reward) {
        result.put(reward, result.get(reward) + 1);
    }

    public Map<Reward, Integer> getResult() {
        return result;
    }

    public String getEarningRate() {
        return earningRate;
    }

    public void setEarningRate(String earningRate) {
        this.earningRate = earningRate;
    }

    public long calculateTotalPrize(Result result){
        long totalPrize = 0;
        Map<Reward, Integer> finalResult =  result.getResult();
        for(Map.Entry<Reward, Integer> entry : finalResult.entrySet()){
            Reward reward = entry.getKey();
            int count = entry.getValue();
            if(count !=0){
                totalPrize += (long) reward.getPrize() *count;
            }

        }
        return totalPrize;
    }
}
