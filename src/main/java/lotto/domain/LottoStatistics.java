package lotto.domain;

import lotto.constant.LottoRank;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class LottoStatistics {

    private final EnumMap<LottoRank, Integer> result;

    public LottoStatistics(EnumMap<LottoRank, Integer> result) {
        result.remove(LottoRank.NOTHING);
        this.result = result;
    }

    @Override
    public String toString() {

        List<String> response = new ArrayList<>();

        result.forEach((rank, count) -> {
            response.add(buildLine(rank, count));
        });

        return String.join("\n", response);

    }

    private String buildLine(LottoRank rank, Integer count) {
        return rank.toString() + String.format(" - %d개", count);
    }

    public int getIncome() {
        return result.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

}
