package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constant.WinningAmountConstant;

public class WinningResult {
    //key: 해당 당첨 금액 enum 객체, value: 해당 로또 개수
    private final Map<WinningAmountConstant, Integer> result;

    public WinningResult(HashMap<WinningAmountConstant, Integer> result) {
        this.result = result;
    }

    public Integer getCountByRank(String rank) {
        return result.get(rank);
    }

    public int calculateWinningAmount() {
        List<WinningAmountConstant> keys = result.keySet().stream().toList();
        List<Integer> values = result.values().stream().toList();
        int sum = 0;

        for (int i = 0; i < keys.size(); i++) {
            sum += keys.get(i).getValue() * values.get(i);
        }

        return sum;
    }
}
