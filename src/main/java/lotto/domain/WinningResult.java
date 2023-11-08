package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.StringJoiner;
import lotto.constant.WinningAmountConstant;

public class WinningResult {
    //key: 해당 당첨 금액 enum 객체, value: 해당 로또 개수
    private final LinkedHashMap<WinningAmountConstant, Integer> result;

    public WinningResult(LinkedHashMap<WinningAmountConstant, Integer> result) {
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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        StringJoiner joiner = new StringJoiner("\n");
        List<WinningAmountConstant> keys = result.keySet().stream().toList();
        List<Integer> values = result.values().stream().toList();

        String format;
        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i).equals(WinningAmountConstant.SECOND)) {
                format = String.format("%d개 일치, 보너스 볼 일치 (%,d원) - %d개",
                        keys.get(i).getCount(), keys.get(i).getValue(), values.get(i));
                joiner.add(format);
                continue;
            }

             format = String.format("%d개 일치 (%,d원) - %d개",
                    keys.get(i).getCount(), keys.get(i).getValue(), values.get(i));

            joiner.add(format);
        }

        return joiner.toString();
    }
}
