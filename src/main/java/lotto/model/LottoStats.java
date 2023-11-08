package lotto.model;

import java.util.LinkedHashMap;

public record LottoStats(LinkedHashMap<Rank, Integer> stats) {
}
