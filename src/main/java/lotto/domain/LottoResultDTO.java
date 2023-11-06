package lotto.domain;

import java.util.HashMap;

public record LottoResultDTO(
        HashMap<String, Integer> matchMap,
        double totalRevenueRate

) {
}
