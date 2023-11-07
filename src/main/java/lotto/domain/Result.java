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

}
